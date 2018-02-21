package it.eng.unipa.projectwork.channel.send;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.Topic;

import it.eng.unipa.projectwork.channel.event.AuctionEvent;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class SendAuctionEventImpl implements SendAuctionEvent{
	
	@Resource(mappedName="java:/JmsXA")
	QueueConnectionFactory connectionFactory;
	
	@Resource(mappedName="java:/jms/topic/AuctionEventTopic")
	Topic topic;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void sendAuctionEvent(AuctionEvent message) {
		try{
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession();
			ObjectMessage objMessage = session.createObjectMessage(message);
			MessageProducer createProducer = session.createProducer(topic);
			createProducer.send(objMessage);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
