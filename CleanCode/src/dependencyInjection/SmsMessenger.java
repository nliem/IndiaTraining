package dependencyInjection;

public class SmsMessenger implements Messenger {
	
	public SmsMessenger(){
		super();
	}

	@Override
	public void sendMessage(String recipient, String message) {
		System.out.println("Sending SMS message to " + recipient + "\n" + message);
	}

	@Override
	public void receiveMessage(String message) {
		System.out.println("SMS message recieved:\n" + message);
	}

}
