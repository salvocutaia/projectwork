package it.eng.projectwork.wsdl.auction_01;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.ws.BindingProvider;

import it.eng.projectwork.xsd.auction_01.CreateAuctionRequestType;
import it.eng.projectwork.xsd.auction_01.CreateAuctionResponseType;

public class Main {
	
	public static void main(String[] args) throws MalformedURLException, AuctionFault {
		AuctionService as = new AuctionServiceService(new URL("http://localhost:8080/projectwork-ws/AuctionService?wsdl")).getAuctionServicePort();
		
		BindingProvider prov = (BindingProvider)as;
		prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "giacompa");
		prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "giacompa");
		
		
		CreateAuctionResponseType r = as.createAuction(new CreateAuctionRequestType());
	}

}
