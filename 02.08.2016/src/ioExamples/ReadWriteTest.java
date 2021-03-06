package ioExamples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

public class ReadWriteTest {
	
	public static void main(String[] args){
		
		Invoice i1 = new Invoice(101, "Natalie", 50.23);
		Invoice i2 = new Invoice(102, "Bob", 50);
		Invoice i3 = new Invoice(103, "Sonny", 700);
		Invoice i4 = new Invoice(104, "Shorab", 90);
		
		ArrayList<Invoice> invoices = new ArrayList<>();
		invoices.add(i1);
		invoices.add(i2);
		invoices.add(i3);
		invoices.add(i4);
		
		writeDetails(invoices);
		Collection<Invoice> result = readDetails();
		
		for(Invoice i : result){
			System.out.println(i);
		}
		
	}
	
	public static boolean writeDetails(Collection<Invoice> invoiceList){
		
		String path = "C:\\Users\\nliem\\Desktop\\list.txt";
		
		boolean result = false;
		
		try{
			PrintWriter out = new PrintWriter(new FileWriter(path));
			for(Invoice i : invoiceList){
				out.println(i.toString());
			}
			out.close();
			return true;
		}
		catch(Exception e){
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Collection<Invoice> readDetails(){
		Collection<Invoice> details = new ArrayList<Invoice>();
		String path = "C:\\Users\\nliem\\Desktop\\list.txt";
		
		try{
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			
			ArrayList<String> lines = new ArrayList<>();
			
			try{
				while((line = br.readLine())!=null){
					lines.add(line);
				}
				
				for(String l : lines){
					String[] split = l.split("\t");
					int id = Integer.parseInt(split[0]);
					String name = split[1];
					double amount = Double.parseDouble(split[2].substring(1, split[2].length()));
					
					details.add(new Invoice(id, name, amount));
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			br.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return details;
	}

}
