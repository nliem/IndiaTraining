package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class LoggingFilter
 */
public class LoggingFilter implements Filter {
	
	private static final Logger log = Logger.getRootLogger();

    /**
     * Default constructor. 
     */
    public LoggingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		String url = req.getRequestURL().toString();
		
		log.debug("Request From: " + url);
		
		chain.doFilter(request, response);
		
		System.out.println(req.getRequestURL());
		
		if(req.getRequestURI().equals("/FiltersListenersExamples/MyServlet")){
			System.out.println("MATCHES!!!");
			//modifies the response sent by the servlet!
			response.getWriter().println("<br/>Claim your free gift!!");
		}	
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
