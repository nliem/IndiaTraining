package com.training;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;

import org.services.components.Address;
import org.services.daos.DonationDaoImpl;
import org.services.daos.DonorDaoImpl;
import org.services.daos.ProjectDaoImpl;
import org.services.entity.Donation;
import org.services.entity.Donor;
import org.services.entity.Project;
import org.services.interfaces.Dao;

public class Application {
	
	public static void main(String[] args){
		
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");){
			Dao<Donor> donorDao = context.getBean(DonorDaoImpl.class);
			Dao<Project> projectDao = context.getBean(ProjectDaoImpl.class);
			Dao<Donation> donationDao = context.getBean(DonationDaoImpl.class);
			
			System.out.println("-------ALL DONORS-------\n");
			System.out.println(donorDao.findAll());

			System.out.println("-------ALL PROJECTS-------\n");
			System.out.println(projectDao.findAll());
			
			System.out.println("-------ALL DONATIONS-------\n");
			System.out.println(donationDao.findAll());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
