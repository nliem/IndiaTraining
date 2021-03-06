package application;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.MyDAO;
import utils.MySQLConnection;

public class DonorDAO implements MyDAO<Donor> {
	
	private Connection con = null;
	
	public DonorDAO(){
		super();
		this.con = MySQLConnection.getMyOracleConnection();
	}
	
	public DonorDAO(Connection con){
		super();
		this.con = con;
	}

	@Override
	public int add(Donor thingToAdd) {
		int rowAdded = 0;
		
		String sqlAdd = "insert into donors values(?,?,?,?)";
		
		try{
			PreparedStatement pstmt = this.con.prepareStatement(sqlAdd);
			pstmt.setLong(1, thingToAdd.getDonorCode());
			pstmt.setString(2, thingToAdd.getDonorName());
			pstmt.setLong(3, thingToAdd.getMobileNumber());
			pstmt.setString(4, thingToAdd.getEmail());
			
			rowAdded = pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return rowAdded;
	}

	@Override
	public int update(long id, String email) {
		int updatedRow = 0;
		
		String sqlUpdate = "UPDATE DONORS SET EMAIL = ? WHERE DONORCODE = ?";
		
		try{
			PreparedStatement pstate = this.con.prepareStatement(sqlUpdate);
			pstate.setString(1, email);
			pstate.setLong(2, id);
			updatedRow = pstate.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return updatedRow;
	}

	@Override
	public Donor find(long id) {
		String sqlFind = "SELECT * FROM DONORS WHERE DONORCODE = ?";
		
		try{
			PreparedStatement pstate = this.con.prepareStatement(sqlFind);
			pstate.setLong(1, id);
			
			ResultSet rs = pstate.executeQuery();
			
			while(rs.next()){
				Donor d = new Donor(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4));
				return d;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(long id) {
		String sqlDelete = "DELETE FROM DONORS WHERE DONORCODE = ?";
		
		int rowDeleted = 0;
		
		try{
			PreparedStatement pstate = this.con.prepareStatement(sqlDelete);
			pstate.setLong(1, id);
			
			rowDeleted = pstate.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return rowDeleted;
	}

	@Override
	public List<Donor> findAll() {
		ArrayList<Donor> donorList = new ArrayList<>();
		
		String sqlString = "SELECT * FROM DONORS";
		
		try{
			PreparedStatement pstate = this.con.prepareStatement(sqlString);
			ResultSet rs = pstate.executeQuery();
			
			while(rs.next()){
				donorList.add(new Donor(rs.getLong("donorcode"), rs.getString("donorname"), rs.getLong("handphone"), rs.getString("email")));
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return donorList;
		}
	}

	public boolean updateProcedure(long id, String newemail){
		boolean result = false;
		
		try{
			CallableStatement cs = con.prepareCall("{call updateemail(?,?,?)}");
			
			cs.setLong(1, id);
			cs.setString(2, newemail);
			cs.registerOutParameter(3, java.sql.Types.NUMERIC);
			
			cs.execute();
			System.out.println(cs.getInt(3));
			result = (cs.getInt(3) == 1);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

}
