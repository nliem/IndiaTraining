package structuresExamples;

import java.util.TreeSet;

public class SetExample {
  
  public static void main(String[] args){
    TreeSet<CreditCard> cardList = new TreeSet<CreditCard>();
    cardList.add(new CreditCard(101, "Natalie", 75000, 5800));
    cardList.add(new CreditCard(102, "Joe", 80000, 67800));
    
    System.out.println(cardList);
  }

}
