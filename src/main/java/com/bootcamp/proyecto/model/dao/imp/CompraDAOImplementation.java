package com.bootcamp.proyecto.model.dao.imp;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.proyecto.model.dao.CompraDAO;
import com.bootcamp.proyecto.model.entity.Cart;
import com.bootcamp.proyecto.model.entity.Compra;
import com.bootcamp.proyecto.model.entity.Product;

@Repository
public class CompraDAOImplementation implements CompraDAO {
	
	private SessionFactory sessionFactory;

	@Autowired
	public CompraDAOImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Compra> getAllCompra() {

		List<Compra> compras = null;
		compras = (List<Compra>) sessionFactory.getCurrentSession().createQuery("FROM Compra").list(); 
		
	    return compras;
	}

	@Override
	public List<Compra> getCompraByCart(Cart cart) {

		List<Compra> compras = null;
		compras = (List<Compra>) sessionFactory.getCurrentSession().createQuery("FROM Compra c WHERE c.cart = :cart").setParameter("cart", cart).list(); 
		
		return compras;
	
	}
	@Override
	public List<Compra> getCompraByProduct(Product product) {

		List<Compra> compras = null;
		compras = (List<Compra>) sessionFactory.getCurrentSession().createQuery("FROM Compra c WHERE c.product =:product").setParameter("product", product).list(); 
		
	    return compras;
	}

	@Override
	public void addProductToCart(Compra compra) {
		sessionFactory.getCurrentSession().save(compra); 
	}

	@Override
	public void setQuantity(Compra compra, int quantity) {
		
		compra.setQuantity( quantity );
		sessionFactory.getCurrentSession().update(compra); 
	}

	@Override
	public void deleteProductFromCart(Compra compra) {
		sessionFactory.getCurrentSession().delete(compra); 
	    }

	@Override
	public Compra getCompra(int compraId) {
		Compra compra =(Compra) sessionFactory.getCurrentSession().createQuery("FROM Compra c WHERE c.id =:id").setParameter("id", compraId).uniqueResult();
		return compra;
	}

	@Override
	public List<Compra> getCompraActiva(int cartId) {
		
		List<Compra> compras = (List<Compra>) sessionFactory.getCurrentSession().createQuery("FROM Compra c WHERE c.cart.id =:cartId AND c.confirm=false").setParameter("cartId", cartId).list(); 
		return compras;
	}

	@Override
	public void updateCompra(Compra compra) {
		sessionFactory.getCurrentSession().update(compra);
		
	}
	
		
	} 

	


