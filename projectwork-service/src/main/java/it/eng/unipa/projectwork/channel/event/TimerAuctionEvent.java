package it.eng.unipa.projectwork.channel.event;

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

	@Override
	public String toJson() {
		return "{type:\""+getType()+",\"auctionOid\":"+getAuctionOid()+",\"ttl\":"+getTtl()+"}";
	}

}
