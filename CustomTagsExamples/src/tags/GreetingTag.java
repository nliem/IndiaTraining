package tags;

import java.util.logging.*;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

public class GreetingTag extends javax.servlet.jsp.tagext.TagSupport {
	
	private String message;
	private static Logger log = Logger.getLogger("myLogger");
	
	public GreetingTag(){
		super();
		log.info("Greeting Tag Initialized");
	}
	
	public void setMessage(String message){
		this.message = message;
		log.info("SETTER METHOD CALLED");
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		
		try{
			if(message != null){
				out.println(message + " (Printed from doStartTag()...)");
			}
			else{
				out.println("Welcome to Tag Programming!!!");
			}
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		
		return Tag.SKIP_BODY; 
	}

}
