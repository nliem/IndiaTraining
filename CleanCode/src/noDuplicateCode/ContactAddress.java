package noDuplicateCode;

public class ContactAddress extends Address{
	
	public ContactAddress(){
		super();
	}
	
	public ContactAddress(String street, String zipCode, String city){
		super(street, zipCode, city);
	}
	
	@Override
	public String toString(){
		return super.toString();
	}

}
