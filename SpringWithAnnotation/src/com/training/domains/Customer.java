package com.training.domains;

import org.springframework.stereotype.Component;

@Component("customerBean")
public class Customer {
	

	private long customerId;
	
	private String customerName;
	
	private Address customerAddress;
	
	public Customer(){
		super();
		System.out.println("Default constructor called.");
	}
	
	public long getCustomerId(){
		return customerId;
	}
	
	public void setCustomerId(long customerId){
		this.customerId = customerId;
	}
	
	public String getCustomerName(){
		return customerName;
	}
	
	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}
	
	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("Customer Name:\t" + customerName + "\n");
		sb.append("Customer Number:\t" + customerId + "\n");
		sb.append("Customer Address:\n" + customerAddress + "\n");
		
		return sb.toString();
	}

}
