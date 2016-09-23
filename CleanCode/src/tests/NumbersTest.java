package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import singleResponsibility.Numbers;

public class NumbersTest {

	private static Numbers numbers;
	
	@BeforeClass
	public static void init(){
		numbers = new Numbers();
	}
	
	@Test
	public void testInvalidInput(){
		boolean result = numbers.isPerfect(-1);
		assertEquals(false, result);
	}
	
	@Test
	public void testZeroInput(){
		boolean result = numbers.isPerfect(0);
		assertEquals(false, result);
	}
	
	@Test
	public void testPerfectNumber(){
		boolean result = numbers.isPerfect(28);
		assertEquals(true, result);
	}
	
	@Test
	public void testImperfectNumber(){
		boolean result = numbers.isPerfect(10);
		assertEquals(false, result);
	}
}
