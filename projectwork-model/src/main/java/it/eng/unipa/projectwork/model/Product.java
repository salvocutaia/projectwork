package it.eng.unipa.projectwork.model;
/**
 * 
 * @author Giancarlo Compagno
 * 
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table
@Entity
public class Product extends AEntity<Long> {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_ID_SEQ") 
	@SequenceGenerator(name="PRODUCT_ID_SEQ", sequenceName="PRODUCT_ALLEGATO_SEQ", allocationSize = 1)
	private Long oid;
	private String descrition;
	
	public Product(){
		
	}
	
	public Product(String descrition) {
		this.descrition = descrition;
	}
	
	public Product(Long oid) {
		this.oid = oid;
	}
	
	
	public Long getOid() {
		return oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	public String getDescription() {
		return descrition;
	}
	
	public void setDescription(String descrition) {
		this.descrition = descrition;
	}

	@Override
	public String toString() {
		return "Supplier [getOid()=" + getOid() + ", getDescription()=" + getDescription() + super.toString() + "]";
	}
	
	
	
	
}
