package it.eng.unipa.projectwork.dao.test;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import it.eng.unipa.projectwork.dao.DAO;
import it.eng.unipa.projectwork.dao.DAOImpl;
import it.eng.unipa.projectwork.dao.InternalDAO;

public class DAOTest {

    private static EntityManagerFactory emf;
    protected static DAO dao;

    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        emf = Persistence.createEntityManagerFactory("ProjectWorkTest");
        dao = new DAOImpl();
        ((InternalDAO)dao).setEntityManager(emf.createEntityManager());
    }
    
    @Before
    public void before(){
    	((InternalDAO)dao).begin();
    }
    
    @After
    public void after(){
    	((InternalDAO)dao).end();
    }

    @AfterClass
    public static void tearDown(){
    	((InternalDAO)dao).close();
        emf.close();
    }
}