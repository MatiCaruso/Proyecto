package com.bootcamp.proyecto.service;

import java.util.List;

import com.bootcamp.proyecto.model.entity.User;

public interface UserService {
	public void agregarUser(User user);
    public List<User> getUsers();
    public User getUser(int userId);
	public void removerUser(String user, String pass);
	public User getUser(String name);
     
 }