package project;

import java.util.ArrayList;

import donor.Donor;

public class Project {
	
	private int projectId;
	private String projectName;
	private String projectDescription;
	private double projectCost;
	private double donationsCollected;
	private double outstandingCost;
	private ArrayList<Donor> donorList;
	
	public Project(int projectId, String projectName, String projectDescription, double projectCost){
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectCost = projectCost;
		this.donationsCollected = 0;
		this.outstandingCost = projectCost;
		this.donorList = new ArrayList<Donor>();
	}
	
	public int getProjectId(){
		return this.projectId;
	}

}
