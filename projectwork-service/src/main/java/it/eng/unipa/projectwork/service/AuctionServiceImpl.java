package it.eng.unipa.projectwork.service;

import static it.eng.unipa.projectwork.validation.ValidatorUtils.validate;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import it.eng.unipa.projectwork.model.Auction;
import it.eng.unipa.projectwork.model.Product;
import it.eng.unipa.projectwork.model.Supplier;
import it.eng.unipa.projectwork.service.AuctionService;
import it.eng.unipa.projectwork.service.LazyArrayList;
import it.eng.unipa.projectwork.service.LazyList;

@Stateless
/*@TransactionManagement(TransactionManagementType.CONTAINER)*/
public class AuctionServiceImpl extends AbstractService implements AuctionService{
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public LazyList<Auction> loadAuctions(int firstResult,int maxResult){
		List<Auction> list = dao.find(Auction.class,firstResult,maxResult);
		long totalRows = dao.count(Auction.class);
		return new LazyArrayList<>(list, firstResult, maxResult, totalRows);
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
