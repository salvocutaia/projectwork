package it.eng.unipa.projectwork.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.eng.unipa.projectwork.query.QUERY;

@Table
@Entity
@NamedQueries(value = {
	    @NamedQuery(name = QUERY.AUCTION.GET_ALL.NAME, query = QUERY.AUCTION.GET_ALL.QUERY),
	    @NamedQuery(name = QUERY.AUCTION.GET_FROM_PRODUCT.NAME, query = QUERY.AUCTION.GET_FROM_PRODUCT.QUERY),
	    @NamedQuery(name = QUERY.AUCTION.GET_FROM_SUPPLIER.NAME, query = QUERY.AUCTION.GET_FROM_SUPPLIER.QUERY)
	})
public class Auction extends AEntity<Long>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUCTION_ID_SEQ") 
	@SequenceGenerator(name="AUCTION_ID_SEQ", sequenceName="AUCTION_ID_SEQ", allocationSize = 1)
	private Long oid;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String description;
	
	@ManyToOne
	private Supplier supplier;
	
	@ManyToOne
	private Product product;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startAuction;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date endAuction;
	
	@OneToMany(mappedBy="auction")
	private List<Bid> bids = new ArrayList<Bid>();
	
	public Auction() {
		// TODO Auto-generated constructor stub
	}
	
	public Auction(Long oid) {
		this.oid = oid;
	}
	
	public Auction(String title,String description,Supplier supplier,Product product,Date startAuction,Date endAuction) {
		this.title = title;
		this.description = description;
		this.supplier = supplier;
		this.product = product;
		this.startAuction = startAuction;
		this.endAuction = endAuction;
	}
	
	
	
	public Long getOid() {
		return oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public List<Bid> getBids() {
		return bids;
	}
	
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
	
	public Date getStartAuction() {
		return startAuction;
	}
	
	public void setStartAuction(Date startAuction) {
		this.startAuction = startAuction;
	}
	
	public Date getEndAuction() {
		return endAuction;
	}
	
	public void setEndAuction(Date endAuction) {
		this.endAuction = endAuction;
	}

	@Override
	public String toString() {
		return "Auction [getOid()=" + getOid() + ", getTitle()=" + getTitle() + ", getDescription()=" + getDescription()
				+ ", getSupplier()=" + getSupplier() +", getProduct() =" + getProduct() + super.toString() + "]";
	}

	
	
	public void addBid(Bid bid){
		bid.setAuction(this);
		this.bids.add(bid);
	}
	
	
	
	

}
