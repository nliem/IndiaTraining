package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import classes.PrintGrades;

public class PrintGradesTest {
	
	private static PrintGrades pg;
	
	@BeforeClass
	public static void init(){
		pg = new PrintGrades();
	}

	@Test
	public void testFindResult35() {
		String result = pg.findResult(35);
		
		assertEquals("D", result);
	}
	
	@Test
	public void testFindResultBelow35(){
		String result = pg.findResult(30);
		
		assertEquals("D", result);
	}
	
	@Test
	public void testFindResultC(){
		String result = pg.findResult(45);
		
		assertEquals("C", result);
	}
	
	@Test
	public void testFindResultC2(){
		String result = pg.findResult(36);
		
		assertEquals("C", result);
	}
	
	@Test
	public void testFindResultB(){
		String result = pg.findResult(60);
		
		assertEquals("B", result);
	}

}
