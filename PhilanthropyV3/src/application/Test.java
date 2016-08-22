package application;

import donor.Donor;
import donor.DonorManager;
import exceptions.InvalidAmountException;
import exceptions.NullValueException;
import project.Project;
import project.ProjectManager;

public class Test {
	
	public static void main(String[] args){
		System.out.println("Testing Donor Manager Operations");
		
		try {
			//Adding a new Donor
			Donor d = new Donor(16, "Test Donor", "test@donor.com");
			DonorManager.getInstance().add(d);
			
			//Displaying all Donor info
			System.out.println(DonorManager.getInstance().displayAllData());
			
			//Displaying info for specific Donor
			System.out.println(DonorManager.getInstance().displayInformation(10));
			
			//Removing a Donor
			DonorManager.getInstance().remove(16);
			
		} catch (NullValueException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("Testing Project Manager Operations");
		
		Project p;
		try {
			// Adding a new Project
			p = new Project(11, "Test Project", "Descriptionnnn", 13000);
			ProjectManager.getInstance().add(p);
			
			//Dislplay all Project info
			System.out.println(ProjectManager.getInstance().displayAllData());
			
			//Display infor for specific Project
			System.out.println(ProjectManager.getInstance().displayInformation(11));
			
			//Removing a Project
			ProjectManager.getInstance().remove(11);
		} catch (NullValueException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (InvalidAmountException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
