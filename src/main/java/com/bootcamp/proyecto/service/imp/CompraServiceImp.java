package com.bootcamp.proyecto.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.proyecto.model.dao.CompraDAO;
import com.bootcamp.proyecto.model.entity.Cart;
import com.bootcamp.proyecto.model.entity.Compra;
import com.bootcamp.proyecto.model.entity.Product;
import com.bootcamp.proyecto.service.CompraService;

@Service
public class CompraServiceImp implements CompraService {

	private CompraDAO compraDAO;

	@Autowired
	public CompraServiceImp(CompraDAO compraDAO) {
		super();
		this.compraDAO = compraDAO;
	}

	@Override
	@Transactional
	public void agregarCompra(Cart cart, Product product, int quantity) {
		if (quantity > 0) {
			Compra compra = new Compra(cart, product, quantity);
			compraDAO.addProductToCart(compra);
		}
		// quantity debe ser mayor a 0
	}

	@Override
	@Transactional
	public void removerCompra(Compra compra) {
		compraDAO.deleteProductFromCart(compra);
	}

	@Override
	@Transactional
	public void modificarCantidad(Compra compra, int quantity) {
		if (quantity > 0) {
			compraDAO.setQuantity(compra, quantity);
		}
		// quantity debe ser mayor a 0
	}

	@Override
	@Transactional
	public List<Compra> getCompras() {
		return compraDAO.getAllCompra();
	}

	@Override
	@Transactional
	public List<Compra> getComprasByCart(Cart cart) {
		return compraDAO.getCompraByCart(cart);
	}

	@Override
	@Transactional
	public List<Compra> getComprasByProduct(Product product) {
		return compraDAO.getCompraByProduct(product);
	}

	@Override
	public Compra getCompra(int compraId) {

		return compraDAO.getCompra(compraId);
	}

	@Override
	public double comfirmaCompra(int cartId, int type) {
		String payType = "";
		if (type == 1) {
			payType = "paypal";
		}
		if (type == 2) {
			payType = "cash";
		}
		if (type == 3) {
			payType = "credit card";
		}
		double price = 0;
		double minor = 9999;
		double higher = 0;
		double finalPrice = 0.0;
		List<Compra> compras = compraDAO.getCompraActiva(cartId);
		if (compras.size() > 0) {
			for (Compra compra : compras) {
				price = price + compra.getProduct().getUniPrice()
						* compra.getQuantity();
				if (compras.size() == 1 && compra.getQuantity() == 1) {
					minor = 0;
				} else {
					if ("paypal".equals(payType)) {
						if (compra.getProduct().getUniPrice() < minor) { // guarda
																			// el
																			// menor
							minor = compra.getProduct().getUniPrice();
						}

					} else {
						minor = 0;
					}
					if ("cash".equals(payType)) {
						minor = 0;
						if (compra.getProduct().getUniPrice() > higher) { // guarda
																			// el
																			// mayor
							higher = compra.getProduct().getUniPrice();
						}

					}

				}

				higher = higher * 0.9;
				compra.setConfirm(true);
				compraDAO.updateCompra(compra);
			}
			if ("credit card".equals(payType)) {
				minor = 0;
				finalPrice = price * 1.1;
			} else {
				finalPrice = (price - minor - higher);
			}
		}
		return finalPrice;

	}

	public List<Compra> estadoCompra(boolean estado) {
		return compraDAO.estadoCompra(estado);
	}

}
