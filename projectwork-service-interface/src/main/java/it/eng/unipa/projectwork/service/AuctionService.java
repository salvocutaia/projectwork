package it.eng.unipa.projectwork.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import it.eng.unipa.projectwork.model.Auction;
import it.eng.unipa.projectwork.model.Image;

@Local
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public interface AuctionService {
	
	public <R> List<R> loadActiveAuctions(Function<Auction,R> f);

	public <R> R add(Auction auction,String username,Function<Auction,R> f);

	public <R> R loadAuction(long oid,Function<Auction,R> f);
	
	public void addBid(long oidAuction,long versionAuction,String username,BigDecimal bid);

	public Image loadImage(long oidAuction, long oidImage);

}
