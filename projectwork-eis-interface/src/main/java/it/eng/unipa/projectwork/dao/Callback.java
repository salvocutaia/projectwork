package it.eng.unipa.projectwork.dao;


import javax.persistence.EntityManager;

public interface Callback<T> {
	
	
	public T execute(EntityManager et) throws Exception;

}
