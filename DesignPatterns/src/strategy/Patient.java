package strategy;

public class Patient {
	
	private PaymentStrategy strategy;
	
	public Patient(){
		
	}
	
	public void setStrategy(PaymentStrategy strategy){
		this.strategy = strategy;
	}
	
	public void makePayment(double amount){
		this.strategy.pay(amount);
	}

}
