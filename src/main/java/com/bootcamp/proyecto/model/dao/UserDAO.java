package com.bootcamp.proyecto.model.dao;

import java.util.List;

import com.bootcamp.proyecto.model.entity.User;

public interface UserDAO {
	
	public List<User> getUser();
	public User getUser(String name);
	public User getUser(int userId);
	public void addUser(User user);

	public void removeUser(String user, String pass);


}
