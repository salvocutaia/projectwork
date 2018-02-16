package it.eng.unipa.projectwork.channel;



import javax.ejb.DependsOn;
import javax.ejb.Singleton;

@Singleton
@DependsOn(value="MultiChannelContainer")
public class WSChannelContainer extends AbstractChannelContainer{
	

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
