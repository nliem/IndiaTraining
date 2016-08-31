package taxi;

public class Taxi {
	private String cabnumber;
	private String cabtype;
	private String drivername;
	private String location;
	private short available;
	
	public Taxi(){
		super();
	}
	
	public Taxi(String cabnumber, String cabtype, String drivername,
			String location, short available){
		this.cabnumber = cabnumber;
		this.cabtype = cabtype;
		this.drivername = drivername;
		this.location = location;
		this.available = available;
	}

	public String getCabnumber() {
		return cabnumber;
	}

	public void setCabnumber(String cabnumber) {
		this.cabnumber = cabnumber;
	}

	public String getCabtype() {
		return cabtype;
	}

	public void setCabtype(String cabtype) {
		this.cabtype = cabtype;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public short getAvailable() {
		return available;
	}

	public void setAvailable(short available) {
		this.available = available;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("----------TAXI INFORMATION----------").append("\n");
		sb.append("Cab Number:\t" + this.cabnumber).append("\n");
		sb.append("Type:\t" + this.cabtype).append("\n");
		sb.append("Driver:\t" + this.drivername).append("\n");
		sb.append("Location:\t" + this.location).append("\n");
		sb.append("Available:\t" + ((this.available == 1)? "True" : "False")).append("\n");
		sb.append("------------------------------------").append("\n");
		
		return sb.toString();
	}

}
