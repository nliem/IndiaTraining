package com.training.domains;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private String username;
	private String password;
	private long telephoneNumber;
	
	public User(){
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(long telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	@Override
	public String toString(){
		return "Username: " + username + "<br/>Password: " + password + "<br/>Phone Number: " +
				telephoneNumber + "<br/>";
	}

}
