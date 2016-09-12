package com.training.daos;

import com.training.interfaces.MyDao;
import com.training.utils.HibernateUtils;

import org.hibernate.classic.Session;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.training.entity.Car;

public class CarDaoImpl implements MyDao<Car> {
	
	private static SessionFactory factory;
	
	public CarDaoImpl(){
		super();
		factory = HibernateUtils.getSessionFactory();
	}

	public Object add(Car object) {
		String key = null;
		
		Session session = factory.openSession();
		
		Transaction trans = session.beginTransaction();
		
		key = (String)session.save(object);
		
		trans.commit();
		
		return key;
	}

	public Car find(Object key) {
		Car result = null;
		
		Session session = factory.openSession();
		
		result = (Car)session.get(Car.class, (Serializable) key);
		
		return result;
	}

}
