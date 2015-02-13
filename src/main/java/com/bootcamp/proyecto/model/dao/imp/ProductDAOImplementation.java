package com.bootcamp.proyecto.model.dao.imp;

import java.util.List;

import com.bootcamp.proyecto.model.dao.ProductDAO;
import com.bootcamp.proyecto.model.entity.Product;

import java.util.Iterator; 

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImplementation implements ProductDAO {
	
	private SessionFactory sessionFactory;

	@Autowired
	public ProductDAOImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Product> getAllProduct() {

		List<Product> products = null;
		products = (List<Product>) sessionFactory.getCurrentSession().createQuery("FROM Product").list(); 
		return products;
	}

	@Override
	public Product getProduct(int id) {

		Product product = null;
	    product = (Product)sessionFactory.getCurrentSession().createQuery("FROM Product p WHERE p.id = :id").setParameter("id", id).uniqueResult();
	    
	    return product;
	}

	@Override
	public Product getProduct(String name) {

		Product product = null;
	    product = (Product)sessionFactory.getCurrentSession().createQuery("FROM Product p WHERE p.name = :name").setParameter("name", name).uniqueResult(); 
	    return product;
	}

	@Override
	public List<Product> getProductByCategory(String category) {
	    List<Product>products = (List<Product>) sessionFactory.getCurrentSession().createQuery("FROM Product p WHERE p.category = :category").setParameter("category", category).list(); 
	    
	    return products;
	}

	@Override
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product); 
	
	}

	@Override
	public void deleteProduct(String name) {
		Product product = (Product)sessionFactory.getCurrentSession().createQuery("FROM Product p WHERE p.name = :name").setParameter("name", name).uniqueResult();

		sessionFactory.getCurrentSession().delete(product); 
	}

	@Override
	public void setUniPrice(int productId, double uniPrice) {
		Product product;
		product=getProduct(productId);
		product.setUniPrice(uniPrice);
		sessionFactory.getCurrentSession().update(product);
		
	}

}
