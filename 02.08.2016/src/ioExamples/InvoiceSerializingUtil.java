package ioExamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class InvoiceSerializingUtil {
	
	public static void serialize(Invoice i, String path){
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(path)));
			
			out.writeObject(i);
			
			System.out.println(i + "\nSerialized in " + path);
			
			out.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static Invoice deserialize(String path){
		Invoice i = null;
		try{
			ObjectInputStream inObj = new ObjectInputStream(new FileInputStream(path));
			i = (Invoice) inObj.readObject();
			System.out.println(i + "\nDeserialized.");
			
			inObj.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			return i;
		}
	}

}
