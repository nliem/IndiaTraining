package donor;

import java.text.DecimalFormat;

/**
 * Class representing an individual who donates through the portal.
 * 
 * @author natalieliem
 *
 */
public class Donor {

  /**
   * Unique id of the donor.
   */
  private int donorId;

  /**
   * Name of the donor.
   */
  private String name;

  /**
   * Donor's email address.
   */
  private String email;

  /**
   * Total amount of donations the donor has made across all projects and
   * products.
   */
  private double lifetimeDonations;

  /**
   * Constructor for this class.
   * 
   * @param donorId
   *          Unique id of the donor.
   * @param name
   *          Name of the donor.
   * @param email
   *          Email address of the donor.
   */
  public Donor(int donorId, String name, String email) {
    this.donorId = donorId;
    this.name = name;
    this.email = email;
    this.lifetimeDonations = 0;
  }

  /**
   * Returns the donor's unique id.
   * 
   * @return Returns the donor's unique id.
   */
  public int getDonorId() {
    return this.donorId;
  }

  /**
   * Returns the donor's name.
   * 
   * @return Returns the donor's name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the donor's email address.
   * 
   * @return Returns the donor's email address.
   */
  public String getEmail() {
    return this.email;
  }

  @Override
  public String toString() {
    String result = "Donor # " + this.donorId + "\n";
    result += "Name:\t\t\t" + this.name + "\n";
    result += "Email:\t\t\t" + this.email + "\n";
    DecimalFormat df = new DecimalFormat("#.00");
    result += "Lifetime Donations:\t$" + df.format(this.lifetimeDonations) + "\n";
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null)
      return false;
    if (this == o)
      return true;
    if (this.getClass() != o.getClass())
      return false;
    Donor other = (Donor) o;
    if (this.donorId == other.donorId)
      return true;
    else
      return false;
  }

  /**
   * Called when an donation is processed. Adds the amount this donor donated to
   * their lifetime donations.
   * 
   * @param amount
   *          The amount the donor donated.
   */
  public void noteDonation(double amount) {
    this.lifetimeDonations += amount;
  }
}
