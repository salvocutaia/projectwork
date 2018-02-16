package it.eng.unipa.projectwork.channel.event;

import it.eng.unipa.projectwork.channel.AuctionEvent;

public class SuspendAuctionEvent extends AuctionEvent {
	
	private static final long serialVersionUID = 1L;

	public SuspendAuctionEvent(Long auctionOid) {
		super(auctionOid,"CLOSED");
	}
	

}
