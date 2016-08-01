package collectionsExamples;

import java.util.Comparator;

public class NameComparator implements Comparator<Donor> {
  @Override
  public int compare(Donor o1, Donor o2) {
    if(o1.getDonorName().compareTo(o2.getDonorName()) > 1) return 1;
    if(o1.getDonorName().compareTo(o2.getDonorName()) < 1) return -1;
    return 0;
  }

}
