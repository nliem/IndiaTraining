package servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import booking.Booking;
import booking.BookingManager;
import taxi.Taxi;
import taxi.TaxiManager;

/**
 * Servlet implementation class BookCab
 */
@WebServlet("/BookCab")
public class BookCab extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookCab() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Random rand = new Random();
		
		Booking booking = (Booking) session.getAttribute("booking");
		
		String cabNumber = request.getParameter("cabNumber");
		
		Taxi cab = TaxiManager.getInstance().findEntry(cabNumber);
		
		System.out.println(booking);
		System.out.println(cabNumber);
		System.out.println(cab);
		
		String id = booking.getCustomeremail().substring(0, 4) + cabNumber + "_" + rand.nextInt(99999);
		
		Double fare = 500.00;
		
		Date today = Calendar.getInstance().getTime();
		
		Calendar.getInstance().setTime(today);
		Calendar.getInstance().set(Calendar.MILLISECOND, 0);
		
		Timestamp tripdate = new Timestamp(Calendar.getInstance().getTimeInMillis());
		
		String status = "SCHEDULED";
		
		Booking completedBooking = new Booking(id, booking.getCustomeremail(), cabNumber, cab.getCabtype(), booking.getPickup(),
				booking.getDropoff(), booking.getChargetype(), fare, tripdate, status);
		
		boolean added = BookingManager.getInstance().add(completedBooking);
		
		if(!added){
			request.setAttribute("bookingError", "Something went wrong with your booking... Please try again.");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Booking.jsp");
			
			dispatcher.forward(request, response);
		}
		
		request.setAttribute("completeBooking", completedBooking);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Confirmation.jsp");
		
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
