package ioExamples;

public class SerializeTest {
	
	public static void main(String[] args){
		Invoice testInvoice = new Invoice(101, "Natalie Liem", 90);
		
		String path = "C:\\Users\\nliem\\Desktop\\test.ser";
		
		//InvoiceSerializingUtil.serialize(testInvoice, path );
		
		Invoice test2 = InvoiceSerializingUtil.deserialize(path);
		
		System.out.println("Tests completed");
	}

}
