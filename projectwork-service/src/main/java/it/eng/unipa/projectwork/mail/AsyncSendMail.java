package it.eng.unipa.projectwork.mail;

import java.util.List;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import it.eng.unipa.projectwork.email.SendMail;
import it.eng.unipa.projectwork.model.User;
import it.eng.unipa.projectwork.service.UserService;
@MessageDriven(name = "AsyncSendMail", mappedName = "AsyncSendMail", messageListenerInterface = MessageListener.class,
activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/EmailQueue")
})
public class AsyncSendMail implements MessageListener{
	
	@EJB
	UserService userService;
	
	@EJB
	SendMail sendMail;

	@Override
	public void onMessage(Message message) {
		try{
			MapMessage mapMessage = ((MapMessage)message);
			String subject = mapMessage.getString("SUBJECT");
			String body = mapMessage.getString("BODY");
			List<User> users = userService.allUsers();
			for(User user : users){
				sendMail.sendMail(new it.eng.unipa.projectwork.email.Message(subject, body), user.getEmail());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
