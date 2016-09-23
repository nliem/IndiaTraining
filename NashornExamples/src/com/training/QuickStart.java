package com.training;

import java.io.File;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class QuickStart {
	
	public static void main(String[] args){
		ScriptEngineManager mgr = new ScriptEngineManager();
		
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		try{
			engine.eval("print('Hello from Nashorn')");
			
			engine.eval(new FileReader(new File("Simple.js")));
			
			Invocable inv = (Invocable)engine;
			
			Object result = inv.invokeFunction("greet", "Ramesh");
			
			System.out.println(result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
