package com.bootcamp.proyecto.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.proyecto.model.dao.UserDAO;
import com.bootcamp.proyecto.model.entity.User;
import com.bootcamp.proyecto.service.UserService;

@Service
public class UserServiceImp implements UserService {
	private UserDAO userDAO;
	
	@Autowired
	public UserServiceImp(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void agregarUser(User user) {
		
		userDAO.addUser(user);
	}

	@Override
	@Transactional
	public void removerUser(String user, String pass) {
	
		userDAO.removeUser(user, pass);

	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUser();
	}

	@Override
	@Transactional
	public User getUser(int userId) {
		if (userId>=0){
			return userDAO.getUser(userId);
		}else{
//			el usuario tiene q ser mayor de 0
			return null;
		}
		
	}



}
