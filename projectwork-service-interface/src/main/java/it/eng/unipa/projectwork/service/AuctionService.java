package it.eng.unipa.projectwork.service;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import it.eng.unipa.projectwork.model.Auction;
import it.eng.unipa.projectwork.model.Bid;
import it.eng.unipa.projectwork.model.Image;
import it.eng.unipa.projectwork.model.exception.AddBidNotValidException;

@Local
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public interface AuctionService {
	
	public LazyList<Auction> loadAuctions(int firstResult,int maxResult);
	
	public List<Auction> loadActiveAuctions();

	public Auction add(Auction auction,String username);

	public Auction loadAuction(long oid);
	
	
	public Bid addBid(long oidAuction,long versionAuction,String username,BigDecimal bid);

	public Image loadImage(long oidAuction, long oidImage);

}
