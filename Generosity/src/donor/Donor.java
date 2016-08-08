package donor;

public class Donor {
	
	private int donorId;
	private String donorName;
	private String donorEmail;
	private double lifetimeDonations;
	
	public Donor(int donorId, String donorName, String donorEmail){
		this.donorId = donorId;
		this.donorName = donorName;
		this.donorEmail = donorEmail;
	}
	
	public int getDonorId(){
		return this.donorId;
	}

}