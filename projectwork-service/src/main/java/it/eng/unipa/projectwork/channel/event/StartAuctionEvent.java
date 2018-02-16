package it.eng.unipa.projectwork.channel.event;

import it.eng.unipa.projectwork.channel.AuctionEvent;

public class StartAuctionEvent extends AuctionEvent {
	
	private static final long serialVersionUID = 1L;

	public StartAuctionEvent(Long auctionOid) {
		super(auctionOid,"CLOSED");
	}
	

}
