package dependencyInjection;

public class MessageSystem {
	
	private Messenger msgr;
	
	public MessageSystem(String type){
		msgr = MessengerFactory.getMessenger(type);
	}
	
	public void sendMessage(String recipient, String message){
		msgr.sendMessage(recipient, message);
	}
	
	public void receiveMessage(String message){
		msgr.receiveMessage(message);
	}

}
