package it.eng.unipa.projectwork.model.pricingstrategy;

import java.util.List;

import it.eng.unipa.projectwork.model.Bid;

public enum PRICING {
	UPWARDS{
		@Override
		public boolean canAdd(Bid b, Bid newBid) {
			return newBid.getPrice().compareTo(b.getPrice())>0;
		}
		
	},DOWNWARDS{
		@Override
		public boolean canAdd(Bid b, Bid newBid) {
			return newBid.getPrice().compareTo(b.getPrice())>0;
		}
	};
	
	public abstract boolean canAdd(Bid b,Bid newBid);
	
	public boolean canAdd(List<Bid> bids, Bid newBid) {
		for(Bid  bid: bids){
			if(!canAdd(bid, newBid)){
				return false;
			}
		}
		return true;
	}

}
