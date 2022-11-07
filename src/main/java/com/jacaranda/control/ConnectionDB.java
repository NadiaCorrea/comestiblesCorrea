package com.jacaranda.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * 
 * @author NadiaC
 * Method which creates a Data base connection 
 */
public class ConnectionDB {
	
	private static StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
	private static SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
	private static Session session = sf.openSession();

	
	/**
	 * Method that gets a data base session 
	 * @return a session
	 */
	public static Session getSession() {
		return session; 
	}

}
