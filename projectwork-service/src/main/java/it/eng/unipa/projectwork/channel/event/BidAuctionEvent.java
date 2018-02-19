package it.eng.unipa.projectwork.channel.event;

import java.math.BigDecimal;

public class BidAuctionEvent extends AuctionEvent {
	
	private static final long serialVersionUID = 1L;

	private BigDecimal pricing;
	private Long version;

	public BidAuctionEvent(Long auctionOid,Long version,BigDecimal pricing) {
		super(auctionOid,"BID");
		this.version = version;
		this.pricing = pricing;
	}
	
	public BigDecimal getPricing() {
		return pricing;
	}
	
	public Long getVersion() {
		return version;
	}

	@Override
	public String toJson() {
		return "{\"type\":\""+getType()+"\",\"version\":"+getVersion()+",\"auctionOid\":"+getAuctionOid()+",\"pricing\":"+getPricing()+"}";
	}
	
}
