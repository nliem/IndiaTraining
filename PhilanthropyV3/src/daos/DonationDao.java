package daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import donation.Donation;
import exceptions.InvalidAmountException;
import interfaces.Dao;
import utilities.MySQLConnection;

public class DonationDao implements Dao<Donation>{
	
	private Connection con = null;
	
	public DonationDao(){
		super();
		this.con = MySQLConnection.getMyOracleConnection();
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
			System.out.println("Error occurred adding donation : " + item.toString());
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Donation get(int id) {
		try{
			CallableStatement cstatement = this.con.prepareCall("{CALL FIND_DONATION(?,?)}");
			
			cstatement.setInt(1, id);
			cstatement.registerOutParameter(2, java.sql.Types.REF_CURSOR);
			
			cstatement.execute();
			ResultSet result = cstatement.getArray(2).getResultSet();
			
			if(!result.first()){
				System.out.println("No donation with id " + id + " was found.");
				return null;
			}
			
			Donation donation = new Donation(result.getInt(1), result.getInt(2), result.getInt(3),result.getDouble(4));
			return donation;
		}
		catch(SQLException | InvalidAmountException e){
			System.out.println("Error calling FIND_DONATION with value " + id);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<Donation> getAll() {
		ArrayList<Donation> donationList = new ArrayList<>();
		
		try{
			CallableStatement cstatement = this.con.prepareCall("{CALL FIND_ALL_DONATIONS(?)}");
			
			cstatement.registerOutParameter(1, java.sql.Types.REF_CURSOR);
			cstatement.execute();
			ResultSet results = cstatement.getArray(1).getResultSet();
			
			while(results.next()){
				Donation donation = new Donation(results.getInt(1), results.getInt(2), results.getInt(3),results.getDouble(4));
				donationList.add(donation);
			}
		}
		catch(SQLException | InvalidAmountException e){
			System.out.println("Error calling FIND_ALL_DONATIONS.");
		}
		
		return donationList;
	}

	@Override
	public int remove(int id) {
		int result = 0;
		
		try{
			CallableStatement cstatement = this.con.prepareCall("{CALL REMOVE_DONATION(?,?)}");
			cstatement.setInt(1,id);
			cstatement.registerOutParameter(2, java.sql.Types.NUMERIC);
			cstatement.execute();
			result = cstatement.getInt(2);
		}
		catch(SQLException e){
			System.out.println("Error calling REMOVE_DONATION with id " + id);
			e.printStackTrace();
		}
		
		return result;
	}

}
