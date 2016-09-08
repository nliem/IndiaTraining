package com.training.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {
	
	@Autowired
	private ModelAndView mdl;
	
	@ExceptionHandler(value=DuplicateKeyException.class)
	public ModelAndView duplicateHandler(HttpServletRequest req, Exception ex){
		
		mdl.setViewName("Error");
		mdl.addObject("message", "Object with primary key already exists. Unique key constraint violated.");
		mdl.addObject("cause",ex.getMessage());
		mdl.addObject("exceptionClass", ex.getClass());
		mdl.addObject("requestUri", req.getRequestURI());
		
		return mdl;
	}

}
