package com.bootcamp.proyecto.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="ShoppingCart")
public class Cart {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne
	private User user;
	
	public Cart(){
		
	}
	public Cart(User user) {
		this.user=user;
	}
	public int getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString(){
		return String.format("Cart[id=%d, user=%d]", id,user);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		
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
		Cart other = (Cart) obj;
		if (id != other.id)
			return false;
		if (user != other.user)
			return false;
		return true;
	}
	
	

}
