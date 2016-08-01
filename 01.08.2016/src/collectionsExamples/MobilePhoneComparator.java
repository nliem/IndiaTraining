package collectionsExamples;

import java.util.Comparator;

public class MobilePhoneComparator implements Comparator<Donor> {

  @Override
  public int compare(Donor o1, Donor o2) {
    if(o1.getMobileNumber() > o2.getMobileNumber()) return 1;
    if(o1.getMobileNumber() < o2.getMobileNumber()) return -1;
    return 0;
  }

}
