package donor;

/**
 * Entity class representing a donor. Donors have the ability to donate to multiple projects.
 * A donor can also donate to the same project multiple times.
 * Basic information about the donor is stored and represented.
 * 
 * @author nliem
 *
 */
public class Donor {

  /**
   * Unique identifier for a donor.
   * Acts as primary key in DONORS table.
   * Assigned upon creation of the donor. 
   */
  private int donor_id;
  
  /**
   * Name of the donor.
   * Contains both first and last name.
   * Assigned upon creation of the donor.
   */
  private String donor_name;
  
  /**
   * Email address of the donor.
   * Assigned upon creation of the donor.
   */
  private String donor_email;

  /**
   * Constructor which requires all fields for the donor to be created.
   * Sets all field upon creating the donor object.
   * 
   * @param donor_id Sets the unique id of the donor object.
   * @param donor_name Sets the name of the donor.
   * @param donor_email Sets the email address of the donor.
   */
  public Donor(int donor_id, String donor_name, String donor_email){
    this.donor_id = donor_id;
    this.donor_name = donor_name;
    this.donor_email = donor_email;
  }

  public int getDonorId() {
    return this.donor_id;
  }

  public String getDonorName() {
    return this.donor_name;
  }

  public String getDonorEmail() {
    return this.donor_email;
  }

  @Override
  public String toString() {
    return "Donor #" + this.donor_id + "\t" + this.donor_name + "\t" + this.donor_email + "\n";
  }

}
