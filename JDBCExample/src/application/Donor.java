package application;

/**
 * Represents the Donors to various service projects.
 * 
 * @author nliem
 *
 */
public class Donor implements Comparable<Donor> {

  private long donorCode;
  private String donorName;
  private long mobileNumber;
  private String email;

  /**
   * @return the donorCode
   */
  public long getDonorCode() {
    return donorCode;
  }

  /**
   * @param donorCode
   *          the donorCode to set
   */
  public void setDonorCode(long donorCode) {
    this.donorCode = donorCode;
  }

  /**
   * @return the donorName
   */
  public String getDonorName() {
    return donorName;
  }

  /**
   * @param donorName
   *          the donorName to set
   */
  public void setDonorName(String donorName) {
    this.donorName = donorName;
  }

  /**
   * @return the mobileNumber
   */
  public long getMobileNumber() {
    return mobileNumber;
  }

  /**
   * @param mobileNumber
   *          the mobileNumber to set
   */
  public void setMobileNumber(long mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email
   *          the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @param donorCode
   * @param donorName
   * @param mobileNumber
   * @param email
   */
  public Donor(long donorCode, String donorName, long mobileNumber, String email) {
    super();
    this.donorCode = donorCode;
    this.donorName = donorName;
    this.mobileNumber = mobileNumber;
    this.email = email;
  }
  
  @Override 
  public String toString(){
    StringBuilder builder = new StringBuilder();
    
    builder.append(donorCode).append(":").append(donorName).append(".").append(mobileNumber).append(".").append(email);
    
    return builder.toString();
  }

  @Override
  public int compareTo(Donor o) {
    if(this.donorCode > o.donorCode){ 
      return 1;
    }
    if(this.donorCode < o.donorCode){
      return -1;
    }
    return 0;
  }
 

}