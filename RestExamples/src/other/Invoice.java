package other;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Invoice implements Serializable {
	
	private static final long serialVersionUID = 10L;
	private int invoiceNumber;
	private String customerName;
	private transient double amount;
	private String email;

	public Invoice(int invoiceNumber, String customerName, double amount){
		this.invoiceNumber = invoiceNumber;
		this.customerName = customerName;
		this.amount = amount;
	}
	
	
	public void whatever(){
		int i = 3;
	}
	
	public Invoice(){
		super();
	}
	
	public String toString(){
		DecimalFormat df = new DecimalFormat("#.00");
		return invoiceNumber + "\t" + customerName + "\t$" + df.format(amount);
	}
}
