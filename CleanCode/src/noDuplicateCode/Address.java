package noDuplicateCode;

public class Address {
	
	protected String street;
	protected String zipCode;
	protected String city;
	
	public Address(){
		super();
	}
	
	public Address(String street, String zipCode, String city){
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString(){
		return street + "\n" + city + " - " + zipCode + "\n";
	}

}
