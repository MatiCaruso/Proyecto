package com.bootcamp.proyecto.model.dao.imp;

import java.util.List;

import com.bootcamp.proyecto.model.dao.UserDAO;
import com.bootcamp.proyecto.model.entity.Compra;
import com.bootcamp.proyecto.model.entity.User;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImplementation implements UserDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public UserDAOImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<User> getUser() {
		
		List<User> Users = null;
		Users = (List<User>) sessionFactory.getCurrentSession().createQuery("FROM User").list();
		
		return Users;
	}

	@Override
	public User getUser(String name) {
		
		User user = (User) sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.user=:name").setParameter("name", name).uniqueResult();
		return user;
	}

	@Override
	public User getUser(int userId) {
		
		User user = (User) sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.id = :id").setParameter("id", userId).uniqueResult();
		return user;
	}

	@Override
	public void addUser(User user) {
		try{
			sessionFactory.getCurrentSession().save(user);
		}finally{}
	}

	@Override
	public void removeUser(String user,String pass) {
		List<User> deleteUsers = (List<User>) sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.user=:name AND u.pass= :pass").setParameter("name", user).setParameter("pass", pass).list();
		for(User deleteUser : deleteUsers){
		sessionFactory.getCurrentSession().delete(deleteUser);
		}
	}

}
