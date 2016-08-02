package exceptions;

/**
 * Exception thrown when an unknown product id is provided.
 * 
 * @author natalieliem
 *
 */
public class UnknownProductException extends Exception {

  /**
   * Constructor taking a message.
   * 
   * @param message
   *          Message summarizing exception.
   */
  public UnknownProductException(String message) {
    super(message);
  }

  /**
   * Default constructor.
   */
  public UnknownProductException() {
    super();
  }

}
