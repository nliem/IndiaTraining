package donation;

import java.text.DecimalFormat;

import exceptions.InvalidAmountException;

public class Donation {
	
	private int donation_id;
	private int donor_id;
	private int project_id;
	private double donation_amount;
	
	public Donation(int donation_id, int donor_id, int project_id, double donation_amount)
		throws InvalidAmountException{
		if(donation_amount < 0){
			throw new InvalidAmountException("Donation amount must be positive.");
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
	
	private double getDonationAmount(){
		return this.donation_amount;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("#.00");
		
		sb.append("Donation #: " + donation_id).append("\n");
		sb.append("Donor #: " + donor_id + "\tProject #: " + project_id).append("\n");
		sb.append("Donation amount: $" + df.format(donation_amount)).append("\n\n");
		
		return sb.toString();
	}

}
