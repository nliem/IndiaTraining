package booking;

import java.sql.Timestamp;
import java.text.DecimalFormat;

public class Booking {
	
	private String id;
	private String customeremail;
	private String cabnumber;
	private String vehiclename;
	private String pickup;
	private String dropoff;
	private String chargetype;
	private double fare;
	private Timestamp tripdate;
	private String status;
	
	public Booking(){
		super();
	}
	
	public Booking(String id, String customeremail, String cabnumber,
			String vehiclename, String pickup, String dropoff,
			String chargetype, double fare, Timestamp tripdate, String status){
		this.id = id;
		this.customeremail = customeremail;
		this.cabnumber = cabnumber;
		this.vehiclename = vehiclename;
		this.pickup = pickup;
		this.dropoff = dropoff;
		this.chargetype = chargetype;
		this.fare = fare;
		this.tripdate = tripdate;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getChargetype(){
		return chargetype;
	}
	public void setChargetype(String chargetype){
		this.chargetype = chargetype;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public Timestamp getTripdate() {
		return tripdate;
	}
	public void setTripdate(Timestamp tripdate) {
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
		
		sb.append("----------BOOKING INFORMATION----------").append("<br/>");
		sb.append("Booking #:\t" + this.id).append("<br/>");
		sb.append("Customer Email:\t" + this.customeremail).append("<br/>");
		sb.append("Cab Number:\t" + this.cabnumber).append("<br/>");
		sb.append("Vehicle Name:\t" + this.vehiclename).append("<br/>");
		sb.append("Pickup:\t\t" + this.pickup).append("<br/>");
		sb.append("Dropofff:\t" + this.dropoff).append("<br/>");
		sb.append("Charge Type:\t" + this.chargetype).append("<br/>");
		sb.append("Trip Date: " + this.tripdate + "\tFare: $" + df.format(this.fare));
		sb.append("<br/>").append("Status:\t" + this.status).append("<br/>");
		sb.append("---------------------------------------").append("<br/>");
		
		return sb.toString();
	}

}
