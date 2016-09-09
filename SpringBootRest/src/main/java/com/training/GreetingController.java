package com.training;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.domains.TestReport;

@RestController
public class GreetingController {
	
	private HashMap<String, TestReport> reports;
	
	@PostConstruct
	public void init(){
		reports = new HashMap<>();
		
		reports.put("SEP101", new TestReport("Ramesh", 1, "B+", "Blood Test"));
		reports.put("SEP102", new TestReport("Ganesh", 2, "124", "Weight"));
		reports.put("SEP103", new TestReport("Vamesh", 3, "12", "BMI"));
	}

	@RequestMapping("/")
	public String welcome(){
		return "Welcome to REST!";
	}
	
	@RequestMapping("/findAll")
	public Map<String, TestReport> getReports(){
		return reports;
	}

}
