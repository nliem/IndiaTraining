package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.Donor;
import application.DonorDAO;

/**
 * Servlet implementation class Writer
 */
public class Writer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Writer() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Donor donor = (Donor)session.getAttribute("donor");
		
		System.out.println("DONOR OBJECT OBTAINED BY WRITER SERVLET:\n" + donor);
		
		DonorDAO dao = new DonorDAO();
		
		int rowAdded = dao.add(donor);
		
		System.out.println(rowAdded + " ROWS ADDED");
		
		request.setAttribute("rowAdded", rowAdded);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Success.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
