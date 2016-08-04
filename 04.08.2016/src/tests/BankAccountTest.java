package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classes.BankAccount;
import classes.InvalidAccountNumberException;
import classes.InvalidAmountException;

public class BankAccountTest {
	
	private BankAccount ba;
	
	@Before
	public void createInstance() throws Exception{
		this.ba = new BankAccount(101, "Test Holder", 1000);
	}
	
	@Test (expected = NullPointerException.class)
	public void testBadNameConstructor() throws Exception{
		this.ba = new BankAccount(100, null, 1000);
	}
	
	@Test (expected = InvalidAmountException.class)
	public void testBadBalanceConstructor() throws Exception{
		this.ba = new BankAccount(100, "Test Holder", -500);
	}
	
	@Test (expected = InvalidAccountNumberException.class)
	public void testBadAccountNumConstructor() throws Exception{
		this.ba = new BankAccount(-2, "Test Holder", 800);
	}
	
	@Test
	public void testDepositReturnType() throws Exception{
		assertEquals(ba.deposit(500).getClass(), java.lang.Double.class);
	}
	
	@Test
	public void testWithdrawalReturnType() throws Exception{
		assertEquals(ba.withdraw(500).getClass(), java.lang.Double.class);
	}

	@Test
	public void testDepositPositive() throws Exception {
		double actual = ba.deposit(2000);
		assertEquals(3000, actual, 0);
	}
	
	@Test
	public void testDepositZero() throws Exception{
		double actual = ba.deposit(0);
		assertEquals(1000, actual, 0);
	}
	
	@Test(expected = classes.InvalidAmountException.class)
	public void testDepositNegative() throws Exception{
		double actual = ba.deposit(-1000);
	}
	
	@Test(expected = classes.InsufficientBalanceException.class)
	public void testWithdrawOverdraw() throws Exception{
		double actual = ba.withdraw(2000);
	}
	
	@Test(expected = InvalidAmountException.class)
	public void testWithdrawNegative() throws Exception{
		double actual = ba.withdraw(-500);
	}
	
	@Test
	public void testWithdrawZero() throws Exception{
		double actual = ba.withdraw(0);
		assertEquals(1000, actual, 0);
	}
	
	@Test
	public void testWithdrawLegal() throws Exception{
		double actual = ba.withdraw(500);
		assertEquals(500, actual, 0);
	}
	
	

}
