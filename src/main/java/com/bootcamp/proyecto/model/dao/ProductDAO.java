package com.bootcamp.proyecto.model.dao;
import java.util.List;

import com.bootcamp.proyecto.model.entity.Product;

public interface ProductDAO {

	public List<Product> getAllProduct();
	public Product getProduct(int productId);
	public Product getProduct(String name);
	public List<Product> getProductByCategory (String category);
	public void addProduct(Product product);
	public void deleteProduct (String product);
	public void setUniPrice(int productId, double uniPrice);	
}
