package user;

public class TaxiUser implements Cloneable {

  private String email;
  private String name;
  private String password;
  private long telephone;
  private String city;

  public TaxiUser() {
    super();
  }

  /**
   * Constructor taking all fields.
   * @param email Email of the user.
   * @param name Name of the user.
   * @param password User specified password.
   * @param telephone Telephone number of the user.
   * @param city User's home city.
   */
  public TaxiUser(String email, String name, String password, 
      long telephone, String city) {
    this.email = email;
    this.name = name;
    this.password = password;
    this.telephone = telephone;
    this.city = city;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public long getTelephone() {
    return this.telephone;
  }

  public void setTelephone(long telephone) {
    this.telephone = telephone;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("----------USER INFORMATION----------").append("\n");
    sb.append("Email:\t" + this.email).append("\n");
    sb.append("Name:\t" + this.name).append("\n");
    sb.append("Password:\t" + this.password).append("\n");
    sb.append("Telephone:\t" + this.telephone).append("\n");
    sb.append("Home City:\t" + this.city).append("\n");
    sb.append("------------------------------------").append("\n");

    return sb.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (this.getClass() != other.getClass()) {
      return false;
    }
    TaxiUser that = (TaxiUser) other;
    if (!this.email.equals(that.email)) {
      return false;
    }
    if (!this.name.equals(that.name)) {
      return false;
    }
    if (!this.password.equals(that.password)) {
      return false;
    }
    if (this.telephone != that.telephone) {
      return false;
    }
    if (!this.city.equals(that.city)) {
      return false;
    }
    return true;
  }

}
