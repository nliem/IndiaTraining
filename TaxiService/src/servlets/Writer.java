package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.TaxiUser;
import user.TaxiUserManager;

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
		
		TaxiUser user = (TaxiUser)session.getAttribute("user");
		
		boolean added = TaxiUserManager.getInstance().add(user);
		
		if(!added){
			request.setAttribute("message", "Sorry, a user with that email is already registered. Please try again.");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			
			dispatcher.forward(request, response);
		}
		
		request.setAttribute("Name", user.getName());
		
		request.setAttribute("Telephone", user.getTelephone());
		
		request.setAttribute("Email", user.getEmail());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Booking.jsp");
		
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
