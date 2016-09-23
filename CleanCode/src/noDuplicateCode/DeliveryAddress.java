package noDuplicateCode;

public class DeliveryAddress extends Address{
	
	public DeliveryAddress(){
		super();
	}
	
	public DeliveryAddress(String street, String zipCode, String city){
		super(street, zipCode, city);
	}
	
	@Override
	public String toString(){
		return super.toString();
	}

}
