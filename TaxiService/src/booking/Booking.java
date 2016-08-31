package booking;

import java.text.DecimalFormat;
import java.util.Date;

public class Booking {
	
	private int id;
	private String customeremail;
	private String cabnumber;
	private String vehiclename;
	private String pickup;
	private String dropoff;
	private double fare;
	private Date tripdate;
	private String status;
	
	public Booking(){
		super();
	}
	
	public Booking(int id, String customeremail, String cabnumber,
			String vehiclename, String pickup, String dropoff,
			double fare, Date tripdate, String status){
		this.id = id;
		this.customeremail = customeremail;
		this.cabnumber = cabnumber;
		this.vehiclename = vehiclename;
		this.pickup = pickup;
		this.dropoff = dropoff;
		this.fare = fare;
		this.tripdate = tripdate;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomeremail() {
		return customeremail;
	}
	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}
	public String getCabnumber() {
		return cabnumber;
	}
	public void setCabnumber(String cabnumber) {
		this.cabnumber = cabnumber;
	}
	public String getVehiclename() {
		return vehiclename;
	}
	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getDropoff() {
		return dropoff;
	}
	public void setDropoff(String dropoff) {
		this.dropoff = dropoff;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public Date getTripdate() {
		return tripdate;
	}
	public void setTripdate(Date tripdate) {
		this.tripdate = tripdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString(){
		DecimalFormat df = new DecimalFormat("#.00");
		StringBuilder sb = new StringBuilder();
		
		sb.append("----------BOOKING INFORMATION----------").append("\n");
		sb.append("Booking #:\t" + this.id).append("\n");
		sb.append("Customer Email:\t" + this.customeremail).append("\n");
		sb.append("Cab Number:\t" + this.cabnumber).append("\n");
		sb.append("Vehicle Name:\t" + this.vehiclename).append("\n");
		sb.append("Pickup:\t" + this.pickup).append("\n");
		sb.append("Dropofff:\t" + this.dropoff).append("\n");
		sb.append("Trip Date: " + this.tripdate + "\tFare: $" + df.format(this.fare));
		sb.append("\n").append("Status:\t" + this.status).append("\n");
		sb.append("---------------------------------------").append("\n");
		
		return sb.toString();
	}

}
