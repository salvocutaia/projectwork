package it.eng.unipa.projectwork.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import it.eng.unipa.projectwork.dao.DAO;
import it.eng.unipa.projectwork.model.User;

@Stateless
public class UserServiceImpl implements UserService{
	
	@EJB
	DAO dao;

	@Override
	public List<User> allUsers() {
		return dao.find(User.class);
	}

	@Override
	public User getUser(String username) {
		return dao.load(User.class,username);
	}

}
