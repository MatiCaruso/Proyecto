package com.bootcamp.proyecto.service;

import java.util.List;

import com.bootcamp.proyecto.dto.ProductDTO;
import com.bootcamp.proyecto.model.entity.Product;

public interface ProductService {

	public void agregarPruducto(String name, double uniPrice, String category);
    public void removerProducto(String product);
    public List<Product> getProducts();
    public Product getProduct(int id);
    public Product getProduct(String name);
    public List<Product> getProductByCategory(String category);
    public void setUniPrice(int productId, double uniPrice );
}
