package com.training.utils;

import org.apache.log4j.Logger;

public class GlobalLogger {
	
	private static final Logger log = Logger.getRootLogger();
	
	public static Logger getLogger(){
		return log;
	}

}
