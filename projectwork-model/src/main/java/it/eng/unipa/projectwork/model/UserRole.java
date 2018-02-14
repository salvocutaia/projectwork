package it.eng.unipa.projectwork.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Table
@Entity
public class UserRole extends AEntity<UserRoleOid>{
	
	@EmbeddedId
	UserRoleOid oid;
	

	@ManyToOne
	@MapsId("codeRole")
	private Role role;
	
	
	public UserRoleOid getOid() {
		return oid;
	}
	
	public void setOid(UserRoleOid oid) {
		this.oid = oid;
	}
	
	
	
}
