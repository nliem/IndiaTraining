package application;

import project.Project;

public class DataGenerator {
	
	public static Project[] generateProjectTestData(){
		Project cancerProj1 = new Project(101, "Curing Lung Cancer", "Fixing lung cancer by banning smoking (and vapping).", 2000);
		Project cancerProj2 = new Project(102, "Beating Breast Cancer", "Early detection to save livies.", 4000);
		Project oldProj1 = new Project(201, "Building Afforable Nursing Homes", "Cheap living for old folks.", 6000);
		Project edProj1 = new Project(302, "Global Teachers", "Sending teachers around the globe to educate.", 3500);
		
		return null;
	}

}
