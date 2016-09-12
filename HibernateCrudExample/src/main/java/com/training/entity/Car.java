package com.training.entity;

import com.training.component.Address;

public class Car {
	
	private String registerNumber;
	private String ownerName;
	private Address officeAddress;
	private Address homeAddress;
	
	public Car(){
		super();
	}
	
	public Car(String registerNumber, String ownerName, Address officeAddress, Address homeAddress){
		this.registerNumber = registerNumber;
		this.ownerName = ownerName;
		this.officeAddress = officeAddress;
		this.homeAddress = homeAddress;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Register Number:\t" + registerNumber + "\n");
		sb.append("Owner Name:\t\t" + ownerName + "\n");
		sb.append("Office Address:\n" + officeAddress + "\n");
		sb.append("Home Address:\n" + homeAddress + "\n");
		return sb.toString();
	}
}
