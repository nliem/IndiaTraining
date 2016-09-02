package com.training.apps;

import com.training.domains.Patient;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstExample {
	
	public static void main(String[] args){
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");){
			
			Patient patientBean = ctx.getBean(Patient.class);
			System.out.println("Bean Returned by IoC Container:\n" + patientBean);
			
			System.out.println("Bean 1 HashCode:\t" + patientBean.hashCode());
			
			Patient patientBean2 = ctx.getBean(Patient.class);
			System.out.println("Bean 2 HashCode:\t" + patientBean2.hashCode());
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
