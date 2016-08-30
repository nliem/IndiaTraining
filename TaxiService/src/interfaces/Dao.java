package interfaces;


/**
 * Interface defining behavior for Data Access Objects.
 * 
 * @author nliem
 *
 * @param <T> Generic type the Dao operates with.
 */
public interface Dao<T> {

  /**
   * Method for adding an entry into the database table. Returns the number of rows added.
   * The returned value should be 1 on success.
   * 
   * @param entry The new entry Object to be inserted into the database table.
   * @return Integer reflecting the number of rows inserted into the table.
   */
  public int add(T entry);

  /**
   * Method for removing an entry from the database table. Returns the number of rows removed.
   * The returned value should be 1 on success.
   * 
   * @param identifier The unique identifier of the entry to be removed from the database table.
   * @return Integer reflecting the number of rows removed from the table.
   */
  public int remove(String identifier);

  /**
   * Method for finding an entry in the database table. 
   * Returns an instance of the table's entity class equivalent.
   * Will return null if the identifier is null 
   * or if the identifier doesn't correspond to an entry in the table.
   * 
   * @param identifier The unique identifier of the entry.
   * @return Instance of the entity type of the table. 
   */
  public T findEntry(String identifier);

}
