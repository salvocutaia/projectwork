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
public class Supplier extends AEntity<Long> {

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SUPPLIER_ID_SEQ") 
	@SequenceGenerator(name="SUPPLIER_ID_SEQ", sequenceName="SUPPLIER_ALLEGATO_SEQ", allocationSize = 1)
	private Long oid;
	private String info;
	
	public Supplier(){
		
	}
	
	public Supplier(String info) {
		this.info = info;
	}
	
	public Supplier(Long oid) {
		this.oid = oid;
	}
	
	
	public Long getOid() {
		return oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Supplier [getOid()=" + getOid() + ", getInfo()=" + getInfo() + super.toString() + "]";
	}
	
	
	
	
}
