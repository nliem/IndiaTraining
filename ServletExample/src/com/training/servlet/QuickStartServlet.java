package com.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.*;

/**
 * Servlet implementation class QuickStart
 */
public class QuickStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private static final Logger log = Logger.getLogger("myLogger");
	
    public QuickStartServlet() {
        super();
        
        //should only be logged once since only one instance of the servlet should be created
        log.info("QuickStart Servlet Initialized");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		out.println("<html>");
		
		out.println("<head>");
		
		out.println("<title>");
		
		out.println("Really Cool Page");
		
		out.println("</title>");
		
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h1 style = 'text-align:center'>Header Here</h1>");
		
		out.println("</body>");
		
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
