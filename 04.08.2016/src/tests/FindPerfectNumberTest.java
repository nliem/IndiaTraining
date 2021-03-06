package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import classes.FindPerfectNumber;

public class FindPerfectNumberTest {
	
	private static FindPerfectNumber fpn;
	
	@BeforeClass
	public static void init(){
		fpn = new FindPerfectNumber();
	}

	@Test
	public void testPerfectNumberNegative() {
		boolean result = fpn.checkPerfectNumber(-10);
		
		assertEquals(false, result);
	}
	
	@Test
	public void testPerfectNumberIncorrect(){
		boolean result = fpn.checkPerfectNumber(7);
		
		assertEquals(false, result);
	}
	
	@Test
	public void testPerfectNumberCorrect(){
		boolean result = fpn.checkPerfectNumber(28);
		
		assertEquals(true, result);
	}
	
	@Test
	public void testPerfectNumberZero(){
		boolean result = fpn.checkPerfectNumber(0);
		
		assertEquals(false, result);
	}

}
