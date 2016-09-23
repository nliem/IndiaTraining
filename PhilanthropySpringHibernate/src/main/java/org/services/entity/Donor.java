package org.services.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.apache.log4j.Logger;
import org.services.components.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.utils.GlobalLogger;

@Component
public class Donor {
	
	private long handPhone;
	private String donorName;
	private String email;
	private Set<Donation> donationList;
	
	private Logger log = GlobalLogger.getLogger();
	
	@Autowired
	private Address address;
	
	public Donor(){
		super();
		donationList = new HashSet<Donation>();
		log.info("Donor object created [0-arg]");
	}

	public Donor(long handPhone, String donorName, String email, Address address, Set<Donation> donationList) {
		super();
		this.handPhone = handPhone;
		this.donorName = donorName;
		this.email = email;
		this.address = address;
		this.donationList = donationList;
		
		log.info("Donation object created [fields]");
	}

	public long getHandPhone() {
		return handPhone;
	}

	public void setHandPhone(long handPhone) {
		this.handPhone = handPhone;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
		
		sb.append("\n--------------------DONOR--------------------\n");
		sb.append("Donor Hand Phone:\t" + handPhone + "\n");
		sb.append("Donor Name:\t\t" + donorName + "\n");
		sb.append("Customer Email:\t\t" + email + "\n");
		sb.append("Donor Address:\n" + address + "\n");
		sb.append("Donation List:\n" + donationList + "\n");
		
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object other){
		if(other == null) return false;
		if(other.getClass() != this.getClass()) return false;
		Donor that = (Donor) other;
		if(this.handPhone != that.handPhone) return false;
		return true;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(handPhone);
	}
}
