package com.bootcamp.proyecto.model.dao.imp;


import java.util.List;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.proyecto.model.dao.CartDAO;
import com.bootcamp.proyecto.model.entity.Cart;
@Repository
public class CartDAOImplementation implements CartDAO {
	
	private SessionFactory sessionFactory;

	@Autowired
	public CartDAOImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Cart> getAllCart() {

		List<Cart> carts = null;
		carts = (List<Cart>) sessionFactory.getCurrentSession().createQuery("FROM Cart").list(); 
		return carts;
	}

	@Override
	public Cart getCartByUser(int userId) {
		
	     Cart cart = (Cart)sessionFactory.getCurrentSession().createQuery("FROM Cart c WHERE c.user.id= :userId").setParameter("userId", userId).uniqueResult();
	     
	     return cart;
	}
	@Override
	public void saveCart (Cart cart){
		sessionFactory.getCurrentSession().save(cart);
	}
	
	@Override
	public void removeCart(int cartId) {
		Cart cart = (Cart)sessionFactory.getCurrentSession().createQuery("FROM Cart c WHERE c.id= :id").setParameter("id", cartId).uniqueResult();	     
		sessionFactory.getCurrentSession().delete(cart);
	       
	}

	@Override
	public Cart getCart(int cartId) {
		 Cart cart = (Cart)sessionFactory.getCurrentSession().createQuery("FROM Cart c WHERE c.id= :id").setParameter("id", cartId).uniqueResult();
		return cart;
	}
}
