package com.bootcamp.proyecto.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.proyecto.model.dao.CartDAO;
import com.bootcamp.proyecto.model.entity.Cart;
import com.bootcamp.proyecto.model.entity.User;
import com.bootcamp.proyecto.service.CartService;

@Service
public class CartServiceImp implements CartService {

	private CartDAO cartDAO;
	@Autowired
	public CartServiceImp(CartDAO cartDAO) {
		super();
		this.cartDAO = cartDAO;
	}

	@Override
	@Transactional
	public void agregarCart(User user) {
		Cart cart = new Cart(user);
		cartDAO.saveCart(cart);

	}

	@Override
	@Transactional
	public void removeCart(int cart) {
		cartDAO.removeCart(cart);
		
	}

	@Override
	@Transactional
	public List<Cart> getCarts() {
		return cartDAO.getAllCart();
	}

	@Override
	@Transactional
	public Cart getCartByUser(int userId) {
		if(userId>0){
			return cartDAO.getCartByUser(userId);
		}
		throw new IllegalArgumentException(userId + " value is not valid");
	}

	@Override
	public Cart getCart(int cartId) {
		
		return cartDAO.getCart(cartId);
	}

}
