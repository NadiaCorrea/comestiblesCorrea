package com.jacaranda.control;

import java.time.LocalDate;
import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.jacaranda.model.User;


public class UserControl {

	public UserControl() {
		
	}
	
	private static User getUserByUserName(String userName) {
		User user = null;
		
		Session session = ConnectionDB.getSession();
		Query<User> query = session.createQuery("SELECT u FROM com.jacaranda.model.User u WHERE u.userName LIKE '" +  userName + "'");
		user = query.getSingleResult();
		
		return user;		
	}

	public static User getUser(int id) {
		User result = null;
		
		Session session = ConnectionDB.getSession();
		result = session.get(User.class, id);
		
		return result;
	}
	
	public static ArrayList<User> getUsers() {
		ArrayList<User> users = null; 
		
		Session session = ConnectionDB.getSession();
		Query<User> query = session.createQuery("SELECT u FROM com.jacaranda.model.User u");
		users = (ArrayList<User>) query.getResultList();
		
		return users;
	
	}
	
	public static boolean addUser(String userName, String password, String name, String lastname, LocalDate dob, char sex,
			boolean admin) throws UserControlException {
		boolean result = false;
		Session session = ConnectionDB.getSession();
		
		try {
			User existUser = getUserByUserName(userName);
			
			if(existUser == null) {
				
				User newUser = new User(userName, password, name, lastname, dob, sex, admin);
				session.getTransaction().begin();
				session.save(newUser);
				session.getTransaction().commit();

				result = true;
			}
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new UserControlException(e.getMessage());
		}
		
		
		return result;
	}
	
	public static boolean deleteUser(int id) throws UserControlException {
		boolean result = false;
		
		Session session = ConnectionDB.getSession();
		
		try {
			User deleteUser = getUser(id);
			session.getTransaction().begin();
			session.delete(deleteUser);
			session.getTransaction().commit();
			
			result = true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new UserControlException(e.getMessage());
		}
	
		return result;
		
	}
	
	public static User checkUser(String userName, String password) throws UserControlException {
		User result = null;
		
		try {
			User existUser = getUserByUserName(userName);
			
			if (existUser.getPassword().equals(password)) {
				result = existUser;
			}
			
		} catch (Exception e) {
			throw new UserControlException(e.getMessage());
		}
		
		return result;
	}
	
	
}
