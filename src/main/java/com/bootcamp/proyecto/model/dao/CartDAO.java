package com.bootcamp.proyecto.model.dao;

import java.util.List;

import com.bootcamp.proyecto.model.entity.Cart;

public interface CartDAO {
	
	public List<Cart> getAllCart();
	
	public Cart getCartByUser(int userId);
	public void saveCart (Cart cart);
	public void removeCart(int cartId);

	public Cart getCart(int cartId);
	
}
