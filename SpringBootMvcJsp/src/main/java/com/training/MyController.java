package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@Autowired
	private ModelAndView modelView;
	
	@Autowired
	private RestTemplate template;
	
	@RequestMapping("/")
	public String welcome(){
		return "index";
	}
	
	@RequestMapping(value="/reports", method=RequestMethod.GET)
	public ModelAndView viewReports(){
		modelView.setViewName("ShowReports");
		
		System.out.println("Hit viewReports in MyController.");
		
		String reports = template.getForObject("http://localhost:3030/findAll", String.class);
		
		modelView.addObject("reports", reports);
		
		return modelView;
	}

}
