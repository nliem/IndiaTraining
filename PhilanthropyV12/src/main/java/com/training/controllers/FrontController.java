package com.training.controllers;

import java.util.List;

import org.services.daos.ProjectDaoImpl;
import org.services.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController {
	
	//make bean here??? yes? no?
	@Autowired
	private ProjectDaoImpl dao;
	
	@Autowired
	private ModelAndView mdlView;
	
	@RequestMapping("/")
	public String indexPage(){
		System.out.println("indexPage()");
		return "index";
	}
	
	@RequestMapping("/getProjects")
	public ModelAndView getProjectsPage(){
		//dao = new ProjectDaoImpl();
		
		List<Project> projects = dao.findAll();
		
		mdlView.addObject("projects", projects);
		
		mdlView.setViewName("Projects");
		
		return mdlView;
	}

}
