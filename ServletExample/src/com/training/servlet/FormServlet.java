package com.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.domain.DueCalculator;

import java.util.logging.*;

/**
 * Servlet implementation class FormServlet
 */
public class FormServlet extends HttpServlet {
	
	//Controller

	private static final long serialVersionUID = 1L;
       
	
	private static final Logger log = Logger.getLogger("myLogger");
	
    public FormServlet() {
        super();
        log.info("Form Servlet Initialized...");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DecimalFormat df = new DecimalFormat("#.00");
		
		long number = Long.parseLong(request.getParameter("number"));
		//long number = Long.parseLong();
		//String email = request.getParameter("email");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		DueCalculator calc = new DueCalculator();
		double dues = calc.findDues(number);
		
		response.setContentType("json");
		
		PrintWriter out = response.getWriter();
		
		out.println("{\"dues\" : \"$" + df.format(dues) + "\"}");
		/*
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("Phone Number = " + number);
		out.println("Amount Due = $" + df.format(dues));
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		log.info("Servlet Destroyed...");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		log.info("Servlet Initialized...");
		super.init();
	}

}
