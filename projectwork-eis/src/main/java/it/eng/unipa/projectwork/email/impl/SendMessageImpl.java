package it.eng.unipa.projectwork.email.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import it.eng.unipa.projectwork.email.Message;
import it.eng.unipa.projectwork.email.SendMail;
import it.eng.unipa.projectwork.email.exception.MailNotSendException;

@Stateless
public class SendMessageImpl implements SendMail {
	
	
	@Resource
	Session mailSession;

	@Override
	public void sendMessage(Message message, String destination) throws MailNotSendException {
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

}
