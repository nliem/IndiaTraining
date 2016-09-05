package com.training.domains;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("insuranceBean")
public class LifeInsurance {

	@Value("100001")
	private long policyNumber;
	
	@Value("50000")
	private double policyAmount;
	
	@Autowired 
	@Qualifier("customerBean")
	private Customer customer;
	
	public LifeInsurance(){
		super();
	}
	
	public double findFirstPremium(){
		double firstPremium = 0.0;
		
		double premium = (policyAmount * 0.01);
		
		if(premium > 1500){
			firstPremium = premium - 500;
		}
		else{
			firstPremium = premium;
		}
		
		return firstPremium;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("init() method called...");
	}
	
	@PreDestroy
	public void cleanUp(){
		System.out.println("cleanUp() method called..."); 
	}
	
	public long getPolicyNumber(){
		return policyNumber;
	}
	
	public void setPolicyNumber(long policyNumber){
		this.policyNumber = policyNumber;
	}
	
	public double getPolicyAmount(){
		return policyAmount;
	}
	
	public void setPolicyAmount(double policyAmount){
		this.policyAmount = policyAmount;
	}
	
	public Customer getCustomer(){
		return customer;
	}
	
	public void setCustomer(Customer customer){
		this.customer = customer;
	}
}
