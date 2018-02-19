package it.eng.unipa.projectwork.service;

import static it.eng.unipa.projectwork.validation.ValidatorUtils.validate;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import it.eng.unipa.projectwork.channel.event.BidAuctionEvent;
import it.eng.unipa.projectwork.channel.send.SendAuctionEvent;
import it.eng.unipa.projectwork.model.Auction;
import it.eng.unipa.projectwork.model.Bid;
import it.eng.unipa.projectwork.model.Image;
import it.eng.unipa.projectwork.model.Product;
import it.eng.unipa.projectwork.model.Supplier;
import it.eng.unipa.projectwork.model.User;
import it.eng.unipa.projectwork.model.exception.AddBidNotValidException;
import it.eng.unipa.projectwork.query.QUERY;
import it.eng.unipa.projectwork.service.AuctionService;
import it.eng.unipa.projectwork.service.LazyArrayList;
import it.eng.unipa.projectwork.service.LazyList;

@Stateless
/*@TransactionManagement(TransactionManagementType.CONTAINER)*/
public class AuctionServiceImpl extends AbstractService implements AuctionService{
	
	
	@EJB
	SendAuctionEvent sendAuctionEvent;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public LazyList<Auction> loadAuctions(int firstResult,int maxResult){
		List<Auction> list = dao.find(Auction.class,firstResult,maxResult);
		long totalRows = dao.count(Auction.class);
		return new LazyArrayList<>(list, firstResult, maxResult, totalRows);
	}
	
	
	@Override
	public List<Auction> loadActiveAuctions() {
		Map<String,Object> map = new HashMap<>();
		map.put(QUERY.AUCTION.GET_ACTIVE.PARAMS.TIMESTAMP, new Timestamp(System.currentTimeMillis()));
		return dao.findNamed(Auction.class,QUERY.AUCTION.GET_ACTIVE.NAME,map);
	}
	
	@Override
	public Auction loadAuction(long oid) {
		return dao.load(Auction.class, oid);
	}
	
	
	@Override
	public Bid addBid(long oidAuction,long versionAuction,String username,BigDecimal bidPrice) throws AddBidNotValidException {
		
		Map<String,Object> values = new HashMap<>();
		values.put("oid", oidAuction);
		values.put("version", versionAuction);
		List<Auction> auctions = dao.find(Auction.class,"select a from Auction a where a.oid = :oid and a.version = :version",values );
		if(!auctions.isEmpty()){
			Auction auction = auctions.get(0);
			User user = dao.load(User.class,username);
			Bid bid = new Bid(user,bidPrice);
			auction.addBid(bid);
			dao.merge(auction);
			sendAuctionEvent.sendAuctionEvent(new BidAuctionEvent(oidAuction,auction.getVersion(), bidPrice));
			return bid;
		}else{
			throw new AddBidNotValidException("Version auction is not valid");
		}
		
	}
	
	
	@Override
	public Image loadImage(long oidAuction, long oidImage) {
		Map<String,Object> values = new HashMap<>();
		values.put("oidAuction", oidAuction);
		values.put("oidImage", oidImage);
		List<Image> images = dao.find(Image.class,"select i from Image i,Auction a where i.product = a.product and i.oid = :oidImage and a.oid = :oidAuction",values);
		if(images.isEmpty()){
			return null;
		}else{
			return images.get(0);
		}
	}
	
	@Override
	public Auction add(Auction auction,String username) {
		
		return validate(()->{
			auction.setSupplier(dao.load(Supplier.class,username));
			if(auction.getProduct().getOid()!=null){
				auction.setProduct(dao.load(Product.class,auction.getProduct().getOid()));
			}
			return dao.persist(auction);
		}, 
		(vi)->{vi.isEmpty(dao.load(Supplier.class,username), "Supplier not exist");},
		(vi)->{vi.isEmpty(auction.getTitle(),"Title is empty"); },
		(vi)->{vi.isEmpty(auction.getDescription(),"Description is empty"); },
		(vi)->{vi.apply(()->auction.getOid()!=null && dao.load(auction.getProduct())!=null ||auction.getProduct().getDescription()!=null, "Product is null");}
	);
	}

	
	
}
