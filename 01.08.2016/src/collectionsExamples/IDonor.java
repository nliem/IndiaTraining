package collectionsExamples;

import java.util.List;

/**
 * Donor interface. 
 * @author nliem
 *
 */
public interface IDonor {

  public boolean addDonor(Donor obj);
  public boolean[] addDonors(Donor...donors);
  public void printDonorList();
  public List<Donor> getDonorList();
  
}
