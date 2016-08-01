package collectionsExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DonorImpl implements IDonor{

  private List<Donor> donorList;
  
  public DonorImpl(List<Donor> donorList){
    super();
    this.donorList = donorList;
  }
  
  public DonorImpl(){
    super();
    this.donorList = new ArrayList<Donor>();
  }
  
  @Override
  public boolean addDonor(Donor obj) {
    return donorList.add(obj);
  }

  @Override
  public boolean[] addDonors(Donor... donors) {
    int size = donors.length;
    
    boolean[] result = new boolean[size];
    
    int i = 0; 
    
    for(Donor d : donors){
      result[i] = donorList.add(d);
      i++;
    }
    return result;
  }

  @Override
  public void printDonorList() {
    for(Donor d : donorList){
      System.out.println(d);
    }
  }

  @Override
  public List<Donor> getDonorList() {
    return this.donorList;
  }
  
  public void printByOrder(Comparator comparator){
    Collections.sort(donorList, comparator);
    printDonorList();
  }

}
