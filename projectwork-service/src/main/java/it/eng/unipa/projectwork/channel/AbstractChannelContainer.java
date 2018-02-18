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
@Lock(LockType.WRITE)
public abstract class AbstractChannelContainer implements ChannelContainer{
	
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
	
	
	private Map<String,Channel> userChannel = new HashMap<>();
	
	private Map<Long,List<Channel>> channelMap = new HashMap<Long,List<Channel>>(){
		
		
		public java.util.List<Channel> get(Object key) {
			List<Channel> channels = super.get(key);
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
	
	
	public abstract boolean support(Channel channel);
	
	@Override
	public void add(String username,Long auctionOid) {
				Channel channel = userChannel.get(username);
				List<Channel> channels = channelMap.get(auctionOid);
				if(channel!=null && !channels.contains(channel)){
					channels.add(channel);
			
				}
	}
	
	@Override
	public void remove(String username,Long auctionOid) {
				Channel channel = userChannel.get(username);
				List<Channel> channels = channelMap.get(auctionOid);
				if(channel!=null){
					channels.remove(channel);
				}
	}
	
	@Override
	public void remove(Channel channel){
		
		if(support(channel)){
			userChannel.remove(channel.getUsername());
			for(List<Channel> channels : channelMap.values()){
				channels.remove(channel);
			}
		}
	}
	
	@Override
	public void add(Channel channel){
		
			Channel old = userChannel.put(channel.getUsername(),channel);
			for(List<Channel> channels : channelMap.values()){
				if(channels.remove(old)){
					channels.add(channel);
				}
			}
	}
	
	@Override
	@Asynchronous
	public void sendEvent(AuctionEvent auctionEvent){
			List<Channel> toRemoves = new ArrayList<>();
			List<Channel> channels = channelMap.get(auctionEvent.getAuctionOid());
			for(Channel channel : channels){
				if(channel.isOpen()){
					channel.sendAuctionEvent(auctionEvent);
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
		
	}
	
	
}
