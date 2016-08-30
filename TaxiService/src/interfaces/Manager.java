package interfaces;

/**
 * Interface defining the behavior of manager objects.
 * Managers mediate interactions between the application and DAOs.
 * 
 * @author nliem
 *
 * @param <T> Generic type the Manager operates with.
 */
public interface Manager<T> {

  /**
   * Method for adding an entry.
   * Manager passes this value to the dao for database insertion.
   * 
   * @param newEntry New entry to be added to the DB.
   * @return Returns a boolean reflecting the success of the insertion.
   */
  public boolean add(T newEntry);

  /**
   * Method for removing an entry.
   * Manager passes this value to the dao for database deletion.
   * 
   * @param identifier Unique identifier of the element to be removed.
   * @return Returns a boolean reflecting the success of the deletion.
   */
  public boolean remove(String identifier);

  /**
   * Returns the information of the entry associated with the provided identifier.
   * The information is returned in the form of a formatted String.
   * 
   * @param identifier Unique identifier of the element.
   * @return Returns a String containing the info associated with the entry.
   */
  public String showInformation(String identifier);

  public T findEntry(String identifier);

}
