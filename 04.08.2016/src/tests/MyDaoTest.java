package tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import classes.MyDoaImpl;

import org.junit.Test;

public class MyDaoTest {

	@Test(expected = java.lang.NullPointerException.class)
	public void testConstructorThrowsException() {
		Connection con = null;
		
		MyDoaImpl mdi = new MyDoaImpl(con);
	}

}
