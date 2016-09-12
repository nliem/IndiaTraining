package com.training.utils;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtils {
	
	private static SessionFactory factory;
	
	public static SessionFactory getSessionFactory(){
		if(factory == null){
			factory = new Configuration().configure().buildSessionFactory();
		}
		
		return factory;	
	}
	
	public static void closFactory(){
		factory.close();
	}

}
