package it.eng.unipa.projectwork.email;

import javax.ejb.Local;

import it.eng.unipa.projectwork.email.exception.MailNotSendException;

@Local
public interface SendMail {
	
	public void sendMessage(Message message,String destination) throws MailNotSendException;

}
