package it.eng.projectwork.wsdl.auction_01;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

import it.eng.projectwork.xsd.auction_01.CreateAuctionRequestType;
import it.eng.projectwork.xsd.auction_01.CreateAuctionResponseType;

@Stateless
@WebService(name = "AuctionService", targetNamespace = "http://it/eng/projectwork/wsdl/auction_01",wsdlLocation = "/WEB-INF/wsdl/auction_services_01.01.wsdl")
//@WebService(serviceName = "AuctionService", targetNamespace = "http://it/eng/projectwork/wsdl/auction_01", portName = "AuctionServicePort", endpointInterface = "it.eng.ontoir.wsdl.ontoir_01.OntoirService", wsdlLocation = "/META-INF/wsdl/OntoirService.wsdl")
//@BindingType(SOAPBinding.SOAP11HTTP_BINDING)
@RolesAllowed("ADMIN")
@MTOM
public class AuctionServiceEndpoint implements AuctionService {

	@Override
	public CreateAuctionResponseType createAuction(CreateAuctionRequestType parameter) throws AuctionFault {
		// TODO Auto-generated method stub
		return null;
	}

}
