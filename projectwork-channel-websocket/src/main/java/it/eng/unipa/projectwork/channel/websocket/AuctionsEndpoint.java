package it.eng.unipa.projectwork.channel.websocket;


import javax.ejb.EJB;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import it.eng.unipa.projectwork.channel.WSChannel;
import it.eng.unipa.projectwork.channel.WSChannelContainer;

@ServerEndpoint(
		value="/ws/auction/",
		decoders = SampleDecoder.class,
		encoders = SampleEncoder.class
)
public class AuctionsEndpoint {
	
	
	@EJB
	WSChannelContainer wsChannelContainer;
	
    @OnMessage
    public Message auctionObserver(Session session,Message message) {
    	
    	
    	return message;
    }
    
    @OnOpen
    public void registry(Session session) {
		String username = session.getUserPrincipal().getName();
		wsChannelContainer.add(new WSChannel(session, username));
    }
    
    @OnClose
    public void unregistry(Session session,CloseReason reason) {
    	String username = session.getUserPrincipal().getName();
    	wsChannelContainer.remove(new WSChannel(session,username));
    }
    
    @OnError
    public void onError(Session session, Throwable throwable) {
    	String username = session.getUserPrincipal().getName();
    	wsChannelContainer.remove(new WSChannel(session,username));
    }
    

    
}