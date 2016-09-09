package com.training;

import org.springframework.stereotype.Component;

public class MyDataSource {
	
	private String driverClass;
	private String jdbcURL;
	
	public MyDataSource(){
		super();
	}
	
	public MyDataSource(String driverClass, String jdbcURL) {
		super();
		this.driverClass = driverClass;
		this.jdbcURL = jdbcURL;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getJdbcURL() {
		return jdbcURL;
	}

	public void setJdbcURL(String jdbcURL) {
		this.jdbcURL = jdbcURL;
	}
	
	@Override
	public String toString(){
		return "Driver Class:\t" + driverClass + "\nUrl:\t\t" + jdbcURL + "\n";
	}

}
