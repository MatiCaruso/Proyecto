package com.bootcamp.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bootcamp.proyecto.model.entity.Cart;
import com.bootcamp.proyecto.model.entity.Compra;
import com.bootcamp.proyecto.model.entity.Product;
import com.bootcamp.proyecto.service.CartService;
import com.bootcamp.proyecto.service.CompraService;
import com.bootcamp.proyecto.service.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompraController {
	@Autowired
	private CompraService compraService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/addCompra", method = RequestMethod.GET)
	public ModelAndView addCompra(int cartId, int productId, int quantity) {
		Product product = productService.getProduct(productId);
		Cart cart = cartService.getCart(cartId);
		compraService.agregarCompra(cart, product, quantity);
		return new ModelAndView("redirect:/allCompras");
	}

	@RequestMapping(value = "/removeCompra", method = RequestMethod.GET)
	public ModelAndView removeCompra(int compraId) {
		Compra compra = compraService.getCompra(compraId);
		compraService.removerCompra(compra);
		return new ModelAndView("redirect:/allCompras");
	}

	@RequestMapping(value = "/allCompras", method = RequestMethod.GET)
	public @ResponseBody List<Compra> getAllCompra() {
		List<Compra> compras = compraService.getCompras();
		return compras;
	}

	@RequestMapping(value = "/searchCompraByCart", method = RequestMethod.GET)
	public @ResponseBody List<Compra> searchCompraByCart(int cartId) {
		Cart cart = cartService.getCart(cartId);
		List<Compra> compras = compraService.getComprasByCart(cart);
		return compras;
	}

	@RequestMapping(value = "/searchCompraByProduct", method = RequestMethod.GET)
	public @ResponseBody List<Compra> searchCompra(int productId) {
		Product product = productService.getProduct(productId);
		List<Compra> compras = compraService.getComprasByProduct(product);
		return compras;

	}

	@RequestMapping(value = "/confirmaCompra", method = RequestMethod.GET)
	public @ResponseBody Double comfirmaCompra(int cartId, int payOption) {
		double finalPrice = (double) compraService.comfirmaCompra(cartId,
				payOption);

		return finalPrice;
	}

	@RequestMapping(value = "/comprasConfirmadas", method = RequestMethod.GET)
	public @ResponseBody List<Compra> comprasConfirmadas() {
		List<Compra> compras = compraService.estadoCompra(true);
		return compras;

	}

	@RequestMapping(value = "/comprasNoConfirmadas", method = RequestMethod.GET)
	public @ResponseBody List<Compra> comprasNoConfirmadas() {
		List<Compra> compras = compraService.estadoCompra(false);
		return compras;

	}
}
