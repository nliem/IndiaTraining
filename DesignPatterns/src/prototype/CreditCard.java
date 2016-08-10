package prototype;


public class CreditCard implements Cloneable{
	
	private long cardNumber;
	private String cardHolderName;
	private String creditRating;
	private double creditLimit;
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

}
