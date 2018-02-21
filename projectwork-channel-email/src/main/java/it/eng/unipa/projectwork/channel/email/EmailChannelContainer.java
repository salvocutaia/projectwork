package it.eng.unipa.projectwork.channel.email;



import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import it.eng.unipa.projectwork.channel.AbstractChannelContainer;
import it.eng.unipa.projectwork.email.SendMail;
import it.eng.unipa.projectwork.model.User;
import it.eng.unipa.projectwork.service.UserService;

@Singleton
@Startup
@DependsOn(value="MultiChannelContainer")
public class EmailChannelContainer extends AbstractChannelContainer<EmailChannel>{
	
	
	@EJB
	SendMail sendMail;
	
	@EJB
	UserService userService;
	
	public static final String EMAIL = "EMAIL";

	
	public EmailChannelContainer() {
	}
	
	
	
	@Override
	public String getType() {
		return EMAIL;
	}
	
	@Override
	protected void beforeSend(EmailChannel t) {
		t.setEmailSend(this.sendMail);
	}
	
	@Override
	protected void afterSend(EmailChannel t) {
		t.setEmailSend(null);
	}
	
	@Override
	public void add(String username, Long auctionOid) {
		User user = userService.getUser(username);
		String email = user.getEmail();
		super.add(new EmailChannel(username, email));
		super.add(username, auctionOid);
	}
	
}
