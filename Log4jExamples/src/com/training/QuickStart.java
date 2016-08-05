package com.training;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class QuickStart {
	
	static Logger log = Logger.getLogger("example");

	
	public static void main(String[] args){
		
		log.setAdditivity(false);//suppresses root logger so we don't get 2x output

		BasicConfigurator.configure();
		
		PatternLayout layout = new PatternLayout("%d [%t] %-5p %c %x - %m %n");
		log.addAppender(new ConsoleAppender(layout));
		
		
		try{
			log.info("Inside Try Block");
		}
		catch(Exception e){
			log.warn("Esception Message");
		}
	}

}
