package it.eng.unipa.projectwork.channel;



import javax.ejb.DependsOn;
import javax.ejb.Singleton;

@Singleton
@DependsOn(value="MultiChannelContainer")
public class WSChannelContainer extends AbstractChannelContainer{
	
	public WSChannelContainer() {
	}
	
	
	public boolean support(Channel channel){
		return channel.getClass().equals(WSChannel.class);
	}
	
	
	
	
	
	

}
