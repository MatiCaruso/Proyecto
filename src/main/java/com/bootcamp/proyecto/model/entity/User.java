package com.bootcamp.proyecto.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User  {

	@Id @GeneratedValue
	private int id;
	@Column(nullable=false, length=30)
	private String user;
	@Column(nullable=false, length=30)
	private String pass;
	
	public User(){
		
	}
	public User(String user, String pass) {
		this.user=user;
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public String getUser() {
		return user;
	}

	
	public void setUser(String user) {
		this.user = user;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + user + "]";
	}
	
	
	
}
