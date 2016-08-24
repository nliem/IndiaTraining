package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MySQLConnection {
	
	public static Connection getMyOracleConnection(InputStream inStream){
		Connection con = null;
		
		try{
			Properties props = new Properties();
			
			
//			InputStream inStream=Thread.currentThread().getClass().getClassLoader().getResourceAsStream("DbConnection.properties");
			
				
			props.load(inStream);
			
			Class.forName(props.getProperty("db.driverClass"));
			
			con = DriverManager.getConnection(props.getProperty("db.driverURL"), 
				props.getProperty("db.username"), props.getProperty("db.password"));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return con;
	}

}
