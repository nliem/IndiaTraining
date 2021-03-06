package com.training;

import org.apache.log4j.Logger;

public class CurrencyConverter {
	
	//Logger log = Logger.getRootLogger();
	
	Logger log = Logger.getLogger("com");
	
	public CurrencyConverter(){
		super();
		log.info("Constructor called.");
	}
	
	
	public double usdToINR(double usd){
		double amount = Math.abs(usd);
		
		if(usd < 0){
			log.warn("Negative value provided, converted to positive");
		}
		
		log.info("InrAMount" + usd*60);
		
		return 60.00 * amount;
	}

}
