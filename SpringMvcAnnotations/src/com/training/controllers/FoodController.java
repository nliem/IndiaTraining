package com.training.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.domains.Food;

@Controller
@RequestMapping("/addFood")
public class FoodController {
	
	@Autowired
	private ModelAndView mdlView;
	
	@Autowired
	private Food food;
	
	@ModelAttribute("refData")
	public String[] getCuisineData(){
		return new String[] {"Indian", "French", "Chinese", "US", "Japanese"};
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView initForm(){
		mdlView.setViewName("AddFood");
		
		mdlView.addObject("command", food);
		
		return mdlView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid @ModelAttribute("command") Food food, BindingResult result){
		
		System.out.println(result.hasErrors());
		
		if(result.hasErrors()){
			return "AddFood";
		}
		else{
			return "Welcome";
		}
	}
}
