package it.eng.unipa.projectwork.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserRoleOid implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;	
	private String codeRole;
	
	
	
	public String getCodeRole() {
		return codeRole;
	}
	public void setCodeRole(String codeRole) {
		this.codeRole = codeRole;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeRole == null) ? 0 : codeRole.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoleOid other = (UserRoleOid) obj;
		if (codeRole == null) {
			if (other.codeRole != null)
				return false;
		} else if (!codeRole.equals(other.codeRole))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
	
}
