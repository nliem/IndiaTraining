package com.training.apps;

import java.text.DecimalFormat;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.domains.LifeInsurance;

public class Application {
	
	public static void main(String[] args){
		
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");){
			DecimalFormat df = new DecimalFormat("#.00");
			
			LifeInsurance insurance = ctx.getBean("insuranceBean", LifeInsurance.class);
			
			System.out.println("Policy Number:\t" + insurance.getPolicyNumber());
			System.out.println("Policy Amount:\t$" + df.format(insurance.getPolicyAmount()));
			System.out.println("First Premium:\t$" + df.format(insurance.findFirstPremium()));
			System.out.println("Customer Name:\t" + insurance.getCustomer());
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
