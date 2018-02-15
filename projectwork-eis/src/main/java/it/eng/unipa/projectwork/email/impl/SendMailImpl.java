package it.eng.unipa.projectwork.email.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import it.eng.unipa.projectwork.email.Message;
import it.eng.unipa.projectwork.email.SendMail;
import it.eng.unipa.projectwork.email.exception.MailNotSendException;

@Stateless
public class SendMailImpl implements SendMail {
	
	
	@Resource
	Session mailSession;
	
	@Resource
	QueueConnectionFactory queueConnectionFactory;
	
	@Resource(mappedName="java:/jms/queue/EmailQueue")
	Queue queue;


	@Override
	public void sendMail(Message message, String destination) throws MailNotSendException {
		try{
			MimeMessage mimeMessage = new MimeMessage(mailSession);
			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(destination));
			mimeMessage.setSubject(message.getSubject());
			mimeMessage.setText(message.getBody());
			Transport.send(mimeMessage);
		}catch (Exception e) {
			throw new MailNotSendException(e);
		}
	}
	
	@Override
	public void sendMailAllUser(Message message) throws MailNotSendException {
		try{
			QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
			QueueSession queueSession = queueConnection.createQueueSession(true, javax.jms.Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = queueSession.createProducer(queue);
			MapMessage mapMessage = queueSession.createMapMessage();
			mapMessage.setString("SUBJECT", message.getSubject());
			mapMessage.setString("BODY", message.getBody());
			producer.send(mapMessage);
			queueSession.commit();
			queueSession.close();
			queueConnection.close();
		}catch (Exception e) {
			throw new MailNotSendException(e);
		}
	}

}
