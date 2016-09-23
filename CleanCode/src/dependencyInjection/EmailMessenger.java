package dependencyInjection;

public class EmailMessenger implements Messenger{
	
	public EmailMessenger(){
		super();
	}

	@Override
	public void sendMessage(String recipient, String message) {
		System.out.println("Sending Email message to " + recipient + 
				"\n" + message);	
	}

	@Override
	public void receiveMessage(String message) {
		System.out.println("Email message recieved:\n" + message);
	}

}
