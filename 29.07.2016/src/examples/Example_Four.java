package examples;

public class Example_Four {

	public static void display(int key){
		
		 System.out.println("Value"+key);
	}

	public static void main(String[] args) {
		
		System.out.println("Running Example 4...");

		/**
		 *  Prints the Same Value for two different options
		 */
		for(int i =0;i<=3;i++)
		{
		switch (i) {
		case 1:
			display(i);
			break;
		case 2:
			display(i);
			break;
		case 3:
			display(i);
			break;
		default:
			break;
		}
		}
	}
}
