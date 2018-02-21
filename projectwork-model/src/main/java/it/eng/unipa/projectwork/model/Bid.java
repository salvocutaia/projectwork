package it.eng.unipa.projectwork.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Bid extends AEntity<Long>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BID_ID_SEQ") 
	@SequenceGenerator(name="BID_ID_SEQ", sequenceName="BID_ID_SEQ", allocationSize = 1)
	Long oid;
	
	@ManyToOne
	Auction auction;
	
	BigDecimal price;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date time;
	
	@ManyToOne
	User user;
	
	
	
	public Bid() {
		
	}
	
	
	public Bid(User user, BigDecimal price){
		this.user = user;
		this.price = price;
		this.time = new Timestamp(System.currentTimeMillis());
	}
	
	@Override
	public Long getOid() {
		return oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	public Auction getAuction() {
		return auction;
	}
	
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Bid [oid=" + oid + ", auction=" + auction + ", price=" + price + ", time=" + time + ", user=" + user
				+ "]";
	}
	
	

}
