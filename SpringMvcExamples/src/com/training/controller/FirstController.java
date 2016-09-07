package com.training.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FirstController implements Controller {
	
	@Autowired
	private ModelAndView mdlView;

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String message = "Welcome to Spring MVC";
		
		mdlView.addObject("msg", message);
		mdlView.setViewName("Success");
		return mdlView;
	}

}
