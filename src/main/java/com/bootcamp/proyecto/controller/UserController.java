package com.bootcamp.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bootcamp.proyecto.model.entity.User;
import com.bootcamp.proyecto.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/addUser", method=RequestMethod.GET)
	public ModelAndView agregarUser(String user, String pass){
		User newUser= new User(user, pass);
		userService.agregarUser(newUser);
		return new ModelAndView("redirect:/allUsers");
		
	}

	@RequestMapping(value="/removeUser", method=RequestMethod.GET)
	public ModelAndView removeUser(String user, String pass){
		userService.removerUser(user, pass);
		return new ModelAndView("redirect:/allUsers");
			
	}
	
	@RequestMapping(value="/allUsers", method=RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers(){
		List<User> users= userService.getUsers();
		return users;
	}
	
	@RequestMapping(value="/searchUser", method=RequestMethod.GET)
	public @ResponseBody User searchUser(int userId){
		return userService.getUser(userId);
		
	}
}
