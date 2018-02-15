package it.eng.unipa.projectwork.web;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.modelmapper.ModelMapper;

import javax.ws.rs.core.SecurityContext;

import it.eng.unipa.projectwork.model.Auction;
import it.eng.unipa.projectwork.model.Image;
import it.eng.unipa.projectwork.service.AuctionService;
import it.eng.unipa.projectwork.web.dto.AuctionDTO;
import it.eng.unipa.projectwork.web.dto.AuctionFullDTO;
import it.eng.unipa.projectwork.web.dto.BidDTO;

/*import it.eng.book.auction.event.ClosedAuctionEvent;
import it.eng.book.auction.event.OfferAuctionEvent;
import it.eng.book.auction.event.TimerAuctionEvent;
import it.eng.book.service.AuctionEventManager;*/

@Path("/auction")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@Stateless
public class AuctionParticipationRestEndpoint {
	
	@EJB
	AuctionService auctionSevice;
	
	@GET
    @Path("/list")
	@RolesAllowed(value="USER")
    public List<AuctionDTO> list(){
		return ConverterUtils.convert(auctionSevice.loadActiveAuctions(), AuctionDTO.class);
	}
	
	
	@GET
    @Path("/get/{oid}")
	@RolesAllowed(value="USER")
    public AuctionFullDTO get(@PathParam("oid") long oid){
		Auction a = auctionSevice.loadAuction(oid);
		return ConverterUtils.convert(a, AuctionFullDTO.class,new ConverterUtils.ImageConverter());
	}
	
	@GET
    @Path("/getImage/{oidAuction}/{oidImage}")
	@RolesAllowed(value="USER")
    public Response getImage(@PathParam("oidAuction") long oidAuction, @PathParam("oidImage") long oidImage){
		Image image = auctionSevice.loadImage(oidAuction,oidImage);
		if (image==null) {
			throw new WebApplicationException(404);
		}
		ResponseBuilder rb = Response.ok(new ByteArrayInputStream(image.getBody()), image.getContentType());
		return rb.build();
	}

	
	@POST
	@Path("/addBid")
	@RolesAllowed(value="USER")
   public BidDTO add(@Context SecurityContext sc, BidDTO bid){
		String username  = sc.getUserPrincipal().getName();
		auctionSevice.addBid(bid.getAuctionOid(), bid.getAuctionVersion(), username, bid.getPrice());
		return bid;
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
