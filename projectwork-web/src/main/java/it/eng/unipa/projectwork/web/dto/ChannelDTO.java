package it.eng.unipa.projectwork.web.dto;

public class ChannelDTO {
	
	private Long auctionOid;
	private String type;
	
	public ChannelDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ChannelDTO(String type) {
		this.type = type;
	}
	
	public Long getAuctionOid() {
		return auctionOid;
	}
	public void setAuctionOid(Long auctionOid) {
		this.auctionOid = auctionOid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
