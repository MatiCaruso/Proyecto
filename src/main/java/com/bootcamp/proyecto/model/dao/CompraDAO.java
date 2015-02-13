package com.bootcamp.proyecto.model.dao;

import java.util.List;

import com.bootcamp.proyecto.model.entity.Cart;
import com.bootcamp.proyecto.model.entity.Compra;
import com.bootcamp.proyecto.model.entity.Product;


public interface CompraDAO {

	public List<Compra> getAllCompra();
	public List<Compra> getCompraByCart(Cart cart);
	public void addProductToCart(Compra compra);
	public void setQuantity(Compra compra, int quantity);
	public List<Compra> getCompraByProduct(Product product);
	public void deleteProductFromCart(Compra compra);
	public Compra getCompra(int compraId);
	public List<Compra> getCompraActiva(int cartId);
	public void updateCompra(Compra compra);
	public List<Compra> estadoCompra(boolean estado);
	
}	
