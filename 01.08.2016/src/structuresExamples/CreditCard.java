package structuresExamples;

public class CreditCard implements Comparable<CreditCard> {
  
  private long cardNumber;
  private String cardHolderName;
  private long cardLimit;
  private double billAmount;
  
  public CreditCard() {
    super();
  }
  
  public CreditCard(long cardNumber, String cardHolderName, long cardLimit, double billAmount){
    super();
    this.cardHolderName = cardHolderName;
    this.cardNumber = cardNumber;
    this.cardLimit = cardLimit;
    this.billAmount = billAmount;
  }
  
  public CreditCard(long cardNumber){
    this(cardNumber, "Guest", 7500, 7500);
  }
  
  public void setLimit (long limit){
    this.cardLimit = limit;
  }
  
  public long getLimit(){
    return this.cardLimit;
  }
  
  public void setCardHolderName(String name){
    this.cardHolderName = name;
  }
  
  public String getCardHolderName(){
    return this.cardHolderName;
  }
  
  public void setCardNumber(long cardNumber){
    this.cardNumber = cardNumber;
  }

  public long getCardNumber(){
    return this.cardNumber;
  }
  
  public double getAmountSpent(){
    return this.billAmount;
  }
  
  public double calculateBillAmuont(){
    double billAmount = 0.05 * this.cardLimit;
    
    return billAmount;
  }
  
  @Override
  public String toString(){
    String result = "Card Information\n";
    result += "Card holder name: " + this.cardHolderName;
    result += "\nCard number: " + this.cardNumber;
    result +="\n" + super.toString();
    return result;
  }

  @Override
  public int compareTo(CreditCard o) {
    if(this.cardNumber > o.cardNumber) return 1;
    if(this.cardNumber < o.cardNumber) return -1;
    return 0;
  }
  

}
