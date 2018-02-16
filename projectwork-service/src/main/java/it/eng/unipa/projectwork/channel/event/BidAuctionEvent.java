package it.eng.unipa.projectwork.channel.event;

import java.math.BigDecimal;

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
