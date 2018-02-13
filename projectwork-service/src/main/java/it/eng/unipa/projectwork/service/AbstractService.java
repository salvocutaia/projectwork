package it.eng.unipa.projectwork.service;

import javax.ejb.EJB;

import it.eng.unipa.projectwork.dao.DAO;

public abstract class AbstractService implements InternalService{
	
	@EJB
	protected DAO dao;
	
	
	@Override
	public void setDAO(DAO dao) {
		this.dao = dao;
	}
	

}
