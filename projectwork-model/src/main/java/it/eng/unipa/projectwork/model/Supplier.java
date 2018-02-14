package it.eng.unipa.projectwork.model;
/**
 * 
 * @author Giancarlo Compagno
 * 
 */

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class Supplier extends User {

	
	private String info;
	
	public Supplier(){
		
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	

	@Override
	public String toString() {
		return "Supplier [User=" + super.toString() + ", getInfo()=" + getInfo() + super.toString() + "]";
	}
	
	
	
	
}
