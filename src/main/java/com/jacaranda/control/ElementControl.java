package com.jacaranda.control;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.jacaranda.model.Category;
import com.jacaranda.model.Element;
import com.jacaranda.model.User;

public class ElementControl {

	public ElementControl() {
		
	}

	public static ArrayList<Element> getElements() {
		ArrayList<Element> elements = null; 
		
		Session session = ConnectionDB.getSession();
		Query<Element> query = session.createQuery("SELECT e FROM com.jacaranda.model.Element e");
		elements = (ArrayList<Element>) query.getResultList();
		
		return elements;
	}
	
	public static Element getElement(int id) {
		Element ele = null; 
		
		Session session = ConnectionDB.getSession();
		ele = session.get(Element.class, id);
		
		return ele;
	}
	
	
	private static ArrayList<Element> getElementsByCategory(Category category){
		ArrayList<Element> elements = null; 
		
		Session session = ConnectionDB.getSession();
		Query<Element> query = session.createQuery("SELECT e FROM com.jacaranda.model.Element WHERE category = '" +  category.getCatId() + "'");
		elements = (ArrayList<Element>) query.getResultList();
		
		return elements;
		
	}

	
	
	
	
	
}
