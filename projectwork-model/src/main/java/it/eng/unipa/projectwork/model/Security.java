package it.eng.unipa.projectwork.model;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table
@Entity
public class Security extends AEntity<String>{
	
	@Id
	private String username;
	
	private String password;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String getOid() {
		return getUsername();
	}
}
