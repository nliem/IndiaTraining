package donor;

import java.text.DecimalFormat;

import exceptions.NullValueException;

public class Donor {
	
	private int donor_id;
	private String donor_name;
	private String donor_email;
	private double donor_totaldonations;
	
	public Donor(int d_id, String d_name, String d_email, double d_total) 
		throws NullValueException{
		if(d_name == null){
			throw new NullValueException("Donor name cannot be null.");
		}
		if(d_email == null){
			throw new NullValueException("Donor email cannot be null.");
		}
		
		donor_id = d_id;
		donor_name = d_name;
		donor_email = d_email;
		donor_totaldonations = d_total;
	}
	
	public Donor(int d_id, String d_name, String d_email) throws NullValueException{
		this(d_id, d_name, d_email, 0);
	}
	
	public int getDonorId(){
		return this.donor_id;
	}
	
	public String getDonorName(){
		return this.donor_name;
	}
	
	public String getDonorEmail(){
		return this.donor_email;
	}
	
	public double getDonorTotalDonations(){
		return this.donor_totaldonations;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("#.00");
		
		sb.append("Donor #: " + donor_id + "\n");
		sb.append("Name: " + donor_name + "\tEmail: " + donor_email).append("\n");
		sb.append("Total amount donated: $" + df.format(donor_totaldonations)).append("\n\n");
		
		return sb.toString();
	}

}
