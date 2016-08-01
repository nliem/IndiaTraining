package examples;

public class Example_Five {

	 private String name="Ramesh";
	 
	 
	 public void show(String user){
		 		 
		 if (user.equals(name))
		 {
			 System.out.println("Valid User");
		 }
	 }
	public static void main(String[] args) {
		System.out.println("Running Example 5...");
   		 
		Example_Five obj = new Example_Five();

		  obj.show(new String("Ramesh"));
		  
	}

}
