package com.bootcamp.proyecto.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bootcamp.proyecto.model.entity.Product;
import com.bootcamp.proyecto.service.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/addProduct", method=RequestMethod.GET)
	public ModelAndView addProduct (String name, double uniPrice, String category){
		productService.agregarPruducto(name, uniPrice, category);
		return new ModelAndView("redirect:/allProducts");
	}
	
	@RequestMapping(value="/removeProduct", method=RequestMethod.GET)
	public ModelAndView removeProduct (@RequestParam(value="name")String name){
		productService.removerProducto(name);
		return new ModelAndView("redirect:/allProducts");
	}
	
	@RequestMapping(value="/allProducts", method=RequestMethod.GET)
	public @ResponseBody List<Product> getAllProduct (){
		List<Product> products =productService.getProducts();
		return products;
	}
	
	@RequestMapping(value="/searchProductId", method=RequestMethod.GET)
	public @ResponseBody Product getProduct (@RequestParam(value="id")int productId){
		return productService.getProduct(productId);
		
	}
	
	@RequestMapping(value="/searchProductName", method=RequestMethod.GET)
	public @ResponseBody Product getProduct (String name){
		return productService.getProduct(name);
		
	}
	
	@RequestMapping(value="/searchProductCategory", method=RequestMethod.GET)
	public @ResponseBody List<Product> getProductByCategory (String category){
		List<Product> products=productService.getProductByCategory(category);
		return products;
	}
	
	@RequestMapping(value="/setUniPrice", method=RequestMethod.GET)
	public ModelAndView setUniPrice (@RequestParam(value="id")int productId,double uniPrice){
		productService.setUniPrice(productId, uniPrice);
		return new ModelAndView("redirect:/allProducts");
		
	}
	
	
	
	
}
