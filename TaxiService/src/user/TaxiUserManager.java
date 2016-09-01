package user;

import interfaces.Manager;
import org.apache.log4j.Logger;
import utils.GlobalLogger;

public class TaxiUserManager implements Manager<TaxiUser> {

  private static TaxiUserManager instance;
  private TaxiUserDao dao;
  private Logger log = GlobalLogger.getLogger();
 
  private TaxiUserManager() {
    this.dao = new TaxiUserDao();
  }

  /**
   * Method for returning an instance of the TaxiUserManager.
   * Enforces the existence of only one TaxiUserManager instance.
   * 
   * @return Returns the single instance of TaxiUserManager
   */
  public static TaxiUserManager getInstance() {
    if (instance == null) {
      instance = new TaxiUserManager();
    }
    return instance;
  }

  @Override
  public boolean add(TaxiUser newEntry) {
    if (newEntry == null) {
      log.warn("TaxiUserManager.add() was passed a null value to add.");
      return false;
    }

    int rowAdded = dao.add(newEntry);

    switch (rowAdded) {
      case 1:
        log.info("The TaxiUser entry was added.");
        return true;
      case 0:
        log.info("The TaxiUser entry was not added.");
        return false;
      default:
        log.fatal("ERROR! TaxiUserManager.add(" + newEntry + ").");
        return false;
    }

  }

  @Override
  public boolean remove(String identifier) {
    if (identifier == null) {
      log.warn("TaxiUserManager.remove() was given a null identifier value.");
      return false;
    }

    int rowRemoved = dao.remove(identifier);

    switch (rowRemoved) {
      case 1:
        log.info("The TaxiUser entry was removed.");
        return true;
      case 0:
        log.info("The TaxiUser entry was not removed.");
        return false;
      default:
        log.fatal("ERROR! TaxiUserManager.remove(" + identifier + ")");
        return false;
    }

  }

  @Override
  public String showInformation(String identifier) {
    if (identifier == null) {
      log.warn("TaxiUserManager.showInformation() was given a null identifier value.");
      return null;
    }

    TaxiUser user = dao.findEntry(identifier);

    if (user == null) {
      return null;
    }

    return user.toString();

  }

  @Override
  public TaxiUser findEntry(String identifier) {
    if (identifier == null) {
      log.warn("TaxiUserManager.findEntry() was given a null identifier value.");
      return null;
    }

    TaxiUser user = dao.findEntry(identifier);

    return user;
  }

  /**
   * Method for validating a user's credentials.
   * Returns a boolean indicating whether or not the user
   * credentials are valid.
   * 
   * @param email Email address entered by the user.
   * @param password Password entered by the user.
   * @return Returns true if the email and password are valid.
   */
  public boolean validateUser(TaxiUser user) {
	if (user == null) {
	  log.warn("The user passed into validateUser is null...");
      return false;
	}
    if (user.getEmail() == null || user.getPassword() == null) {
      log.warn("TaxiUserManager.validateUser() was given a null email or password value.");
      return false;
    }

    String storedPassword = dao.getUserPassword(user.getEmail());

    boolean valid = user.getPassword().equals(storedPassword);

    log.info("Validating user with credentials (" + user.getEmail() + "|" + user.getPassword() + ")");

    log.info(valid ? "Credentials valid." : "Credentials invalid.");

    return valid;
  }

}
