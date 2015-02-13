package com.bootcamp.proyecto.service;

import java.util.List;

import com.bootcamp.proyecto.model.entity.Cart;
import com.bootcamp.proyecto.model.entity.Compra;
import com.bootcamp.proyecto.model.entity.Product;

public interface CompraService {

	public void agregarCompra(Cart cart, Product product, int cantidad);

	public void removerCompra(Compra compra);

	public void modificarCantidad(Compra compra, int quantity);

	public List<Compra> getCompras();

	public List<Compra> getComprasByCart(Cart cart);

	public List<Compra> getComprasByProduct(Product product);

	public Compra getCompra(int compraId);

	public double comfirmaCompra(int cartId, int type);

	public List<Compra> estadoCompra(boolean estado);

}
