package daos;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Collection;

import donation.Donation;
import exceptions.NullValueException;
import interfaces.Dao;
import utilities.MySQLConnection;

public class DonationDao implements Dao<Donation>{
	
	private Connection con = null;
	
	public DonationDao(){
		super();
		this.con = MySQLConnection.getMyOracleConnection();
	}
	
	public DonationDao(Connection c) throws NullValueException{
		super();
		if(c == null){
			//TODO should I also log this?
			throw new NullValueException("Connection passed to Dao constructor cannot be null.");
		}
		this.con = c;
	}

	@Override
	public int add(Donation item) {
		int result = 0;
		
		try{
			CallableStatement cstatement = this.con.prepareCall("{CALL ADD_DONATION(?,?,?,?,?)}");
			
			cstatement.setInt(1, item.getDonationId());
			cstatement.setInt(2, item.getDonorId());
			cstatement.setInt(3, item.getProjectId());
			cstatement.setDouble(4, item.getDonationAmount());
			cstatement.registerOutParameter(5, java.sql.Types.NUMERIC);
			
			cstatement.execute();
			result = cstatement.getInt(5);
		}
		catch(SQLException e){
			//TODO log here?
			System.out.println("Error occurred adding image: " + item.toString());
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Donation get(int id) {
		// TODO Make this a stored procedure
		return null;
	}

	@Override
	public Collection<Donation> getAll() {
		// TODO Make this a stored procedure
		return null;
	}

	@Override
	public int remove(int id) {
		int result = 0;
		
		try{
			CallableStatement cstatement = this.con.prepareCall("{CALL REMOVE_IMAGE(?,?}");
			
			cstatement.setInt(1, id);
			cstatement.registerOutParameter(2, java.sql.Types.NUMERIC);
			
			cstatement.execute();
			result = cstatement.getInt(2);
		}
		catch(SQLException e){
			//TODO log here?
			System.out.println("Error occured while trying to delete image with id " + id);
			e.printStackTrace();
		}
		
		return result;
	}

}
