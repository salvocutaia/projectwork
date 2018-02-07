package it.eng.unipa.projectwork.web;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import it.eng.unipa.projectwork.model.Auction;
import it.eng.unipa.projectwork.service.AuctionService;
import it.eng.unipa.projectwork.service.LazyList;

/*import it.eng.book.auction.event.ClosedAuctionEvent;
import it.eng.book.auction.event.OfferAuctionEvent;
import it.eng.book.auction.event.TimerAuctionEvent;
import it.eng.book.service.AuctionEventManager;*/

@Path("/auction")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@Stateless
public class AuctionRestEndpoint {
	
	
	@EJB
	AuctionService auctionService;
	
	@GET
    @Path("/")
    public String hello(){
		return "{\"ciao\":\"ok\"}";
	}
	
	@GET
    @Path("/list")
    public LazyList<Auction> list(){
		return auctionService.loadAuctions();
	}
	
	//@Inject
	//AuctionEventManager messageManager;
	/*
   	@GET
    @Path("/offer")
    @Produces({ "application/json" })
    public String offer(@QueryParam("auctionId")String auctionId,@QueryParam("importo") BigDecimal importo) {
   		messageManager.sendAuctionEvent(new OfferAuctionEvent(auctionId, importo));
        return "{\"result\":\"OK\"}";
    }
   	
   	
   	@GET
    @Path("/ttl")
    @Produces({ "application/json" })
    public String ttl(@QueryParam("auctionId")String auctionId,@QueryParam("ttl") long ttl) {
   		messageManager.sendAuctionEvent(new TimerAuctionEvent(auctionId, ttl));
        return "{\"result\":\"OK\"}";
    }
   	
   	@GET
    @Path("/close")
    @Produces({ "application/json" })
    public String close(@QueryParam("auctionId")String auctionId) {
   		messageManager.sendAuctionEvent(new ClosedAuctionEvent(auctionId));
        return "{\"result\":\"OK\"}";
    }
    */

}
