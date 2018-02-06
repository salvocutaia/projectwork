package it.eng.unipa.projectwork.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import it.eng.unipa.projectwork.dao.DAO;
import it.eng.unipa.projectwork.model.Auction;

@Stateless
public class AuctionServiceImpl implements AuctionService{
	
	@EJB
	DAO dao;
	
	public LazyList<Auction> loadAuctions(){
		return null;
	}

}
