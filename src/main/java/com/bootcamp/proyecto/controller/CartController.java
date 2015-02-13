package com.bootcamp.proyecto.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bootcamp.proyecto.model.entity.Cart;
import com.bootcamp.proyecto.model.entity.User;
import com.bootcamp.proyecto.service.CartService;
import com.bootcamp.proyecto.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/addCart", method=RequestMethod.GET)
	public ModelAndView addCart (@RequestParam(value="u")int userId){
		User user= userService.getUser(userId);
		cartService.agregarCart(user);
		return new ModelAndView("redirect:/allCarts");
	}
	
	@RequestMapping(value="/removeCart", method=RequestMethod.GET)
	public ModelAndView removeCart (@RequestParam(value="id")int cartId){
		cartService.removeCart(cartId);
		return new ModelAndView("redirect:/allCarts");		
	}
	
	@RequestMapping(value="/allCarts", method=RequestMethod.GET)
	public @ResponseBody List<Cart> getCarts (){
		List<Cart> carts=cartService.getCarts();
		return carts;
		
				
	}
	@RequestMapping(value="/searchCart", method=RequestMethod.GET)
	public @ResponseBody Cart searchCart (@RequestParam(value="userId") int userId){
		
		return cartService.getCartByUser(userId);
	}
	
	@RequestMapping(value="/getCart", method=RequestMethod.GET)
	public  @ResponseBody Cart getCart (@RequestParam(value="id") int cartId){
			
		return cartService.getCart(cartId);	
	}
}