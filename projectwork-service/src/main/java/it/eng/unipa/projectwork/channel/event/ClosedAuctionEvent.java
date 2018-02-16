package it.eng.unipa.projectwork.channel.event;

public class ClosedAuctionEvent extends AuctionEvent {
	
	private static final long serialVersionUID = 1L;

	public ClosedAuctionEvent(Long auctionOid) {
		super(auctionOid,"CLOSED");
	}
	
}
