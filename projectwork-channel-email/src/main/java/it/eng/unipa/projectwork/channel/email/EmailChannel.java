package it.eng.unipa.projectwork.channel.email;


import it.eng.unipa.projectwork.channel.AbstractChannel;
import it.eng.unipa.projectwork.channel.event.AuctionEvent;
import it.eng.unipa.projectwork.email.Message;
import it.eng.unipa.projectwork.email.SendMail;
import it.eng.unipa.projectwork.email.exception.MailNotSendException;
import it.eng.unipa.projectwork.email.Message.TYPE;

public class EmailChannel extends AbstractChannel {
	
	private String email;
	
	public EmailChannel(String username,String email) {
		super(EmailChannelContainer.EMAIL, username);
		this.email = email;
	}
	
	
	private SendMail sendMail;
	
	protected void setEmailSend(SendMail sendMail){
		this.sendMail = sendMail;
	}

	@Override
	public void sendAuctionEvent(AuctionEvent message) {
		if(sendMail==null){
			throw new RuntimeException("sendemail is null");
		}
		String subject = "New bid for Auction "+message.getAuctionOid();
		String body = "Dear <b>"+getUsername()+"</b><br/>the auction <b>"+"</b> has a new event: <b style=\"color:red\">"+message.toJson()+"</b>";
		try {
			sendMail.sendMail(new Message(subject, body, TYPE.HTML), this.email);
		} catch (MailNotSendException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----> notifico EMAIL a "+getUsername()+" "+message.toJson());
	}
	
	@Override
	public boolean isOpen() {
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this == obj || ( obj instanceof EmailChannel && this.email.equals(((EmailChannel)obj).email));
	}
	
	@Override
	public int hashCode() {
		return this.email.hashCode();
	}

}
