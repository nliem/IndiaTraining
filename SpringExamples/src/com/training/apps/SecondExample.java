package com.training.apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.domains.Doctor;
import com.training.domains.Patient;

public class SecondExample {
	
	public static void main(String[] args){
		
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");){
			
			Doctor doctor = ctx.getBean("doctorBean1", Doctor.class);
			System.out.println("DOCTOR BEAN #1\n" + doctor);
			
			System.out.println("DOCTOR BEAN #2\n" + ctx.getBean("doctorBean2", Doctor.class));
			
			System.out.println("DOCTOR BEAN #3\n" + ctx.getBean("doctorBean3", Doctor.class));
			
			System.out.println("DOCTOR BEAN #4\n" + ctx.getBean("doctorBean4", Doctor.class));
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
