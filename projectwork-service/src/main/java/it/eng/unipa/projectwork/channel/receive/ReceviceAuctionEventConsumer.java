package it.eng.unipa.projectwork.channel.receive;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import it.eng.unipa.projectwork.channel.MultiChannelContainer;
import it.eng.unipa.projectwork.channel.event.AuctionEvent;

@MessageDriven(name = "ReceviceAuctionEventConsumer", mappedName = "ReceviceAuctionEventConsumer", messageListenerInterface = MessageListener.class,
activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/topic/AuctionEvent"),
		@ActivationConfigProperty(propertyName = "connectionFactoryJndiName", propertyValue = "java:/JmsXA")
})
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ReceviceAuctionEventConsumer implements MessageListener {

	@EJB
	MultiChannelContainer multiChannelContainer;
	
	@Override
	public void onMessage(Message msg) {
		try {
			ObjectMessage objMessage = (ObjectMessage) msg;
			AuctionEvent auctionEvent = (AuctionEvent)objMessage.getObject();
			multiChannelContainer.sendEvent(auctionEvent);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
