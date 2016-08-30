package user;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleTypes;
import utils.MySQLConnection;
import interfaces.Dao;

public class TaxiServiceDao implements Dao<TaxiUser> {

  private Connection con = null;

  public TaxiServiceDao() {
    super();
    this.con = MySQLConnection.getMyOracleConnection();
  }

  @Override
  public int add(TaxiUser entry) {
    int rowAdded = 0;

    if (entry == null) {
      return rowAdded;
    }

    try {

      CallableStatement cstatement = con.prepareCall("{CALL ADD_TAXIUSER(?,?,?,?,?,?)}");

      cstatement.setString(1, entry.getEmail());
      cstatement.setString(2, entry.getName());
      cstatement.setString(3, entry.getPassword());
      cstatement.setLong(4, entry.getTelephone());
      cstatement.setString(5, entry.getCity());
      cstatement.registerOutParameter(6, java.sql.Types.NUMERIC);

      cstatement.execute();

      rowAdded = cstatement.getInt(6);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }

    return rowAdded;
  }

  @Override
  public int remove(String identifier) {
    int rowRemoved = 0;

    try {
      CallableStatement cstatement = con.prepareCall("{CALL REMOVE_TAXIUSER(?,?)}");

      cstatement.setString(1, identifier);
      cstatement.registerOutParameter(2, java.sql.Types.NUMERIC);

      cstatement.execute();

      rowRemoved = cstatement.getInt(2);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }

    return rowRemoved;
  }

  @Override
  public TaxiUser findEntry(String identifier) {
    TaxiUser user = null;

    try {
      CallableStatement cstatement = con.prepareCall("{CALL FIND_TAXIUSER(?,?)}");

      cstatement.setString(1, identifier);
      cstatement.registerOutParameter(2, OracleTypes.CURSOR);

      cstatement.execute();
      ResultSet result = (ResultSet) cstatement.getObject(2);

      while (result.next()) {
        //email, name, password, telephone, city
        user = new TaxiUser(result.getString(1), result.getString(2), result.getString(3),
          result.getLong(4), result.getString(5));
        return user;
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    
    return user;
  }

  /**
   * Method for retrieving the password associated with a given user.
   * The method uses the passed in identifier to locate the user and 
   * returns their password.
   * 
   * @param identifier Unique identifier of user whose password must be retrieved.
   * @return The password associated with the user or null if the user doesn't exist.
   */
  public String getUserPassword(String identifier) {

    String password = null;

    try {
      final CallableStatement cstatement = con.prepareCall("{CALL VALIDATE_USER(?,?)}");

      cstatement.setString(1, identifier);
      cstatement.registerOutParameter(2, java.sql.Types.VARCHAR);

      cstatement.execute();

      password = cstatement.getString(2);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    
    return password;
  }

}
