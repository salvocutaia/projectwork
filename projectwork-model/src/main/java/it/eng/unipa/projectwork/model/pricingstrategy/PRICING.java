package it.eng.unipa.projectwork.model.pricingstrategy;

import java.util.List;

import it.eng.unipa.projectwork.model.Bid;

public enum PRICING {
	UPWARDS{
		@Override
		public boolean canAdd(Bid b, Bid newBid) {
			return newBid.getPrice().compareTo(b.getPrice())>0;
		}
		
		@Override
		public Bid currentBid(List<Bid> bids) {
			return bids.stream().max((a,b)->{return a.getPrice().compareTo(b.getPrice());}).get();
		}
		
	},DOWNWARDS{
		@Override
		public boolean canAdd(Bid b, Bid newBid) {
			return newBid.getPrice().compareTo(b.getPrice())>0;
		}
		
		@Override
		public Bid currentBid(List<Bid> bids) {
			return bids.stream().min((a,b)->{return a.getPrice().compareTo(b.getPrice());}).get();
		}
	};
	
	public abstract boolean canAdd(Bid b,Bid newBid);
	
	public abstract Bid currentBid(List<Bid> bid);
	
	public boolean canAdd(List<Bid> bids, Bid newBid) {
		for(Bid  bid: bids){
			if(!canAdd(bid, newBid)){
				return false;
			}
		}
		return true;
	}

}
