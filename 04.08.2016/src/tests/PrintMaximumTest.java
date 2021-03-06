package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import classes.PrintMaximum;

public class PrintMaximumTest {
	
	private static PrintMaximum pm;
	
	@BeforeClass
	public static void init(){
		pm = new PrintMaximum();
	}

	@Test
	public void testFindMaxNegatives() {
		int[] testArray = new int[] {-1,-2,-3};
		
		int actual = pm.findMaximum(testArray);
		
		assertEquals(-1, actual, 0);
		
	}
	
	@Test
	public void testFindMaxPositives(){
		int[] testArray = new int[] {1,2,3,6,7};
		
		int actual = pm.findMaximum(testArray);
		
		assertEquals(7, actual, 0);
	}
	
	@Test
	public void testFindMaxMixed(){
		int[] testArray = new int[] {1,2,-3,6,7, 0, -23};
		
		int actual = pm.findMaximum(testArray);
		
		assertEquals(7, actual, 0);
	}
	
	@Test
	public void testFindMaxEmpty(){
		int[] testArray = new int[] {};
		
		int actual = pm.findMaximum(testArray);
		
		assertEquals(0, actual, 0);
	}

}
