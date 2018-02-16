package it.eng.unipa.projectwork.channel.event;

import it.eng.unipa.projectwork.channel.AuctionEvent;

public class TimerAuctionEvent extends AuctionEvent {
	
	private static final long serialVersionUID = 1L;

	private long ttl;

	public TimerAuctionEvent(Long auctionOid,long ttl) {
		super(auctionOid,"TIMER");
		this.ttl = ttl;
	}
	
	public long getTtl() {
		return ttl;
	}


}
