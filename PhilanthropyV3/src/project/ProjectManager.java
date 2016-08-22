package project;

import java.util.Collection;

import daos.ProjectDao;
import exceptions.NullValueException;
import interfaces.Manager;

public class ProjectManager implements Manager<Project> {
	
	private static ProjectManager instance;
	private ProjectDao dao;
	
	private ProjectManager(){
		this.dao = new ProjectDao();
	}
	
	public static ProjectManager getInstance(){
		if(instance == null){
			instance = new ProjectManager();
		}
		return instance;
	}

	@Override
	public void add(Project newValue) throws NullValueException {
		int rowAdded = dao.add(newValue);
		
		switch(rowAdded){
		case 0:
			System.out.println("Project was not added.");
			break;
		case 1:
			System.out.println("Project was inserted into table.");
			break;
		default:
			System.out.println("YOU GOT PROBLEMS!!!");
			break;
		}
		
	}

	@Override
	public void remove(int identification) {
		int rowRemoved = dao.remove(identification);
		
		switch(rowRemoved){
		case 0:
			System.out.println("Project was not removed.");
			break;
		case 1:
			System.out.println("Project was removed.");
			break;
		default:
			System.out.println("YOU GOT PROBLEMS!!!");
			break;
		}
		
	}

	@Override
	public String displayInformation(int identification) {
		Project result = dao.get(identification);
		return result.toString();
	}

	@Override
	public String displayAllData() {
		Collection<Project> projects = dao.getAll();
		
		StringBuilder sb = new StringBuilder();
		for(Project p : projects){
			sb.append(p.toString()).append("\n");
		}
		
		return sb.toString();
	}

}
