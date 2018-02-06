package it.eng.unipa.projectwork.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AEntity<PK extends Serializable> {
	
	@Column(nullable=false)
	private String usernameInsertion;
	
	@Column(nullable=false)
	private Date dateInsertion;
	
	@Column(nullable=true)
	private String usernameModification;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true)
	private Date dateModification;
	
	
	public abstract PK getOid();


	public String getUsernameInsertion() {
		return usernameInsertion;
	}


	public void setUsernameInsertion(String usernameInsertion) {
		this.usernameInsertion = usernameInsertion;
	}


	public Date getDateInsertion() {
		return dateInsertion;
	}


	public void setDateInsertion(Date dateInsertion) {
		this.dateInsertion = dateInsertion;
	}


	public String getUsernameModification() {
		return usernameModification;
	}


	public void setUsernameModification(String usernameModification) {
		this.usernameModification = usernameModification;
	}


	public Date getDateModification() {
		return dateModification;
	}


	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}


	@Override
	public String toString() {
		return "[getOid()=" + getOid() + ", getUsernameInsertion()=" + getUsernameInsertion()
				+ ", getDateInsertion()=" + getDateInsertion() + ", getUsernameModification()="
				+ getUsernameModification() + ", getDateModification()=" + getDateModification() + "]";
	}
	
	
	
	

}
