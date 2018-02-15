package it.eng.unipa.projectwork.web;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import it.eng.unipa.projectwork.service.LazyArrayList;
import it.eng.unipa.projectwork.service.LazyList;
import it.eng.unipa.projectwork.web.dto.AddressDTO;
import it.eng.unipa.projectwork.web.dto.AuctionDTO;
import it.eng.unipa.projectwork.web.dto.AuctionFullDTO;
import it.eng.unipa.projectwork.web.dto.BidDTO;
import it.eng.unipa.projectwork.web.dto.ProductDTO;
import it.eng.unipa.projectwork.web.dto.SupplierDTO;

/*import it.eng.book.auction.event.ClosedAuctionEvent;
import it.eng.book.auction.event.OfferAuctionEvent;
import it.eng.book.auction.event.TimerAuctionEvent;
import it.eng.book.service.AuctionEventManager;*/

@Path("/auctionStub")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@Stateless
public class AuctionParticipationRestEndpoint2 {


	private List<AuctionDTO> getList(){
		List<AuctionDTO> ret = new ArrayList<>();

		try {

			AddressDTO address = new AddressDTO();
			address.setAddress("via roma 12");
			address.setCity("PAlermo");
			address.setPostCode("90100");

			ProductDTO product = new ProductDTO();
			product.setDescrition("prodotto aaaaa");
			product.setOid(1L);

			SupplierDTO supplier = new SupplierDTO();
			supplier.setEmail("sypplier-info@email.it");
			supplier.setInfo("Lorme Ipsum Supplier");
			supplier.setUsername("supplier-username");
			supplier.setAddress(address);



			AuctionDTO auction1 = new AuctionDTO();
			auction1.setOid(1L);
			auction1.setCurrentWinningPrice(new BigDecimal(2500.12));
			auction1.setDescription("Asta nr 1 lorem ipsue");
			auction1.setEndAuction(new SimpleDateFormat("dd/MM/yyyy'T'HH:mm:ss").parse("12/03/2018T10:00:00"));
			auction1.setPricing("UPWARDS");
			auction1.setProduct(product);
			auction1.setSupplier(supplier);
			auction1.setStartAuction(new SimpleDateFormat("dd/MM/yyyy'T'HH:mm:ss").parse("12/01/2018T11:30:00"));
			auction1.setTitle("Asta nr 1");
			auction1.setVersion(1L);

			ret.add(auction1);

			AuctionDTO auction2 = new AuctionDTO();
			auction2.setOid(2L);
			auction2.setCurrentWinningPrice(new BigDecimal(2500.12));
			auction2.setDescription("Asta nr 2 lorem ipsue");
			auction2.setEndAuction(new SimpleDateFormat("dd/MM/yyyy'T'HH:mm:ss").parse("12/03/2018T10:00:00"));
			auction2.setPricing("UPWARDS");
			auction2.setProduct(product);
			auction2.setSupplier(supplier);
			auction2.setStartAuction(new SimpleDateFormat("dd/MM/yyyy'T'HH:mm:ss").parse("12/01/2018T11:30:00"));
			auction2.setTitle("Asta nr 2");
			auction2.setVersion(1L);

			ret.add(auction2);

			AuctionDTO auction3 = new AuctionDTO();
			auction3.setOid(3L);
			auction3.setCurrentWinningPrice(new BigDecimal(2500.12));
			auction3.setDescription("Asta nr 3 lorem ipsue");
			auction3.setEndAuction(new SimpleDateFormat("dd/MM/yyyy'T'HH:mm:ss").parse("12/03/2018T10:00:00"));
			auction3.setPricing("UPWARDS");
			auction3.setProduct(product);
			auction3.setSupplier(supplier);
			auction3.setStartAuction(new SimpleDateFormat("dd/MM/yyyy'T'HH:mm:ss").parse("12/01/2018T11:30:00"));
			auction3.setTitle("Asta nr 2");
			auction3.setVersion(1L);

			ret.add(auction3);



		} catch (Exception e) {
			// nothing
		}
		return ret;
	}


	@GET
	@Path("/list")
	@RolesAllowed(value="USER")
	public List<AuctionDTO> list(){
		return getList();
	}


	@GET
	@Path("/get/{oid}")
	@RolesAllowed(value="USER")
	public AuctionFullDTO get(@PathParam("oid") long oid){
		//return Converter.convert(auctionService.loadAuctions(firstResult, maxResults),AuctionDTO.class);
		
		List<AuctionDTO> list = getList();
		
		AuctionFullDTO auctionFullDTO = null;
		
		for (AuctionDTO auctionDTO : list) {
			if(auctionDTO.getOid().equals(oid)) {
				auctionFullDTO = new AuctionFullDTO();
				
				auctionFullDTO.setCurrentWinningPrice(auctionDTO.getCurrentWinningPrice());
				auctionFullDTO.setDescription(auctionDTO.getDescription());
				auctionFullDTO.setEndAuction(auctionDTO.getEndAuction());
				auctionFullDTO.setOid(auctionDTO.getOid());
				auctionFullDTO.setPricing(auctionDTO.getPricing());
				auctionFullDTO.setProduct(auctionDTO.getProduct());
				auctionFullDTO.setStartAuction(auctionDTO.getStartAuction());
				auctionFullDTO.setSupplier(auctionDTO.getSupplier());
				auctionFullDTO.setTitle(auctionDTO.getTitle());
				auctionFullDTO.setVersion(auctionDTO.getVersion());
			}
		}
		
		
		List<Long> images = new ArrayList<>();

		images.add(1L);
		images.add(2L);
		images.add(3L);
		
		auctionFullDTO.setProductImagesOid(images);
		
			
		return auctionFullDTO;
	}

	@GET
	@Path("/getImage/{oidAuction}/{oidImage}")
	@RolesAllowed(value="USER")
	public byte[] getImage(@PathParam("oidAuction") long oidAuction, @PathParam("oidImage") long oidImage){
		//return Converter.convert(auctionService.loadAuctions(firstResult, maxResults),AuctionDTO.class);
		return null;
	}


	@POST
	@Path("/addBid")
	@RolesAllowed(value="USER")
	public BidDTO add(@Context SecurityContext sc, BidDTO bid){
		String username  = sc.getUserPrincipal().getName();
		
		
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
