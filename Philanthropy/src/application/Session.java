package application;

/**
 * Class which records session information for each donation process.
 * 
 * @author natalieliem
 *
 */
public class Session {

  /**
   * Unique id of the donor donating.
   */
  private int donorId;

  /**
   * Unique id of the project being donated to.
   */
  private int receivingProjectId;

  /**
   * Unique id of the product being donated ot.
   */
  private int receivingProductId;

  /**
   * Amount of money being donated.
   */
  private double amount;

  /**
   * Default constructor of this class.
   */
  public Session() {
    super();
  }

  /**
   * Returns the id of the donor donating.
   * 
   * @return The donor id of the donor donating.
   */
  public int getDonorId() {
    return donorId;
  }

  /**
   * Sets the donorId of the donor donating
   * 
   * @param donorId
   *          The donor id to be set.
   */
  public void setDonorId(int donorId) {
    this.donorId = donorId;
  }

  /**
   * Returns the id of the project being donating to.
   * 
   * @return The id of the project being donated to.
   */
  public int getReceivingProjectId() {
    return receivingProjectId;
  }

  /**
   * Sets the id of the project being donated to.
   * 
   * @param receivingProjectId
   *          The id of the project being donated to.
   */
  public void setReceivingProjectId(int receivingProjectId) {
    this.receivingProjectId = receivingProjectId;
  }

  /**
   * Returns the id of the product being donating to.
   * 
   * @returnThe id of the product being donated to.
   */
  public int getReceivingProductId() {
    return receivingProductId;
  }

  /**
   * Sets the id of the product being donated to.
   * 
   * @param receivingProductId
   *          The id of the product being donated to.
   */
  public void setReceivingProductId(int receivingProductId) {
    this.receivingProductId = receivingProductId;
  }

  /**
   * Returns the amount being donated.
   * 
   * @return The amount of money being donated.
   */
  public double getAmmount() {
    return amount;
  }

  /**
   * Sets the amount of money being donated.
   * 
   * @param ammount
   *          The amount of money being donated.
   */
  public void setAmmount(double ammount) {
    this.amount = ammount;
  }

}
