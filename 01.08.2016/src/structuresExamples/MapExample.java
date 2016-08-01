package structuresExamples;

import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {
  
  public static void main(String[] args){
    
    CreditCard c1 = new CreditCard(101, "Natalie", 80000, 5000);
    CreditCard c2 = new CreditCard(102, "Shorab", 90000, 600);
    CreditCard c3 = new CreditCard(103, "Natile", 40000, 5000);
    
    Hashtable<String, CreditCard> table = new Hashtable<>();
    
    table.put("A101", c1);
    table.put("A102", c2);
    table.put("A103", c3);
    
    //System.out.println(obj);
    //System.out.println(table.get("A102"));
    //System.out.println(table.get("A101"));
    
    Set<Entry<String, CreditCard>> entries = table.entrySet();
    
    for(Entry<String, CreditCard> entry : entries){
      System.out.println(entry.getKey());
      System.out.println(entry.getValue().getCardHolderName());
    }
  }

}
