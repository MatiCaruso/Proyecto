package com.bootcamp.proyecto.service;

import java.util.List;

import com.bootcamp.proyecto.model.entity.Cart;
import com.bootcamp.proyecto.model.entity.User;

public interface CartService {
	public void agregarCart(User user);

    public void removeCart(int cartId);
    
    public List<Cart> getCarts();
   
    public Cart getCartByUser(int userId);
    public Cart getCart(int cartId);
    
}

