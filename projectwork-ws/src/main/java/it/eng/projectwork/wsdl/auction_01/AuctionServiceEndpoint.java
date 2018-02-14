package it.eng.projectwork.wsdl.auction_01;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.soap.MTOM;

import org.apache.commons.io.IOUtils;

import it.eng.projectwork.xsd.auction_01.CreateAuctionRequestType;
import it.eng.projectwork.xsd.auction_01.CreateAuctionResponseType;
import it.eng.projectwork.xsd.auction_01.FaultMessageType;
import it.eng.projectwork.xsd.auction_01.ImageType;
import it.eng.unipa.projectwork.model.Auction;
import it.eng.unipa.projectwork.model.Image;
import it.eng.unipa.projectwork.model.Product;

import static it.eng.projectwork.wsdl.util.Utils.*;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
@WebService(name = "AuctionService", targetNamespace = "http://it/eng/projectwork/wsdl/auction_01",wsdlLocation = "/WEB-INF/wsdl/auction_services_01.01.wsdl")
//@WebService(serviceName = "AuctionService", targetNamespace = "http://it/eng/projectwork/wsdl/auction_01", portName = "AuctionServicePort", endpointInterface = "it.eng.ontoir.wsdl.ontoir_01.OntoirService", wsdlLocation = "/META-INF/wsdl/OntoirService.wsdl")
//@BindingType(SOAPBinding.SOAP11HTTP_BINDING)
@MTOM
public class AuctionServiceEndpoint implements AuctionService {
	
	@Resource
	WebServiceContext context;
	
	@EJB
	it.eng.unipa.projectwork.service.AuctionService auctionService; 
	
	@Override
	@RolesAllowed("ADMIN")
	public CreateAuctionResponseType createAuction(CreateAuctionRequestType parameter) throws AuctionFault {
		try{
		
			
			
			Auction auction = new Auction();
			auction.setDescription(parameter.getAuction().getDescription());
			auction.setTitle(parameter.getAuction().getTitle());
			auction.setStartAuction(getTimestamp(parameter.getAuction().getStartDate()));
			auction.setEndAuction(getTimestamp(parameter.getAuction().getEndDate()));
			if(parameter.getAuction().getOidProduct()!=null){
				auction.setProduct(new Product(parameter.getAuction().getOidProduct()));
			}else{
				auction.setProduct(new Product(parameter.getAuction().getProduct().getDescription(), parameter.getAuction().getProduct().getImages().stream().map((e)->{return new Image(e.getFileName(),e.getContentType(),toByteArray(e.getBody()));}).collect(Collectors.toList())));
			}
			auctionService.add(auction, context.getUserPrincipal().getName());
			
			
			return new CreateAuctionResponseType();
		}catch (Exception e) {
			FaultMessageType r = new FaultMessageType();
			r.setDescriptionError(e.getMessage());
			throw new AuctionFault("Errore durante la creazione di un Action",r );
		}
	}

}
