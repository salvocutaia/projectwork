package it.eng.unipa.projectwork.web.dto;

import java.util.ArrayList;
import java.util.List;

public class AuctionFullDTO extends AuctionDTO {
	
	private List<Long> productImagesOid = new ArrayList<>();

	public List<Long> getProductImagesOid() {
		return productImagesOid;
	}

	public void setProductImagesOid(List<Long> productImagesOid) {
		this.productImagesOid = productImagesOid;
	}
	
	
	

}
