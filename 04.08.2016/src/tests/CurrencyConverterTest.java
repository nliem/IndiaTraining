package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import classes.CurrencyConverter;

public class CurrencyConverterTest {
	
	private static CurrencyConverter conv;
	
	@BeforeClass
	public static void setUp(){
		conv = new CurrencyConverter();
	}

	@Test
	public void testUsdToINR() {
		
		double actual = conv.usdToINR(100); //actual value coming out of the method
		
		assertEquals(6000.00, actual, 0.0);
		
	}
	
	@Test
	public void testUsdToINRForNegativeValue() {
		
		double actual = conv.usdToINR(-100); 
		
		assertEquals(6000.00, actual, 0.0);
		
	}


}
