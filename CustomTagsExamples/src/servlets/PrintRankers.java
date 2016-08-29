package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Student;
import domain.StudentRanks;

/**
 * Servlet implementation class PrintRankers
 */
@WebServlet("/PrintRankers")
public class PrintRankers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintRankers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SERVLET doGet() METHOD CALLED"); 
		
		String dept = request.getParameter("txtDept");
		
		Double minMark = Double.parseDouble(request.getParameter("txtMark"));
		
		
		//dept = "CS";
		System.out.println("MIN MARK RECEIVED = " + minMark);
		
		System.out.println("DEPARTMENT RECEIVED = " + dept + " (in PrintRanker.java)");
	
		StudentRanks sr = new StudentRanks();
		
		List<Student> studentList = sr.findTopRankers(dept, minMark);
		
		request.setAttribute("rankList", studentList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("PrintTopRankers.jsp");
		
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
