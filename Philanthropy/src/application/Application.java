package application;


/**
 * Class with entry main method. 
 * @author natalieliem
 *
 */
public class Application {
 
  /**
   * Main method. Starts the Portal.
   * @param args String arguments 
   */
  public static void main(String[] args){
	
    DataGenerator.setUp();
    
    System.out.println("Welcome to the Philanthropy Portal.");
    Portal.displayMenuOptions();
    
    
  }

}
