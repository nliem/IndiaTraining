package strategy;

import java.text.DecimalFormat;

public class CashPayment implements PaymentStrategy {

	@Override
	public void pay(double amount) {
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("Paying $" + df.format(amount) + " by cash.");
		
	}

}
