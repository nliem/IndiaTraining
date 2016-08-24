package servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserManager;

/**
 * Servlet implementation class Validator
 */
public class Validator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserManager manager;
       
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
		String username = (String) request.getParameter("txtUsername");
		String password = (String) request.getParameter("txtPassword");
		
		System.out.println("USERNAME: " + username);
		System.out.println("PASSWORD: " + password);
		//InputStream inStream= this.getClass().getClassLoader().getResourceAsStream("DbConnection.properties");
		 
		//System.out.println(inStream);

		boolean valid = manager.validate(username, password);
		RequestDispatcher view;
		
		if(valid){
			view = request.getRequestDispatcher("Success.jsp");
		}
		else{
			view = request.getRequestDispatcher("Failure.jsp");
		}
		
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		InputStream inStream= this.getClass().getClassLoader().getResourceAsStream("DbConnection.properties");
		manager = new UserManager(this.getClass().getClassLoader().getResourceAsStream("DbConnection.properties"));
	}

	@Override
	public void destroy() {
		System.out.println("CALLING DESTROY()!!!");
		manager.shutDown();
		super.destroy();
	}

}
