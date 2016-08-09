package project;

import java.text.DecimalFormat;

import exceptions.InvalidAmountException;
import exceptions.NullValueException;

public class Project {
	
	private int project_id;
	private String project_name;
	private String project_description;
	private double project_cost;
	private double project_collectedamount;
	
	public Project(int p_id, String p_name, String p_description, double p_cost) throws
		NullValueException, InvalidAmountException{
		if(p_name == null){
			throw new NullValueException("Project name cannot be null.");
		}
		if(p_description == null){
			throw new NullValueException("Project description cannot be null.");
		}
		if(p_cost < 0){
			DecimalFormat df = new DecimalFormat("#.00");
			throw new InvalidAmountException("Invalid project cost of $" + df.format(p_cost));
		}
		
		project_id = p_id;
		project_name = p_name;
		project_description = p_description;
		project_cost = p_cost;
		project_collectedamount = 0;
	}
	
	public Project(int p_id, String p_name, String p_description, double p_cost, double p_collected) 
		throws NullValueException, InvalidAmountException{
		if(p_name == null){
			throw new NullValueException("Project name cannot be null.");
		}
		if(p_description == null){
			throw new NullValueException("Project description cannot be null.");
		}
		if(p_cost < 0){
			DecimalFormat df = new DecimalFormat("#.00");
			throw new InvalidAmountException("Invalid project cost of $" + df.format(p_cost));
		}
		if(p_collected < 0){
			DecimalFormat df = new DecimalFormat("#.00");
			throw new InvalidAmountException("Invalid collection amount of $" + df.format(p_collected));
		}
		
		project_id = p_id;
		project_name = p_name;
		project_description = p_description;
		project_cost = p_cost;
		project_collectedamount = p_collected;
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
	
	public double getProjectCollectedAmount(){
		return this.project_collectedamount;
	}
	
	@Override
	public String toString(){
		DecimalFormat df = new DecimalFormat("#.00");
		
		StringBuilder sb = new StringBuilder();
		sb.append("Project #: " + this.project_id).append("\n");
		sb.append("Project name: " + this.project_name).append("\n");
		sb.append(this.project_description);
		sb.append("$" + df.format(this.project_collectedamount) + " collected of $" + df.format(this.project_cost)).append("\n");
		sb.append("\n");
		
		return sb.toString();
	}

}
