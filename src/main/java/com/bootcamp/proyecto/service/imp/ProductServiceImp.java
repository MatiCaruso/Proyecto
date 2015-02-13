package com.bootcamp.proyecto.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.bootcamp.proyecto.model.dao.ProductDAO;
import com.bootcamp.proyecto.model.entity.Product;
import com.bootcamp.proyecto.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	private ProductDAO productDAO;
	
	@Autowired
	public ProductServiceImp(ProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}

	@Override
	@Transactional
	public void agregarPruducto(String name, double uniPrice,String category) {
		if (uniPrice>0){
			Product product=new Product(name, uniPrice, category);
			productDAO.addProduct(product);
		}


	}

	@Override
	@Transactional
	public void removerProducto(String product) {
		productDAO.deleteProduct(product);

	}

	@Override
	@Transactional
	public List<Product> getProducts() {
		
		return productDAO.getAllProduct(); 
	}

	@Override
	@Transactional
	public Product getProduct(int id) {
		if(id>0){
			return productDAO.getProduct(id);
		}
		return null;
	}

	@Override
	@Transactional
	public Product getProduct(String name) {
		return productDAO.getProduct(name);
	}

	@Override
	@Transactional
	public List<Product> getProductByCategory(String category) {
		return productDAO.getProductByCategory(category);
	}

	
	@Override
	public void setUniPrice(int productId, double uniPrice) {
		productDAO.setUniPrice(productId, uniPrice);
		
	}

}
