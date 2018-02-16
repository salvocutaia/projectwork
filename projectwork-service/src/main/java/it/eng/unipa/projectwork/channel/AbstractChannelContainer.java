package it.eng.unipa.projectwork.channel;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Asynchronous;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.inject.Inject;

import it.eng.unipa.projectwork.channel.event.AuctionEvent;
import it.eng.unipa.projectwork.channel.event.ClosedAuctionEvent;
import it.eng.unipa.projectwork.channel.exception.ChannelNotSupportedException;

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
	public void add(Channel channel) {
		execute(channel,()->{
				List<Channel> channels = channelMap.get(channel.getAuctionOid());
				if(!channels.contains(channel)){
					channels.add(channel);
			
				}
		});
		
	}
	
	@Override
	public void remove(Channel channel){
		execute(channel,()->{
			List<Channel> channels = channelMap.get(channel.getAuctionOid());
			if(channels!=null){
				channels.remove(channel);
			}
		});
	}
	
	@Override
	@Asynchronous
	public void sendEvent(AuctionEvent auctionEvent){
		execute(()->{
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
		});
		
	}
	
	
	protected void execute(Execute execute){
		synchronized (this) {
			execute.execute();
		}
	}
	
	protected void execute(Channel channel,Execute execute){
		if(support(channel)){
			synchronized (this) {
				execute.execute();
			}
		}
	}
	
	@FunctionalInterface
	public interface Execute {
		

		public void execute();
		
		
	}
}
