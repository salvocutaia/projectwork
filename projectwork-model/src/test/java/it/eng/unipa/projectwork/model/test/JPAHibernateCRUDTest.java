package it.eng.unipa.projectwork.model.test;

import org.junit.Test;

import it.eng.unipa.projectwork.model.AEntity;
import it.eng.unipa.projectwork.model.Address;
import it.eng.unipa.projectwork.model.Auction;
import it.eng.unipa.projectwork.model.Product;
import it.eng.unipa.projectwork.model.Supplier;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JPAHibernateCRUDTest extends JPAHibernateTest {
	
	@Test
    public void t_001_testPersist_success() {
        em.getTransaction().begin();
        
        Product product1 = new Product("description prod 1",new ArrayList<>());
        setDate(product1);
        Product product2 = new Product("description prod 2",new ArrayList<>());
        setDate(product2);
        
        em.persist(product1);
        em.persist(product2);
        
        Supplier supplier = new Supplier();
        supplier.setUsername("giacompa");
        supplier.setEmail("giancarlo.compagno@eng.it");
        supplier.setTimeBirth(new Date());
        supplier.setAddress(new Address("90100","address","city"));
        supplier.setInfo("info");
        setDate(supplier);
        
        em.persist(supplier);
        
        Auction auction1 = new Auction("title 1","description 1",supplier,product1,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()+24*60*60*1000));
        setDate(auction1);
		
        em.persist(auction1);
        
        Auction auction2 = new Auction("title 2","description 2",supplier,product2,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()+24*60*60*1000));
        setDate(auction2);
        
		em.persist(auction2);
        em.getTransaction().commit();

        List<Auction> auctions = em.createNamedQuery("Auction.getAll", Auction.class).getResultList();

        assertNotNull(auctions);
        assertEquals(2, auctions.size());
    }

    @Test
    public void t_002_testGetObjectById_success() {
        Auction book = em.find(Auction.class, 1l);
        assertNotNull(book);
    }

    @Test
    public void t_003_testGetAll_success() {
        List<Auction> books = em.createNamedQuery("Auction.getAll", Auction.class).getResultList();
        assertEquals(2, books.size());
    }


    @Test
    public void t_004_testDelete_success(){
        Auction book = em.find(Auction.class, 1l);

        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();

        List<Auction> books = em.createNamedQuery("Auction.getAll", Auction.class).getResultList();

        assertEquals(1, books.size());
    }
    
    @Test
    public void t_005_testDelete_success(){
        Auction book = em.find(Auction.class, 2l);

        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();

        List<Auction> books = em.createNamedQuery("Auction.getAll", Auction.class).getResultList();

        assertEquals(0, books.size());
    }

    private void setDate(AEntity<?> a){
    	a.setDateInsertion(new Date());
    	a.setUsernameInsertion("giacompa");
    }
    
}