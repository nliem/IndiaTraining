package exceptions;

/**
 * Exception thrown when an unknown donor id is provided.
 * 
 * @author natalieliem
 *
 */
public class UnknownDonorException extends Exception {

  /**
   * Constructor taking a message.
   * 
   * @param message
   *          Message summarizing exception.
   */
  public UnknownDonorException(String message) {
    super(message);
  }

  /**
   * Default constructor.
   */
  public UnknownDonorException() {
    super();
  }

}
