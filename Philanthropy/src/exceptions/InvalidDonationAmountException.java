package exceptions;

/**
 * Exception thrown when an invalid monetary amount for a donation is provided.
 * 
 * @author natalieliem
 *
 */
public class InvalidDonationAmountException extends Exception {

  /**
   * Constructor taking a message.
   * 
   * @param message
   *          Message summarizing exception.
   */
  public InvalidDonationAmountException(String message) {
    super(message);
  }

  /**
   * Default constructor.
   */
  public InvalidDonationAmountException() {
    super();
  }

}
