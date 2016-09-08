package com.training.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.exceptions.RangeCheckException;

@Controller("studentController")
public class StudentController {
	
	@Autowired
	private ModelAndView mdl;
	
	@RequestMapping(value = "/getStudentDetails", method = RequestMethod.GET)
	public String findStudent(@RequestParam("rollNumber") int rollNumber) throws RangeCheckException{
		String nextStep = "StudentDetails";
		
		if(rollNumber > 1000 || rollNumber <= 0){
			throw new RangeCheckException("Roll Number range 1-1000. Value of " + rollNumber + " is invalid.");
		}
		
		return nextStep;
	}
	
	@ExceptionHandler(value = RangeCheckException.class)
	public ModelAndView errorHandler(HttpServletRequest req, Exception ex){
		mdl.addObject("cause",ex.getMessage());
		mdl.addObject("exceptionClass", ex.getClass());
		mdl.addObject("requestUri", req.getRequestURI());
		mdl.setViewName("Bugs");
		
		return mdl;
	}

}
