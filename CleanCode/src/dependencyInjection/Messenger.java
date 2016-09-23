package dependencyInjection;

public interface Messenger {
	
	public void sendMessage(String recipient, String message);
	
	public void receiveMessage(String message);

}
