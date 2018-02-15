package it.eng.unipa.projectwork.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import it.eng.unipa.projectwork.model.Auction;

@Local
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public interface AuctionService {
	
	public LazyList<Auction> loadAuctions(int firstResult,int maxResult);
	
	public List<Auction> loadActiveAuctions();

	public Auction add(Auction auction,String username);

}
