package it.eng.unipa.projectwork.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import it.eng.unipa.projectwork.dao.DAO;
import it.eng.unipa.projectwork.model.Auction;

@Stateless
/*@TransactionManagement(TransactionManagementType.CONTAINER)*/
public class AuctionServiceImpl implements AuctionService,InternalService{
	
	@EJB
	DAO dao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public LazyList<Auction> loadAuctions(){
		List<Auction> list = dao.find(Auction.class,0,10);
		return new LazyArrayList<>(list, 0, 10, 100);
	}

	
	@Override
	public void setDAO(DAO dao) {
		this.dao = dao;
	}
	
}
