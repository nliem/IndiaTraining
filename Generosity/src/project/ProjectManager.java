package project;

import java.util.HashMap;

import exceptions.UnknownIdException;
import interfaces.Manager;

public class ProjectManager implements Manager<Project>{
	
	private HashMap<Integer, Project> projectList;
	private static ProjectManager instance;
	
	public static ProjectManager getInstance(){
		if(instance == null){
			instance = new ProjectManager();
		}
		return instance;
	}
	
	private ProjectManager(){
		this.projectList = new HashMap<Integer, Project>();
	}

	@Override
	public void add(Project newvalue) {
		projectList.put(newvalue.getProjectId(), newvalue);
	}

	@Override
	public void remove(int identification) throws UnknownIdException {
		if(!projectList.containsKey(identification)){
			throw new UnknownIdException("No project found with id " + identification);
		}
		projectList.remove(identification);
	}

	@Override
	public String displayInformation(int identification) throws UnknownIdException {
		Project proj = projectList.get(identification);
		if(proj == null){
			throw new UnknownIdException("No project found with id " + identification);
		}
		return proj.toString();
		
	}

	@Override
	public String displayAllData() {
		StringBuilder sb = new StringBuilder();
		for(int key : projectList.keySet()){
			sb.append(projectList.get(key).toString()).append("\n");
		}
		return sb.toString();
	}

}
