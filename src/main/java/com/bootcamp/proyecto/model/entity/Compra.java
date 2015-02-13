package com.bootcamp.proyecto.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Compras")
public class Compra {
	@Id @GeneratedValue
	private int id;
	@OneToOne
	private Cart cart;
	@OneToOne
	private Product product;
	@Column(nullable=false)
	private int quantity;
	@Column(nullable=false)
	private boolean confirm;
	
	public Compra(){
		
	}
	public Compra(Cart cart, Product product, int quantity) {
		this.cart=cart;
		this.product=product;
		this.quantity=quantity;
		this.confirm=false;
	}
	public boolean getConfirm(){
		return confirm;
	}
	public int getId(){
		return id;
	}
	
	public int getCart() {
		return cart.getId();
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setConfirm(boolean confirm){
		this.confirm= confirm;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(int cantidad) {
		quantity = cantidad;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + id;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		Compra other = (Compra) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (id != other.id)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Compra [id=" + id + ", Cart=" + cart + ", Product="
				+ product + ", quantity=" + quantity + "]";
	}

	
}
