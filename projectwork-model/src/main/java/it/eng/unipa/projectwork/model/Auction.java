package it.eng.unipa.projectwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table
@Entity
@NamedQueries(value = {
	    @NamedQuery(name = "Auction.getAll", query = "SELECT a FROM Auction a")
	})
public class Auction extends AEntity<Long>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUCTION_ID_SEQ") 
	@SequenceGenerator(name="AUCTION_ID_SEQ", sequenceName="AUCTION_ALLEGATO_SEQ", allocationSize = 1)
	private Long oid;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String description;
	
	@ManyToOne
	private Supplier supplier;
	
	@ManyToOne
	private Product product;
	
	public Auction() {
		// TODO Auto-generated constructor stub
	}
	
	public Auction(Long oid) {
		this.oid = oid;
	}
	
	public Auction(String title,String description,Supplier supplier,Product product) {
		this.title = title;
		this.description = description;
		this.supplier = supplier;
		this.product = product;
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

	@Override
	public String toString() {
		return "Auction [getOid()=" + getOid() + ", getTitle()=" + getTitle() + ", getDescription()=" + getDescription()
				+ ", getSupplier()=" + getSupplier() +", getProduct() =" + getProduct() + super.toString() + "]";
	}

	
	
	
	
	

}
