package it.eng.unipa.projectwork.web.dto;

import java.math.BigDecimal;

public class BidDTO {

	private long auctionOid;
	private long auctionVersion;
	private BigDecimal price;
	public long getAuctionOid() {
		return auctionOid;
	}
	public void setAuctionOid(long auctionOid) {
		this.auctionOid = auctionOid;
	}
	public long getAuctionVersion() {
		return auctionVersion;
	}
	public void setAuctionVersion(long auctionVersion) {
		this.auctionVersion = auctionVersion;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	
}
