package it.eng.unipa.projectwork.channel;

import it.eng.unipa.projectwork.channel.event.AuctionEvent;

public interface ChannelContainer {
	
	public boolean support(Channel channel);

	public void add(Channel channel);

	public void remove(Channel channel);

	public void sendEvent(AuctionEvent auctionEvent);
	

}
