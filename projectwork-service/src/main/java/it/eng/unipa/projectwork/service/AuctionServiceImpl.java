package it.eng.unipa.projectwork.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import it.eng.unipa.projectwork.model.Auction;
import it.eng.unipa.projectwork.model.Product;
import it.eng.unipa.projectwork.validation.NotValidException;
import static it.eng.unipa.projectwork.validation.ValidatorUtils.*;

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
		return validate(
		/*LOGICA DI BUSINESS*/
		()->{
			return dao.persist(auction, username);
		}, 
		/*VALIDAZIONE*/		
		()->{
			List<String> messages = new ArrayList<>();
			if(isEmpty(auction)){
				if(isEmpty(auction.getTitle())){
					messages.add("Title is null or empty");
				}
				if(isEmpty(auction.getProduct()) || isEmpty(auction.getProduct().getOid())){
					messages.add("Prduct is null or empty");
				}else{
					Product p = dao.load(auction.getProduct());
					if(p==null){
						messages.add("Product with id "+p.getOid()+" not exist");
					}
				}
			}else{
				messages.add("Auction is null or empty");
			}
			
			
			if(!messages.isEmpty()){
				throw new NotValidException(messages);
			}
		});
		
	}

	
	
}
