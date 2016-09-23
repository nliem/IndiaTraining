package noDuplicateCode;

public class InvoiceAddress extends Address{
	
	public InvoiceAddress(){
		super();
	}
	
	public InvoiceAddress(String street, String zipCode, String city){
		super(street, zipCode, city);
	}
	
	@Override
	public String toString(){
		return super.toString();
	}

}
