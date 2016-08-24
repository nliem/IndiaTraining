package domain;

import java.text.DecimalFormat;
import java.util.Date;

public class PaymentStatus {
	
	private int transactionId;
	private Date transactionDate;
	private String description;
	private double amount;
	
	public PaymentStatus(int id, Date date, String desc, double amount){
		this.transactionId = id;
		this.transactionDate = date;
		this.description = desc;
		this.amount = amount;
	}
	
	@Override
	public String toString(){
		DecimalFormat df = new DecimalFormat("#.00");
		StringBuilder sb = new StringBuilder();
		sb.append("Transaction #" + this.transactionId).append("\n");
		sb.append("Transaction Date:\t" + this.transactionDate).append("\n");
		sb.append("Description: " + this.description).append("\n");
		sb.append("Amount:\t$" + df.format(this.amount)).append("\n");
		return sb.toString();
	}

}
