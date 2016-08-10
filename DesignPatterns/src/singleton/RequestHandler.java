package singleton;

public class RequestHandler {
	
	private static RequestHandler instance;
	
	private RequestHandler(){
		super();
	}
	
	public static RequestHandler getInstance(){
		if(instance == null){
			synchronized(RequestHandler.class){
				if(instance == null) instance = new RequestHandler();
			}
		}
		return instance;
	}
	
	public void sayHi(){
		System.out.println("HI");
	}

}
