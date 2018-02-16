package it.eng.unipa.projectwork.channel;

public interface Channel {
	
	public String getType();
	
	public void sendEvent(AuctionEvent auctionEvent);
	
	

}
