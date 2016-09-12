package com.training.apps;

import com.training.component.Address;
import com.training.daos.CarDaoImpl;
import com.training.entity.Car;

public class Test {
	
	public static void main(String[] args){
		Address home = new Address("431 S. Dearborn Street #708", "Chicago", "60605");
		Address office = new Address("77 W. Washington Street", "Chicago", "60606");
		
		Car car = new Car("US001", "Natalie Liem", office, home);
		
		CarDaoImpl cd = new CarDaoImpl();
		
		//System.out.println(cd.add(car));
		
		System.out.println(cd.find("US001"));
		
	}

}
