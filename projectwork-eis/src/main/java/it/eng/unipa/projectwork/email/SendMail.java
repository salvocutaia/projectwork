package it.eng.unipa.projectwork.email;

import javax.ejb.Local;

import it.eng.unipa.projectwork.email.exception.MailNotSendException;

@Local
public interface SendMail {
	
	public void sendMailAllUser(Message message) throws MailNotSendException;
	public void sendMail(Message message,String destination) throws MailNotSendException;

}
