package daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import donor.Donor;
import exceptions.NullValueException;
import interfaces.Dao;
import oracle.jdbc.OracleTypes;
import utilities.MySQLConnection;

public class DonorDao implements Dao<Donor>{
	
	private Connection con = null;
	
	public DonorDao(){
		super();
		this.con = MySQLConnection.getMyOracleConnection();
	}

	@Override
	public int add(Donor item) {
		int result = 0;
		
		try{
			//ADD_DONOR(donor_id, donor_name, donor_email, donor_total, out param)
			CallableStatement cstatement = con.prepareCall("{CALL ADD_DONOR(?,?,?,?)}");
			
			cstatement.setInt(1, item.getDonorId());
			cstatement.setString(2, item.getDonorName());
			cstatement.setString(3, item.getDonorEmail());
			cstatement.registerOutParameter(4, java.sql.Types.NUMERIC);
			
			cstatement.execute();
			result = cstatement.getInt(4);
		}
		catch(SQLException e){
			System.out.println("Error calling ADD_DONOR with donor: " + item.toString());
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Donor get(int id) {
		Donor donor = null;
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL FIND_DONOR(?,?)}");
			cstatement.setInt(1, id);
			cstatement.registerOutParameter(2, OracleTypes.CURSOR);
			cstatement.execute();
			
			ResultSet results = (ResultSet) cstatement.getObject(2);
			
			while(results.next()){
				donor = new Donor(results.getInt(1), results.getString(2), results.getString(3), results.getDouble(4));
				return donor;
			}
			
			/*
			if(!results.first()){
				System.out.println("No Donor with id " + id + " was found.");
				return donor;
			}
			
			donor = new Donor(results.getInt(1), results.getString(2), results.getString(3), results.getDouble(4));
			return donor;*/
		}
		catch(SQLException | NullValueException e){
			System.out.println("Error calling FIND_DONOR with id " + id);
			e.printStackTrace();
		}
		
		return donor;
	}

	@Override
	public Collection<Donor> getAll() {
		ArrayList<Donor> donorList = new ArrayList<>();
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL FIND_ALL_DONORS(?)}");
			cstatement.registerOutParameter(1, OracleTypes.CURSOR);
			cstatement.execute();
			
			ResultSet results = (ResultSet) cstatement.getObject(1);
			while(results.next()){
				Donor donor = new Donor(results.getInt(1), results.getString(2), results.getString(3), results.getDouble(4));
				donorList.add(donor);
			}
		}
		catch(SQLException | NullValueException e){
			System.out.println("Error calling FIND_ALL_DONORS");
			e.printStackTrace();
		}
		
		return donorList;
	}

	@Override
	public int remove(int id) {
		int result = 0;
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL REMOVE_DONOR(?,?)}");
			cstatement.setInt(1, id);
			cstatement.registerOutParameter(2, java.sql.Types.NUMERIC);
			cstatement.execute();
			result = cstatement.getInt(2);
		}
		catch(SQLException e){
			System.out.println("Error calling REMOVE_DONOR with id " + id);
			e.printStackTrace();
		}
		
		return result;
	}

}
