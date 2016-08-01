package collectionsExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
  
  public static void main(String[] args){
    Donor donor1 = new Donor(100, "Natalie Liem", 4295726, "nliem2@sapient.com");
    Donor donor2 = new Donor(101, "Alyssa Liem", 2181370, "aliem@gmail.com");
    Donor donor3 = new Donor(3, "Mr Roboto", 5568716, "domoarigato@mrroboto.com");
    
    DonorImpl donorImpl = new DonorImpl();
    
    donorImpl.addDonor(donor1);
    donorImpl.addDonor(donor2);
    donorImpl.addDonor(donor3);
    
    List<Donor> donors = donorImpl.getDonorList();
    
    System.out.println("Sort by Donor Code:");
    Collections.sort(donors);
    donorImpl.printDonorList();
    System.out.println();
    
    System.out.println("Sort by Name:");
    NameComparator nameComp = new NameComparator();
    donorImpl.printByOrder(nameComp);
    System.out.println();
    
    System.out.println("Sort by Mobile Number:");
    MobilePhoneComparator mobileComp = new MobilePhoneComparator();
    donorImpl.printByOrder(mobileComp);
    System.out.println();
  }

}
