package it.eng.unipa.projectwork.channel;

import it.eng.unipa.projectwork.channel.event.AuctionEvent;

public interface Channel {
	
	public String getType();
	
	public void sendAuctionEvent(AuctionEvent auctionEvent);
	
	public boolean isOpen();
	
	public String getUsername();
}
