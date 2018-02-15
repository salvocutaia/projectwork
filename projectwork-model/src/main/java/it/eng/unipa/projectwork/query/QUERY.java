package it.eng.unipa.projectwork.query;

public interface QUERY {
	
	interface AUCTION extends QUERY{
		
		interface GET_ALL{
			public String NAME = "Auction.getAll";
			public String QUERY = "SELECT a FROM Auction a";
		}
		
		interface GET_ACTIVE{
			public String NAME = "Auction.getActive";
			public String QUERY = "SELECT a FROM Auction a where startAuction >= :timestamp AND endAuction > :timestamp and suspend = false";
			interface PARAMS{
				public String TIMESTAMP = "timestamp";
			}
		}
		
		interface GET_FROM_SUPPLIER {
			public String NAME = "Auction.getAuctionFromSupplier";
			public String QUERY = "SELECT a FROM Auction a WHERE a.supplier.username = :username";
			interface PARAMS{
				public String USERNAME_SUPPLIER = "username";
			}
		}
		
		interface GET_FROM_PRODUCT{
			public String NAME = "Auction.getAuctionFromProduct";
			public String QUERY = "SELECT a FROM Auction a WHERE a.product = :product";
			interface PARAMS{
				public String PRODUCT = "product";
			}
		}
		
	}
	
	
}
