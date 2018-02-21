package it.eng.unipa.projectwork.channel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Asynchronous;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;

import it.eng.unipa.projectwork.channel.event.AuctionEvent;
import it.eng.unipa.projectwork.channel.event.ClosedAuctionEvent;


@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Lock(LockType.READ)
public abstract class AbstractChannelContainer<T extends Channel> implements ChannelContainer<T>{
	
	@EJB
	MultiChannelContainer multiChannelContainer;
	
	@PostConstruct
	public void register(){
		System.out.println("--------->registro "+this);
		this.multiChannelContainer.register(this);
	}
	
	@PreDestroy
	protected void unregister(){
		System.out.println("--------->deregistro "+this);
		this.multiChannelContainer.unregister(this);
	}
	
	
	private Map<String,T> userChannel = new HashMap<>();
	
	private Map<Long,List<T>> channelMap = new HashMap<Long,List<T>>(){
		
		
		public java.util.List<T> get(Object key) {
			List<T> channels = super.get(key);
			if(channels==null){
				synchronized (this) {
					channels = super.get(key);
					if(channels==null){
						channels = new ArrayList<>();
						this.put((Long)key, channels);
					}
				}
			}
			return channels;
		};
		
	};
	
	
	@Override
	@Lock(LockType.WRITE)
	public void add(String username,Long auctionOid) {
		T channel = userChannel.get(username);
		List<T> channels = channelMap.get(auctionOid);
		if(channel!=null && !channels.contains(channel)){
			channels.add(channel);
	
		}
	}
	
	@Override
	@Lock(LockType.WRITE)
	public void remove(String username,Long auctionOid) {
		T channel = userChannel.get(username);
		List<T> channels = channelMap.get(auctionOid);
		if(channel!=null){
			channels.remove(channel);
		}
	}
	
	@Override
	@Lock(LockType.WRITE)
	public void remove(T channel){
		userChannel.remove(channel.getUsername());
		for(List<T> channels : channelMap.values()){
			channels.remove(channel);
		}
	}
	
	@Override
	@Lock(LockType.WRITE)
	public void add(T channel){
			Channel old = userChannel.put(channel.getUsername(),channel);
			for(List<T> channels : channelMap.values()){
				if(channels.remove(old)){
					channels.add(channel);
				}
			}
	}
	
	@Override
	@Asynchronous
	public void sendEvent(AuctionEvent auctionEvent){
			beforeAllSend(auctionEvent);
			List<T> toRemoves = new ArrayList<>();
			List<T> channels = channelMap.get(auctionEvent.getAuctionOid());
			for(T channel : channels){
				if(channel.isOpen()){
					beforeSend(channel);
					channel.sendAuctionEvent(auctionEvent);
					afterSend(channel);
				}else{
					toRemoves.add(channel);
				}
			}
			for(Channel toRemove : toRemoves){
				channels.remove(toRemove);
			}
			
			if(auctionEvent instanceof ClosedAuctionEvent){
				channelMap.remove(auctionEvent.getAuctionOid());
			}
			afterAllSend(auctionEvent);
		
	}
	
	@Override
	public boolean verify(String username, Long auctionOid) {
		T c = userChannel.get(username);
		List<T> channels = channelMap.get(auctionOid);
		return c!=null && channels.contains(c);

	}
	
	protected void beforeAllSend(AuctionEvent auctionEvent){
		
	}
	
	protected void beforeSend(T t){
		
	}
	
	protected void afterSend(T t){
		
	}
	
	protected void afterAllSend(AuctionEvent auctionEvent){
		
	}
	
	

	
}
