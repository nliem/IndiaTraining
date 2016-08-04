package tests;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import classes.MySQLConnection;

public class TestMySqlConnection {
	
	@Test
	public void testGetMyOracleConnection(){
		Connection con = MySQLConnection.getMyOracleConnection();
		assertNotNull("Check Connection Parameters", con);
	}

}
