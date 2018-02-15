package it.eng.unipa.projectwork.model.state;

import it.eng.unipa.projectwork.model.Auction;

public enum STATE {
	PENDING {
		@Override
		public boolean canAddBid() {
			return false;
		}
		
		
		@Override
		public boolean amI(Auction auction) {
			return auction.getStartAuction().getTime()>System.currentTimeMillis(); 
		}
	},
	SUSPEND {
		@Override
		public boolean canAddBid() {
			return false;
		}
		
		@Override
		public boolean amI(Auction auction) {
			return auction.isSuspend(); 
		}
	},
	STARTED {
		@Override
		public boolean canAddBid() {
			return true;
		}
		
		@Override
		public boolean amI(Auction auction) {
			long currentTimeMillis = System.currentTimeMillis();
			return auction.getStartAuction().getTime()<=currentTimeMillis && currentTimeMillis<auction.getEndAuction().getTime() && !SUSPEND.amI(auction);
		}
		
		
	},CLOSED {
		@Override
		public boolean canAddBid() {
			return true;
		}
		@Override
		public boolean amI(Auction auction) {
			return System.currentTimeMillis()>auction.getEndAuction().getTime() && !SUSPEND.amI(auction);
		}
	};
	
	
	
	
	
	public abstract boolean canAddBid();
	

	public abstract boolean amI(Auction auction);
	
	
	public static STATE eval(Auction auction){
		for(STATE s : STATE.values()){
			if(s.amI(auction)){
				return s;
			}
		}
		throw new RuntimeException("Status Auction ["+auction+"] is not valid");
	}

}
