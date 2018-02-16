package it.eng.unipa.projectwork.channel;

public abstract class AbstractChannel implements Channel {
	
	private final String type;
	private final Long oid;
	
	public AbstractChannel(String type,Long oid) {
		this.type = type;
		this.oid = oid;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public Long getAuctionOid() {
		return oid;
	}

}
