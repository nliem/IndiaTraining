package org.services.entity;

import java.text.DecimalFormat;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.training.utils.GlobalLogger;

@Component
public class Project {
	
	private long projectId;
	private String projectName;
	private double projectBudget;
	private double amountCollected;
	
	private Logger log = GlobalLogger.getLogger();
	
	private Set<Donation> donationList;
	
	public Project(){
		super();
		
		log.info("Project object created [0-arg]");
	}

	public Project(long projectId, String projectName, double projectBudget, Set<Donation> donationList) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectBudget = projectBudget;
		this.donationList = donationList;
		log.info("Project object created [fields]");
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public double getProjectBudget() {
		return projectBudget;
	}

	public void setProjectBudget(double projectBudget) {
		this.projectBudget = projectBudget;
	}

	public double getAmountCollected() {
		return amountCollected;
	}

	public void setAmountCollected(double amountCollected) {
		this.amountCollected = amountCollected;
	}

	public Set<Donation> getDonationList() {
		return donationList;
	}

	public void setDonationList(Set<Donation> donationList) {
		this.donationList = donationList;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("#.00");
		
		sb.append("--------------------PROJECT--------------------\n");
		sb.append("Project Id:\t" + projectId + "\n");
		sb.append("Project Name:\t" + projectName + "\n");
		sb.append("Project Budget:\t$" + df.format(projectBudget) + "\n");
		sb.append("Amount Collected:\t$" + df.format(amountCollected) + "\n");
		sb.append("Donations Received:\n" + donationList + "\n");
		
		return sb.toString();
	}

}
