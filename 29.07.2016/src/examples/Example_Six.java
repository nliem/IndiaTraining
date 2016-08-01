package examples;

public class Example_Six {

	public void printNames(String[] nameList)
	{
	     for(String name :nameList)
         {
        	 System.out.println(name);
         }
	}
	public void  updateNames(String[] nameList)
	{
			int i =0;
		for(String name : nameList)
		{
		   name ="Dr."+name;
			
		   nameList[i]=name;
		   i++;
			
		}
		
		printNames(nameList);
	}
	public static void main(String[] args) {
			System.out.println("Running Example 6...");

		   Example_Six obj =new Example_Six();
		   
		   String[] nameList = {"Ramesh","Ganesh","Magesh"};
		   
		   String[] nameCopy = new String[nameList.length];

		   System.arraycopy(nameList, 0, nameCopy, 0, nameList.length );
		   
            obj.updateNames(nameList);
		 
            /*
             * Should print Name without Prefix but prints with Prefix - Need to fix the bug
             */
            obj.printNames(nameCopy);
        
	}

}
