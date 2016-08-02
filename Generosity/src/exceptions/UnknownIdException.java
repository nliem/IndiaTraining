package exceptions;

public class UnknownIdException extends Exception {
	
	public UnknownIdException(String method){
		super(method);
	}
	
	public UnknownIdException(){
		super();
	}

}
