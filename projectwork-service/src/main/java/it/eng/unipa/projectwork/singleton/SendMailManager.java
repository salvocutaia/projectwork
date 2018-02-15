package it.eng.unipa.projectwork.singleton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;

import it.eng.unipa.projectwork.email.Message;
import it.eng.unipa.projectwork.email.SendMail;
import it.eng.unipa.projectwork.email.exception.MailNotSendException;
import it.eng.unipa.projectwork.model.Auction;
import it.eng.unipa.projectwork.service.AuctionService;
import it.eng.unipa.projectwork.service.LazyList;

@Singleton
@Startup
public class SendMailManager {
	
	
	@EJB
	AuctionService auctionService;
	
	
	@EJB
	SendMail sendMail;
	
	/**
	 * 
	@Timeout
	public void timeout(Timer timer) {
	    System.out.println("TimerBean: timeout occurred");
	}
	 * @param timer
	 */
	
	@Schedules ({
		@Schedule(minute="0",hour="*")
		/*,
	    @Schedule(dayOfMonth="Last")
	    @Schedule(dayOfWeek="Fri", hour="23")
	    */
	})
	public void sendMail(){
		LazyList<Auction> l = auctionService.loadAuctions(0,0);
		String today = new SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date());
		String subject = "Active auctions now: "+today;
		String body = body(l.getResults());
		
		try {
			sendMail.sendMailAllUser(new Message(subject, body));
		} catch (MailNotSendException e) {
			
			e.printStackTrace();
		}
	}
	
	
	private String body(List<Auction> as){
		StringBuilder sb = new StringBuilder("<table>");
		sb.append("<tr><th>").append("title").append("</th>").append("<th>").append("description").append("</th></tr>");
		for(Auction a : as){
			sb.append("<tr><th>").append(a.getTitle()).append("</th>").append("<th>").append(a.getDescription()).append("</th></tr>");
			
		}
		sb.append("</table>");
		return sb.toString();
	}
}
