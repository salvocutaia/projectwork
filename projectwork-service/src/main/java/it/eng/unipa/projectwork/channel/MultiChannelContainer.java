package it.eng.unipa.projectwork.channel;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ejb.Asynchronous;
import javax.ejb.Singleton;

import it.eng.unipa.projectwork.channel.event.AuctionEvent;


@Singleton(name="MultiChannelContainer")
public class MultiChannelContainer {
	
	private Set<ChannelContainer<?>> channelContainers = new LinkedHashSet<>();
	
	public MultiChannelContainer() {}
	
	public boolean register(ChannelContainer<?> channelContainer){
		return this.channelContainers.add(channelContainer);
	}
	
	public boolean unregister(ChannelContainer<?> channelContainer){
		return this.channelContainers.remove(channelContainer);
	}
	
	
	@Asynchronous
	public void sendEvent(AuctionEvent auctionEvent){
		for(ChannelContainer<?> channelContainer : channelContainers){
			channelContainer.sendEvent(auctionEvent);
		}
	}
	
	
	public void add(String type,String username,Long auctionOid){
		for(ChannelContainer<?> cc : channelContainers){
			if(cc.getType().equals(type)){
				cc.add(username, auctionOid);
			}
		}
	}
	
	public void remove(String type,String username,Long auctionOid){
		for(ChannelContainer<?> cc : channelContainers){
			if(cc.getType().equals(type)){
				cc.remove(username, auctionOid);
			}
		}
	}
	
	
	public List<String> getTypes(){
		return channelContainers.stream().map(ChannelContainer::getType).collect(Collectors.toList());
	}
	
	public List<String> getTypes(String username,Long auctionOid){
		return channelContainers.stream().filter((c)->{return c.verify(username, auctionOid);}).map(ChannelContainer::getType).collect(Collectors.toList());
	}
	
}
