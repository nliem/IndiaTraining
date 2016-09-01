package booking;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import interfaces.Dao;
import oracle.jdbc.driver.OracleTypes;
import utils.MySQLConnection;

public class BookingDao implements Dao<Booking> {
	
	private Connection con = null;
	
	public BookingDao(){
		super();
		this.con = MySQLConnection.getMyOracleConnection();
	}

	@Override
	public int add(Booking entry) {
		int rowAdded = 0;
		
		if(entry == null){
			return rowAdded;
		}
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL ADD_BOOKING(?,?,?,?,?,?,?,?,?,?,?)}");
			
			cstatement.setString(1, entry.getId());
			cstatement.setString(2, entry.getCustomeremail());
			cstatement.setString(3, entry.getCabnumber());
			cstatement.setString(4, entry.getVehiclename());
			cstatement.setString(5, entry.getPickup());
			cstatement.setString(6, entry.getDropoff());
			cstatement.setString(7, entry.getChargetype());
			cstatement.setDouble(8, entry.getFare());
			cstatement.setTimestamp(9, entry.getTripdate());
			cstatement.setString(10, entry.getStatus());
			cstatement.registerOutParameter(11, java.sql.Types.NUMERIC);
			
			cstatement.execute();
			
			rowAdded = cstatement.getInt(11);
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
			CallableStatement cstatement = con.prepareCall("{CALL REMOVE_BOOKING(?,?)}");
			
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
	public Booking findEntry(String identifier) {
		Booking booking = null;
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL FIND_BOOKING(?,?)}");
			
			cstatement.setString(1, identifier);
			cstatement.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstatement.execute();
			ResultSet result = (ResultSet) cstatement.getObject(2);
			
			while(result.next()){
				booking = new Booking(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), result.getString(6), result.getString(7),
						result.getDouble(8), result.getTimestamp(9), result.getString(10));
				
				return booking;
			}
		}
		catch(SQLException exception){
			exception.printStackTrace();
		}
		
		return booking;
	}
	
	public Collection<Booking> findUserBookings(String customeremail){
		ArrayList<Booking> bookings = new ArrayList<>();
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL FIND_USER_BOOKINGS(?,?)}");
			
			cstatement.setString(1, customeremail);
			cstatement.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstatement.execute();
			
			ResultSet result = (ResultSet)cstatement.getObject(2);
			
			while(result.next()){
				Booking booking = new Booking(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), result.getString(6), result.getString(7),
						result.getDouble(8), result.getTimestamp(9), result.getString(10));
				
				bookings.add(booking);
			}
		}
		catch(SQLException exception){
			exception.printStackTrace();
		}
		
		return bookings;
	}

}
