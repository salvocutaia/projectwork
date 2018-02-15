package it.eng.unipa.projectwork.dao.test;

import org.junit.Test;

import it.eng.unipa.projectwork.model.Auction;
import it.eng.unipa.projectwork.model.Product;
import it.eng.unipa.projectwork.model.Supplier;
import it.eng.unipa.projectwork.model.pricingstrategy.PRICING;
import it.eng.unipa.projectwork.query.QUERY;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DAOTestImpl extends DAOTest {
	
	
	@Test
    public void t_001_testPersist_success() {
        
        Product product1 = new Product("description prod 1",new ArrayList<>());
        Product product2 = new Product("description prod 2",new ArrayList<>());
        
        dao.persist(product1);
        dao.persist(product2);
        
        Supplier supplier = new Supplier();
        supplier.setInfo("info");
		
        dao.persist(supplier);
        
        dao.persist(new Auction("title 1","description 1",supplier,product1,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()+24*60*60*1000),PRICING.UPWARDS,true));
        dao.persist(new Auction("title 2","description 2",supplier,product2,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()+24*60*60*1000),PRICING.UPWARDS,true));

        List<Auction> auctions = dao.find(Auction.class,QUERY.AUCTION.GET_ALL.NAME);

        assertNotNull(auctions);
        assertEquals(2, auctions.size());
    }

    @Test
    public void t_002_testGetObjectById_success() {
        Auction book = dao.load(Auction.class, 1l);
        assertNotNull(book);
    }

    @Test
    public void t_003_testGetAll_success() {
        List<Auction> books = dao.find(Auction.class,QUERY.AUCTION.GET_ALL.NAME);
        assertEquals(2, books.size());
    }
    
    @Test
    public void t_004_testGET_FROM_PRODUCT_success() {
    	
    	Product p = dao.load(Product.class, 1L);
    	
        Map<String,Object> map = new HashMap<>();
        map.put(QUERY.AUCTION.GET_FROM_PRODUCT.PARAMS.PRODUCT,p);
		List<Auction> books = dao.find(Auction.class,QUERY.AUCTION.GET_FROM_PRODUCT.NAME,map );
        
        assertEquals(1, books.size());
    }
    
    @Test
    public void t_005_testGET_FROM_SUPPLIER_success() {
    	
    	
        Map<String,Object> map = new HashMap<>();
        map.put(QUERY.AUCTION.GET_FROM_SUPPLIER.PARAMS.USERNAME_SUPPLIER,1L);
		List<Auction> books = dao.find(Auction.class,QUERY.AUCTION.GET_FROM_SUPPLIER.NAME,map );
        
        assertEquals(1, books.size());
    }


    @Test
    public void t_005_testDelete_success(){
        Auction book = dao.load(Auction.class, 1l);

        dao.remove(book);

        List<Auction> books = dao.find(Auction.class,QUERY.AUCTION.GET_ALL.NAME);

        assertEquals(1, books.size());
    }
    
    @Test
    public void t_006_testDelete_success(){
        Auction book = dao.load(Auction.class, 2l);

        dao.remove(book);

        List<Auction> books = dao.find(Auction.class,QUERY.AUCTION.GET_ALL.NAME);

        assertEquals(0, books.size());
    }

}