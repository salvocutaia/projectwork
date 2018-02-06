package it.eng.unipa.projectwork.service.test;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import it.eng.unipa.projectwork.dao.DAO;
import it.eng.unipa.projectwork.dao.InternalDAO;
import it.eng.unipa.projectwork.dao.impl.DAOImpl;
import it.eng.unipa.projectwork.service.InternalService;

public abstract class ServiceTest<T> {

    private EntityManagerFactory emf;
    private DAO dao;
    protected T service;
    
    public ServiceTest() {
		
	}

    @BeforeClass
    public void init() throws FileNotFoundException, SQLException {
        emf = Persistence.createEntityManagerFactory("ProjectWorkTest");
        dao = new DAOImpl();
        ((InternalDAO)dao).setEntityManager(emf.createEntityManager());
        service = createService();
        ((InternalService)service).setDAO(dao);
    }
    
    
    

	protected abstract T createService();

	@Before
    public void before(){
    	((InternalDAO)dao).begin();
    }
    
    @After
    public void after(){
    	((InternalDAO)dao).end();
    }

    @AfterClass
    public void tearDown(){
    	((InternalDAO)dao).close();
        emf.close();
    }
    
}