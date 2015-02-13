package com.bootcamp.proyecto.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(nullable=false, length=30)
	private String name;
	@Column(nullable=false)
	private double uniPrice;
	@Column(nullable=false, length=30)
	private String category;
	
	public Product(){
		
	}
	public Product(String name, double uniPrice, String category) {
		this.name=name;
		
		this.uniPrice=uniPrice;
		this.category=category;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public double getUniPrice() {
		return uniPrice;
	}
	public String getCategory() {
		return category;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setUniPrice(double uniPrice) {
		this.uniPrice = uniPrice;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", uniPrice=" + uniPrice + ", category=" + category + "]";
	}
	
	

}
