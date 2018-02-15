package it.eng.unipa.projectwork.service;

import java.util.List;

import javax.ejb.Local;

import it.eng.unipa.projectwork.model.User;

@Local
public interface UserService {
	
	public List<User> allUsers();
	
	public User getUser(String username);

}
