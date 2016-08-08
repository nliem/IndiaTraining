package project;

import java.text.DecimalFormat;

import exceptions.*;

public class Project {
	
	private int project_id;
	private String project_name;
	private String project_description;
	private double project_cost;
	
	public Project(int project_id, String project_name, String project_desc, double project_cost)
	  throws InvalidAmountException, NullValueException{
		if(project_name == null){
			//should I also be logging here? TODO
			throw new NullValueException("Project name cannot be null. Project was not created.");
		}
		if(project_desc == null){
			//should I also be logging here? TODO
			throw new NullValueException("Project description cannot be null. Project was not created.");
		}
		if(project_cost <= 0){
			//should I also be logging here? TODO
			DecimalFormat df = new DecimalFormat("#.00");
			throw new InvalidAmountException("Invalid project cost of $" + df.format(project_cost));
		}
		
		this.project_id = project_id;
		this.project_name = project_name;
		this.project_description = project_desc;
		this.project_cost = project_cost;
	}
	
	public int getProjectId(){
		return this.project_id;
	}
	
	public String getProjectName(){
		return this.project_name;
	}
	
	public String getProjectDescription(){
		return this.project_description;
	}
	
	public double getProjectCost(){
		return this.project_cost;
	}

}
