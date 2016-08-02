package donor;

import java.util.HashMap;

/**
 * Singleton class that manages and stores Donors.
 * 
 * @author natalieliem
 *
 */
public class DonorManager {
  /**
   * Private static instance the DonorManager. Used to implement the singleton
   * design.
   */
  private static DonorManager instance;

  /**
   * Structure mapping unique id's of donors to Donor objects.
   */
  private HashMap<Integer, Donor> donorList;

  /**
   * Private constructoro only called in the getInstance method. Used to
   * implement the singleton design.
   */
  private DonorManager() {
    this.donorList = new HashMap<>();
  }

  /**
   * Returns an instance of the DonorManager which is used to call on non-static
   * class methods.
   * 
   * @return Returns the singular DonorManager instance.
   */
  public static DonorManager getInstance() {
    if (instance == null) {
      instance = new DonorManager();
    }
    return instance;
  }

  /**
   * Adds a Donor object to the manager's HashMap.
   * 
   * @param don
   *          Donor object to be added.
   */
  public void addDonor(Donor don) {
    donorList.put(don.getDonorId(), don);
  }

  /**
   * Displays all donors held by the manager.
   */
  public void displayAllDonors() {
    for (int key : donorList.keySet()) {
      Donor donator = donorList.get(key);
      System.out.println(donator);
      System.out.println();
    }
  }

  /**
   * Returns the donor associated with a given donorId.
   * 
   * @param donorId
   *          Donor id of the Donor requested.
   * @return Donor object with the provided donor id.
   */
  public Donor getDonor(int donorId) {
    return donorList.get(donorId);
  }

}
