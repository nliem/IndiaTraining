package org.services.entity;

import java.text.DecimalFormat;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.training.utils.GlobalLogger;

@Component
public class Donation {
	
	private long donationId;
	private long donorId;
	private long projectId;
	private double donationAmount;
	
	private Logger log = GlobalLogger.getLogger();
	
	public Donation(){
		super();
		log.info("Donation object created [0-arg]");
	}

	public Donation(long donationId, long customerId, long projectId, double donationAmount) {
		super();
		this.donationId = donationId;
		this.donorId = customerId;
		this.projectId = projectId;
		this.donationAmount = donationAmount;
		log.info("Donation object created [fields]");
	}
	
	public long getDonationId() {
		return donationId;
	}

	public void setDonationId(long donationId) {
		this.donationId = donationId;
	}

	public long getDonorId() {
		return donorId;
	}

	public void setDonorId(long customerId) {
		this.donorId = customerId;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public double getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("#.00");
		
		sb.append("--------------------DONATION--------------------\n");
		sb.append("Donation Id:\t\t" + donationId + "\n");
		sb.append("Donor Hand Phone:\t" + donorId + "\n");
		sb.append("Project Id:\t\t" + projectId + "\n");
		sb.append("Donation Amount:\t$" + df.format(donationAmount) + "\n");
		
		return sb.toString();
	}

}
