package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.daos.CustomerDao;
import com.training.entity.Customer;

@Import(Customer.class)
@Controller
@RequestMapping("/addCustomer")
public class CustomerController {
	
	@Autowired
	private ModelAndView mdlView;
	
	@Autowired 
	private Customer customerBean;
	
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView initForm(){
		mdlView.setViewName("AddCustomer");
		
		mdlView.addObject("command", customerBean);
		
		return mdlView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("itemAdded") Customer cust){
		customerDao.add(cust);
		
		return "Finished";
	}
	
	@RequestMapping(value = "findCustomer", method = RequestMethod.GET)
	public String findCustomer(@RequestParam("key") int key, Model model){
		Customer foundCustomer = customerDao.find(key);
		
		model.addAttribute("foundCustomer", foundCustomer);
		
		return "ShowCustomer";
	}
	
	@RequestMapping( value = "showAll", method=RequestMethod.GET)
	public String findAllCustomers(Model model){
		List<Customer> customerList = customerDao.findAll();
		model.addAttribute("customerList", customerList);
		return "ShowAllCustomers";
	}

}
