package it.eng.unipa.projectwork.channel;

import it.eng.unipa.projectwork.channel.event.AuctionEvent;

public interface ChannelContainer<T extends Channel> {
	
	public void add(T channel);

	public void remove(T channel);
	
	public void add(String username,Long auctionOid);
	
	public boolean verify(String username,Long auctionOid);
	
	public void remove(String username,Long auctionOid);

	public void sendEvent(AuctionEvent auctionEvent);
	
	public String getType();
	
	

}
