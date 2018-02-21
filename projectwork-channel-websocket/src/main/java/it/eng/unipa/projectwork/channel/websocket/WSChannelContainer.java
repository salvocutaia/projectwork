package it.eng.unipa.projectwork.channel.websocket;



import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import it.eng.unipa.projectwork.channel.AbstractChannelContainer;
import it.eng.unipa.projectwork.channel.Channel;

@Singleton
@Startup
@DependsOn(value="MultiChannelContainer")
public class WSChannelContainer extends AbstractChannelContainer<WSChannel>{
	

	public static final String WEBSOCKET = "WEBSOCKET";

	
	public WSChannelContainer() {
	}
	
	
	public boolean support(Channel channel){
		return channel.getClass().equals(WSChannel.class);
	}
	
	
	@Override
	public String getType() {
		return WEBSOCKET;
	}
	
	
	

}
