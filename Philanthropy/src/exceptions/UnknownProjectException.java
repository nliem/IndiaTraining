package exceptions;

/**
 * Exception thrown when an unknown project id is provided.
 * 
 * @author natalieliem
 *
 */
public class UnknownProjectException extends Exception {
  /**
   * Constructor taking a message.
   * 
   * @param message
   *          Message summarizing exception.
   */
  public UnknownProjectException(String message) {
    super(message);
  }

  /**
   * Default constructor.
   */
  public UnknownProjectException() {
    super();
  }

}
