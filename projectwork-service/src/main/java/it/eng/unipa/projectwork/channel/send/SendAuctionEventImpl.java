package it.eng.unipa.projectwork.channel.send;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.Topic;

import it.eng.unipa.projectwork.channel.event.AuctionEvent;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class SendAuctionEventImpl implements SendAuctionEvent{
	
	@Resource(mappedName="java:/ConnectionFactory")
	QueueConnectionFactory connectionFactory;
	
	@Resource(mappedName="java:/jms/topic/AuctionEventTopic")
	Topic topic;


	@Override
	public void sendAuctionEvent(AuctionEvent message) {
		try{
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			ObjectMessage objMessage = session.createObjectMessage(message);
			MessageProducer createProducer = session.createProducer(topic);
			createProducer.send(objMessage);
			session.commit();
			session.close();
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
