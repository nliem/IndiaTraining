package strategy;

public class StrategyClient {
	
	public static void main(String[] args){
		Patient p = new Patient();
		p.setStrategy(new CreditPayment());
		p.makePayment(50);
		
		p.setStrategy(new CashPayment());
		p.makePayment(45);
	}

}
