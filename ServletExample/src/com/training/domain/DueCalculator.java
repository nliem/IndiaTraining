package com.training.domain;

//model 

import java.util.HashMap;

public class DueCalculator {

	private HashMap<Long, Double> dues;
	
	public DueCalculator(){
		dues = new HashMap<>();
	}
	
	private void init(){
		dues.put(4295726L, 100.0);
		dues.put(2181370L, 200.0);
	}
	
	public double findDues(Long number){
		this.init();
		return dues.get(number);
	}
}
