package it.eng.unipa.projectwork.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String postCode;
	private String address;
	private String city;
	
	
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
