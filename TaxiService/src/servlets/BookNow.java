package servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import booking.Booking;
import taxi.Taxi;
import taxi.TaxiManager;

/**
 * Servlet implementation class BookNow
 */
public class BookNow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookNow() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Got to BookNow.java!!!");
		
		HttpSession session = request.getSession();
		
		Booking booking = (Booking)session.getAttribute("booking");
		
		System.out.println("BOOKING RECEIVED IN BOOKNOW.JAVA:\n" + booking);
		
		Collection<Taxi> taxis = TaxiManager.getInstance().findLocationTaxis(booking.getPickup());
			
		request.setAttribute("taxis", taxis);
		
		
		request.setAttribute("location", booking.getPickup());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("AvailableCabs.jsp");
		
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
