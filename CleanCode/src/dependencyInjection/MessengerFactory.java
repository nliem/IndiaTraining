package dependencyInjection;

public class MessengerFactory {
	
	public static Messenger getMessenger(String type){
		if(type.toLowerCase().equals("sms")){
			return new SmsMessenger();
		}
		else if (type.toLowerCase().equals("email")){
			return new EmailMessenger();
		}
		else{
			return null;
		}
	}

}
