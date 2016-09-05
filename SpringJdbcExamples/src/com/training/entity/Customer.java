package com.training.entity;

import org.springframework.stereotype.Component;

@Component("customerBean")
public class Customer {
	
	private long customerNumber;
	private String customerName;
	private String email;
	private long phoneNumber;
	
	public Customer(){
		super();
	}
	
	public Customer(long customerNumber, String customerName, String email, long phoneNumber){
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Customer Name:\t\t" + customerName + "\n");
		sb.append("Customer Number:\t" + customerNumber + "\n");
		sb.append("Email:\t\t\t" + email + "\n");
		sb.append("Phone Number:\t\t" + phoneNumber + "\n");
		return sb.toString();
	}
	
	public long getCustomerNumber() {
		return customerNumber;
	}
	
	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
