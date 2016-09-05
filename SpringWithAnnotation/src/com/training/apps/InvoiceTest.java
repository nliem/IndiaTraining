package com.training.apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.domains.Invoice;

public class InvoiceTest {
	
	public static void main(String[] args){
		
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("practicalBean.xml");){
			Invoice inv = ctx.getBean("invoiceBean", Invoice.class);
			
			System.out.println(inv);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
