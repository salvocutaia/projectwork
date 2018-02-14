package it.eng.unipa.projectwork.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String postCode;
	private String address;
	private String city;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Address(String postCode, String address, String city) {
		super();
		this.postCode = postCode;
		this.address = address;
		this.city = city;
	}




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
