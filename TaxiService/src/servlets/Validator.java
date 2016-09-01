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
 * Servlet implementation class Validator
 */
public class Validator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validator() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		TaxiUser user = (TaxiUser)session.getAttribute("user");
		
		boolean isValid = TaxiUserManager.getInstance().validateUser(user);
		
		if(!isValid){
			request.setAttribute("message", "Invalid email or password.");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			
			dispatcher.forward(request, response);
		}
		
		TaxiUser fullDetails = TaxiUserManager.getInstance().findEntry(user.getEmail());
		
		if(isValid){
			request.setAttribute("sessionUser", fullDetails.getName());
			
			request.setAttribute("Name", fullDetails.getName());
			
			request.setAttribute("Telephone", fullDetails.getTelephone());
			
			request.setAttribute("Email", fullDetails.getEmail());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Booking.jsp");
			
			dispatcher.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
