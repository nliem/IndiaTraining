package examples;

public class Example_Three {

	 private int passMark;
	 
	public Example_Three(int passMark){
		this.passMark = passMark;
	}

	public void printPassMark(int[] marks){
		
		 
		 
		 for(int mark : marks)
		 {
			 if(mark>=passMark)
			 {
				 System.out.println("Pass");
			 }
		 }
	}
	public static void main(String[] args) {
		
		/*
		 *  Should Print if mark is greater than 60 
		 *  but Prints Pass for All Marks fix it
		 *  
		 */

		 int[]  marks={20,90,89,89};

		Example_Three obj =new Example_Three(60);
		
		  obj.printPassMark(marks);
		 
		 
	}
}
