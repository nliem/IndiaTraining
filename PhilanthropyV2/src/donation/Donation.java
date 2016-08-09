package donation;

import java.text.DecimalFormat;

import exceptions.InvalidAmountException;

public class Donation {
	private int donation_id;
	private int donor_id;
	private int project_id;
	private double donation_amount;
	
	public Donation(int donation_id, int donor_id, int project_id, double donation_amount) throws InvalidAmountException{
		DecimalFormat df = new DecimalFormat("#.00");
		if(donation_amount <= 0){
			throw new InvalidAmountException("Invalid donation amount of $" + df.format(donation_amount));
		}
		
		this.donation_id = donation_id;
		this.donor_id = donor_id;
		this.project_id = project_id;
		this.donation_amount = donation_amount;
	}
	
	public int getDonationId(){
		return this.donation_id;
	}
	
	public int getDonorId(){
		return this.donor_id;
	}
	
	public int getProjectId(){
		return this.project_id;
	}
	
	public double getDonationAmount(){
		return this.donation_amount;
	}

}
