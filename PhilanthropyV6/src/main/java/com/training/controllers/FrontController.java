package com.training.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

	@RequestMapping("/")
	public String indexPage(){
		System.out.println("indexPage()");
		return "index";
	}
	
	@RequestMapping("/index")
	public String testPage(){
		System.out.println("testPage()");
		return "/WEB-INF/jsp/Test.jsp";
	}

}
