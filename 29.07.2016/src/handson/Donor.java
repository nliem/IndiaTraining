package handson;

import java.text.DecimalFormat;

public class Donor {
  
  private String name;
  private String email;
  private double lifetimeDonations;
  
  public Donor(String name, String email){
    this.name = name;
    this.email = email;
    this.lifetimeDonations = 0;
  }
  
  public String getName(){
    return this.name;
  }
  
  public String getEmail(){
    return this.email;
  }
  
  
  @Override 
  public String toString(){
    String result = "Donor Information\n";
    result += "Name:\t\t\t" + this.name + "\n";
    result += "Email:\t\t\t" + this.email + "\n";
    DecimalFormat df = new DecimalFormat("#.00");
    result += "Lifetime Donations:\t$" + df.format(this.lifetimeDonations) + "\n";
    return result;
  }
}
