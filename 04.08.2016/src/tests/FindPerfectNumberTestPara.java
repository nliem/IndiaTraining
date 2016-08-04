package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import classes.FindPerfectNumber;

@RunWith(Parameterized.class)
public class FindPerfectNumberTestPara {
	private int numbers;
	
	public FindPerfectNumberTestPara(int numbers){
		super();
		this.numbers = numbers;
	}

	@Test
	public void testPerfectByParam() {
		FindPerfectNumber obj = new FindPerfectNumber();
		
		boolean actual = obj.checkPerfectNumber(numbers);
		assertTrue(numbers + "is not a perfect number", actual);
	}
	
	@Parameters
	public static Collection<Object> data(){
		Object[] data = new Object[]{6,28,33,-4,0};
		return Arrays.asList(data);
	}

}
