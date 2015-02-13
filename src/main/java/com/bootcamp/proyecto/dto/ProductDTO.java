package com.bootcamp.proyecto.dto;

import java.util.List;

import com.bootcamp.proyecto.model.entity.Product;

public class ProductDTO {
	private int id;
	private String name;
	private double uniPrice;
	private String category;
	
	public ProductDTO (Product product){
		this.id=product.getId();
		this.name=product.getName();
		this.uniPrice=product.getUniPrice();
		this.category=product.getCategory();
		
	}
}
