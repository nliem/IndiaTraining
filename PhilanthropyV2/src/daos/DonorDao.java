package daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


import donor.Donor;
import exceptions.NullValueException;
import interfaces.Dao;
import utilities.MySQLConnection;

public class DonorDao implements Dao<Donor>{
	
	private Connection con = null;
	
	public DonorDao(){
		super();
		this.con = MySQLConnection.getMyOracleConnection();
	}
	
	public DonorDao(Connection c) throws NullValueException{
		super();
		if(c == null){
			//should I also log this? TODO
			throw new NullValueException("Connection passed to Dao constructor cannot be null.");
		}
		this.con = c;
	}
	
	@Override
	public int add(Donor item) {
		int result = 0;
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL ADD_DONOR(?,?,?,?)}");
			
			cstatement.setInt(1, item.getDonorId());
			cstatement.setString(2, item.getDonorName());
			cstatement.setString(3, item.getDonorEmail());
			cstatement.registerOutParameter(4, java.sql.Types.NUMERIC);
			
			cstatement.execute();
			result = cstatement.getInt(4);
		}
		catch(SQLException e){
			//log here?
			//TODO
			System.out.println("Error occurred adding donor: " + item.toString());
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Donor get(int id) {
		String sqlSelectStatement = "SELECT * FROM DONORS WHERE DONOR_ID = ?";
		Donor donor = null;
		
		try{
			PreparedStatement pstatement = this.con.prepareStatement(sqlSelectStatement);
			pstatement.setInt(1, id);
			
			ResultSet results = pstatement.executeQuery();
			
			//Check if this line works...
			//TODO
			if(!results.first()){
				//throw an exception here?
			}
			
			donor = new Donor(results.getInt(1), results.getString(2), results.getString(3));
			return donor;
		}
		catch(SQLException e){
			//log here?
			//TODO
			System.out.println("Error occured while trying to find donor with id " + id);
			e.printStackTrace();
		}
		
		return donor;
	}

	@Override
	public Collection<Donor> getAll() {
		ArrayList<Donor> donorList = new ArrayList<>();
		String sqlSelectStatement = "SELECT * FROM DONORS";
		
		try{
			PreparedStatement pstatement = this.con.prepareStatement(sqlSelectStatement);
			ResultSet results = pstatement.executeQuery();
			
			while(results.next()){
				Donor d = new Donor(results.getInt(1), results.getString(2), results.getString(3));
				donorList.add(d);
			}
		}
		catch(SQLException e){
			//log here?
			//TODO
			System.out.println("Error occured while executing statement: " + sqlSelectStatement);
			e.printStackTrace();
		}
		
		return donorList;
	}

	@Override
	public int remove(int id) {
		int result = 0;
		
		try{
			CallableStatement cstatement = this.con.prepareCall("{CALL REMOVE_DONOR(?,?)}");
			
			cstatement.setInt(1, id);
			cstatement.registerOutParameter(2, java.sql.Types.NUMERIC);
			
			cstatement.execute();
			result = cstatement.getInt(2);
		}
		catch(SQLException e){
			//log here?
			//TODO 
			System.out.println("Error occured while trying to delete donor with id " + id);
			e.printStackTrace();
		}
		
		return result;
	}	

}
