package taxi;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import interfaces.Dao;
import oracle.jdbc.OracleTypes;
import utils.MySQLConnection;

public class TaxiDao implements Dao<Taxi> {
	
	private Connection con = null;
	
	public TaxiDao(){
		super();
		this.con = MySQLConnection.getMyOracleConnection();
	}

	@Override
	public int add(Taxi entry) {
		int rowAdded = 0;
		
		if(entry == null){
			return rowAdded;
		}
		
		try{
			
			CallableStatement cstatement = con.prepareCall("{CALL ADD_TAXI(?,?,?,?,?,?)}");
			
			cstatement.setString(1, entry.getCabnumber());
			cstatement.setString(2, entry.getCabtype());
			cstatement.setString(3, entry.getDrivername());
			cstatement.setString(4, entry.getLocation());
			cstatement.setShort(5, entry.getAvailable());
			cstatement.registerOutParameter(6, java.sql.Types.NUMERIC);
			
			cstatement.execute();
			
			rowAdded = cstatement.getInt(6);
		}
		catch(SQLException exception){
			exception.printStackTrace();
		}
		
		return rowAdded;
	}

	@Override
	public int remove(String identifier) {
int rowRemoved = 0;
		
		if(identifier == null){
			return rowRemoved;
		}
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL REMOVE_TAXI(?,?)}");
			
			cstatement.setString(1, identifier);
			cstatement.registerOutParameter(2, java.sql.Types.NUMERIC);
			
			cstatement.execute();
			
			rowRemoved = cstatement.getInt(2);
		}
		catch(SQLException exception){
			exception.printStackTrace();
		}
		
		return rowRemoved;
	}

	@Override
	public Taxi findEntry(String identifier) {
		Taxi taxi = null;
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL FIND_TAXI(?,?)}");
			
			cstatement.setString(1, identifier);
			cstatement.registerOutParameter(2,OracleTypes.CURSOR);
			
			cstatement.execute();
			
			ResultSet result = (ResultSet) cstatement.getObject(2);
			
			while(result.next()){
				taxi = new Taxi(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), result.getShort(5));
				
				return taxi;
			}
		}
		catch(SQLException exception){
			exception.printStackTrace();
		}
		
		return taxi;
	}
	
	public Collection<Taxi> findLocationTaxis(String location){
		ArrayList<Taxi> taxis = new ArrayList<>();
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL FIND_LOCATION_TAXIS(?,?)}");
			
			cstatement.setString(1, location);
			cstatement.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstatement.execute();
			
			ResultSet result = (ResultSet) cstatement.getObject(2);
			
			while(result.next()){
				Taxi taxi = new Taxi(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), result.getShort(5));
				
				taxis.add(taxi);
			}
		}
		catch(SQLException exception){
			exception.printStackTrace();
		}
		
		return taxis;
	}

}
