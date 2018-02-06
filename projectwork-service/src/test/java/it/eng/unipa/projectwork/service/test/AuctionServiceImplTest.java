package it.eng.unipa.projectwork.service.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import it.eng.unipa.projectwork.service.AuctionService;
import it.eng.unipa.projectwork.service.AuctionServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuctionServiceImplTest extends ServiceTest<AuctionService> {
	
	private String username = "giacompa";
	
	@Override
	protected AuctionService createService() {
		return new AuctionServiceImpl();
	}
	
	@Test
	public void test1(){
		
	}
	
}