package it.eng.unipa.projectwork.channel;


import javax.websocket.Session;

import it.eng.unipa.projectwork.channel.event.AuctionEvent;

public class WSChannel extends AbstractChannel {
	
	private Session session;
	
	public WSChannel(Session session,String username) {
		super(WSChannelContainer.WEBSOCKET, username);
		this.session = session;
	}

	@Override
	public void sendAuctionEvent(AuctionEvent message) {
		session.getAsyncRemote().sendText(message.toJson());
	}
	
	@Override
	public boolean isOpen() {
		return this.session.isOpen();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this == obj || ( obj instanceof WSChannel && this.session.equals(((WSChannel)obj).session));
	}
	
	@Override
	public int hashCode() {
		return this.session.hashCode();
	}

}
