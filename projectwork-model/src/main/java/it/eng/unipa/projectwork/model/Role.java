package it.eng.unipa.projectwork.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Role extends AEntity<String>{
	
	@Id
	private String code;
	private String description;
	
	public String getCode() {
		return code;
	}
	
	
	@Override
	public String getOid() {
		return getCode();
	}
	
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
