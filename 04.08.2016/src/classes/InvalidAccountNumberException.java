package classes;

public class InvalidAccountNumberException extends Exception {
	
	public InvalidAccountNumberException(String message){
		super(message);
	}
	
	public InvalidAccountNumberException(){
		super();
	}

}
