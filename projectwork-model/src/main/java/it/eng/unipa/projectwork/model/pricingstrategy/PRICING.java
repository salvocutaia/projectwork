package it.eng.unipa.projectwork.model.pricingstrategy;

import java.util.Collections;
import java.util.Comparator;
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
			/*Bid curr = null;
			for(Bid bid : bids){
				if(curr == null){
					curr = bid;
				}else{
					if(bid.getPrice().compareTo(curr.getPrice())>0){
						curr = bid;
					}
				}
			}
			return curr;
			*/
			Bid bid = bids.stream().max(
					(a,b)->{
						return a.getPrice().compareTo(b.getPrice());
					}).get();
			System.out.println(bids.size()+" " + bid);
			return bid;
			/*
			return Collections.max(bids,new Comparator<Bid>() {
				public int compare(Bid o1, Bid o2) {
					return o1.getPrice().compareTo(o2.getPrice());
				}
			});*/
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
