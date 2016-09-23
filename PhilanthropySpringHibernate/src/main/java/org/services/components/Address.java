package org.services.components;

import org.springframework.stereotype.Component;

@Component
public class Address {
	
	private String addressLine1;
	private String addressLine2;
	private String city;
	private long zipCode;
	
	public Address(){
		super();
	}

	public Address(String addressLine1, String addressLine2, String city, long zipCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.zipCode = zipCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(addressLine1 + "\n");
		sb.append(addressLine2 + "\n");
		sb.append(city + " " + zipCode + "\n");
		
		return sb.toString();
	}

}
