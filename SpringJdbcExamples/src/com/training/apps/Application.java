package com.training.apps;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.daos.CustomerDao;
import com.training.entity.Customer;


public class Application {
	
	public static void main(String[] args){
		
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");){
			//Customer c = new Customer(126, "Ankit", "blah@hotmail.com", 7514254);
			
			CustomerDao dao = ctx.getBean(CustomerDao.class);
			
			//System.out.println(dao.add(c));
			
			//System.out.println(dao.find(125));
			
			List<Customer> customers = dao.findAll();
			
			for(Customer c : customers){
				System.out.println("------------------CUSTOMER------------------");
				System.out.println(c);
			}
		}
		
	}

}
