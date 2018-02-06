package it.eng.unipa.projectwork.service.test;

import java.io.FileNotFoundException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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

public abstract class ServiceTest<T,X extends T> {

    private static EntityManagerFactory emf;
    private static DAO dao;
    protected T service;
    
    public ServiceTest() {
		
	}

    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        emf = Persistence.createEntityManagerFactory("ProjectWorkTest");
        dao = new DAOImpl();
        ((InternalDAO)dao).setEntityManager(emf.createEntityManager());
    }
    
    
    
    protected T getService(){
    	service = createService();
        ((InternalService)service).setDAO(dao);
        return service;
    }
    

	private T createService(){
		try{
			Type t = getClass().getGenericSuperclass();
			ParameterizedType pt = (ParameterizedType) t;
			Class<X> beanClass = (Class<X>) pt.getActualTypeArguments()[1];
			return beanClass.newInstance();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
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