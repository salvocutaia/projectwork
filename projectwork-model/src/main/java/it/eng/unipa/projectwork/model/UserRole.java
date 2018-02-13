package it.eng.unipa.projectwork.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class UserRole extends AEntity<UserRoleOid>{
	
	@EmbeddedId
	UserRoleOid oid;
	
	
	public UserRoleOid getOid() {
		return oid;
	}
	
	public void setOid(UserRoleOid oid) {
		this.oid = oid;
	}
	
	
	
}
