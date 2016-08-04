package classes;

public class CurrencyConverter {
	
	public double usdToINR(double usd){
		double amount = Math.abs(usd);
		return 60.00 * amount;
	}

}
