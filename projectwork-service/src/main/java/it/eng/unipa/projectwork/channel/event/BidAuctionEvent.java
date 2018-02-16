package it.eng.unipa.projectwork.channel.event;

import java.math.BigDecimal;

import it.eng.unipa.projectwork.channel.AuctionEvent;

public class BidAuctionEvent extends AuctionEvent {
	
	private static final long serialVersionUID = 1L;

	private BigDecimal importo;

	public BidAuctionEvent(Long auctionOid,BigDecimal importo) {
		super(auctionOid,"BID");
		this.importo = importo;
	}
	
	public BigDecimal getImporto() {
		return importo;
	}
	
}
