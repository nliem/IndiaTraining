package domain;

import utilities.MySQLConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManager {
	
	private Connection con = null;
	
	
	public UserManager(InputStream instream){
		super();
		this.con = MySQLConnection.getMyOracleConnection(instream);
		init();
	}
	
	private void init(){
		
		String create = "CREATE TABLE CREDENTIALS (USERNAME VARCHAR(30),"
				+ " PASSWORD VARCHAR(30))";
		
		String insert = "INSERT INTO CREDENTIALS VALUES('Natalie', 'Liem')";
		
		try{
			Statement statement = con.createStatement();
			statement.executeQuery(create);
			System.out.println("Table created...");
			
			PreparedStatement pStatement = con.prepareStatement(insert);
			pStatement.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public boolean validate(String username, String password){
		if(username == null) return false;
		if(password == null) return false;
		
		String query = "SELECT PASSWORD FROM CREDENTIALS WHERE USERNAME = ?";
		String pw = null;
		
		try{
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setString(1, username);
			
			ResultSet rs = pStatement.executeQuery();
			
			while(rs.next()){
				pw = rs.getString(1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return password.equals(pw);
		
	}
	
	public void shutDown(){
		
		String drop = "DROP TABLE CREDENTIALS";
		System.out.println("Table dropped...");
		
		Statement statement;
		try {
			statement = con.createStatement();
			statement.executeUpdate(drop);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

}
