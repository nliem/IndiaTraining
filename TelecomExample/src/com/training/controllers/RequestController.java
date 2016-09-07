package com.training.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.daos.RequestDao;
import com.training.entity.Request;

@Controller
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	private ModelAndView mdlView;
	
	@Autowired
	private Request request;
	
	@Autowired
	private RequestDao requestDao;
	
	@ModelAttribute("requestTypes")
	public String[] getRequestTypes(){
		return new String[] {"Technical", "Payment Related", "Special Offers"};
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView initForm(){
		mdlView.setViewName("AddRequest");
		
		//command desing pattern - object sent from server side to client
		//associated with a form "backing bean"
		mdlView.addObject("command", request);
		
		return mdlView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid @ModelAttribute("command") Request request, BindingResult result){
		
		if(result.hasErrors()){
			return "AddRequest";
		}
		else{
			requestDao.add(request);
			
			return "Success";
		}	
	}
	
	@RequestMapping(value = "findRequests", method = RequestMethod.GET)
	public String findRequests(@RequestParam("type") String type, Model model){
		
		List<Request> requestList = requestDao.findType(type);
		
		model.addAttribute("requestList", requestList);
		
		return "ShowRequests";
	}
	

}
