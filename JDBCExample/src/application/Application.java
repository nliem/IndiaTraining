package application;

import java.util.List;

import utils.MySQLConnection;

public class Application {
	
	public static void main(String[] args){
		System.out.println(MySQLConnection.getMyOracleConnection());
		
		Donor donor1 = new Donor(101, "Natalie", 1234567, "natalie@liem.com");
		Donor donor2 = new Donor(102, "Alyssa", 3214567, "al@hi.com");
		Donor donor3 = new Donor(103, "Me", 7451352, "me@nat.com");
		Donor donor4 = new Donor(104, "Hi", 1237895, "hi@hello.com");
		
		
		DonorDAO test = new DonorDAO();
		
		/*
		test.add(donor1);
		test.add(donor2);
		test.add(donor3);
		test.add(donor4);
		*/

		
		List<Donor> donorList = test.findAll();
		
		System.out.println("Printing all donors found in result set");
		for(Donor d : donorList){
			System.out.println(d);
		}
		
		System.out.println(test.updateProcedure(103, "UPDATED"));
		System.out.println(test.updateProcedure(5, "something@sapient.com"));
		
		donorList = test.findAll();

		System.out.println("Printing all donors found in result set");
		for(Donor d : donorList){
			System.out.println(d);
		}
		
	}

}
