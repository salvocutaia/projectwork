package it.eng.unipa.projectwork.channel;

public abstract class AbstractChannel implements Channel {
	
	private final String type;
	private final String  username;
	
	public AbstractChannel(String type,String username) {
		this.type = type;
		this.username = username;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}
