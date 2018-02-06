package it.eng.unipa.projectwork.service;

import javax.ejb.Local;

import it.eng.unipa.projectwork.model.Auction;

@Local
public interface AuctionService {
	
	public LazyList<Auction> loadAuctions();

}
