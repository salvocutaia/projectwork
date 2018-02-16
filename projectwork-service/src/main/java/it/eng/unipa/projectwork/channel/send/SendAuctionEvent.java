package it.eng.unipa.projectwork.channel.send;

import javax.ejb.Local;

import it.eng.unipa.projectwork.channel.event.AuctionEvent;


@Local
public interface SendAuctionEvent {

	public void sendAuctionEvent(AuctionEvent auctionEvent);
	
}
