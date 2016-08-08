package project;

import interfaces.Manager;

public class ProjectManager implements Manager<Project> {
	
	private static ProjectManager instance;
	//private ProjectDao dao;
	
	private ProjectManager(){
		//this.dao = new ProjectDao();
	}
	
	public static ProjectManager getInstance(){
		if(instance == null){
			instance = new ProjectManager();
		}
		return instance;
	}

	@Override
	public void add(Project newValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int identification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String displayInformation(int identification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String displayAllData() {
		// TODO Auto-generated method stub
		return null;
	}

}
