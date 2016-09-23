package com.training;

import org.services.daos.ShoppingCartDaoImpl;
import org.services.entity.ShoppingCart;
import org.services.interfaces.Dao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	
	public static void main(String[] args){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		
		Dao<ShoppingCart> dao = (ShoppingCartDaoImpl)context.getBean(ShoppingCartDaoImpl.class);
		
		ShoppingCart cart = context.getBean(ShoppingCart.class);
		
		cart.setCartId(10001);
		cart.setItem("Chocolate");
		
		//int id = (Integer) dao.add(cart);
		
		//System.out.println("Cart with id " + id + " was added.");
		
		System.out.println(dao.find(10001));
		
		context.close();
	}

}
