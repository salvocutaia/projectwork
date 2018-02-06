package it.eng.unipa.projectwork.dao;

import javax.persistence.EntityManager;

public interface InternalDAO {

	public void setEntityManager(EntityManager entityManager);
	public void begin();
	public void end();
	public void flush();
	public void close();
	
}
