package it.eng.unipa.projectwork.dao.test;

import org.junit.Test;

import it.eng.unipa.projectwork.model.Auction;
import it.eng.unipa.projectwork.model.Product;
import it.eng.unipa.projectwork.model.Supplier;

import java.util.List;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DAOTestImpl extends DAOTest {
	
	private String username = "giacompa";
	
	@Test
    public void t_001_testPersist_success() {
        
        Product product1 = new Product("description prod 1");
        Product product2 = new Product("description prod 2");
        
        dao.persist(product1,username);
        dao.persist(product2,username);
        
        Supplier supplier = new Supplier("info");
		
        dao.persist(supplier,username);
        
        dao.persist(new Auction("title 1","description 1",supplier,product1),username);
        dao.persist(new Auction("title 2","description 2",supplier,product2),username);

        List<Auction> auctions = dao.find(Auction.class,"Auction.getAll");

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
        List<Auction> books = dao.find(Auction.class,"Auction.getAll");
        assertEquals(2, books.size());
    }


    @Test
    public void t_004_testDelete_success(){
        Auction book = dao.load(Auction.class, 1l);

        dao.remove(book);

        List<Auction> books = dao.find(Auction.class,"Auction.getAll");

        assertEquals(1, books.size());
    }
    
    @Test
    public void t_005_testDelete_success(){
        Auction book = dao.load(Auction.class, 2l);

        dao.remove(book);

        List<Auction> books = dao.find(Auction.class,"Auction.getAll");

        assertEquals(0, books.size());
    }

}