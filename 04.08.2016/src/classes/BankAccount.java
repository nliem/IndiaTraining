package classes;

import java.text.DecimalFormat;

public class BankAccount {

	private int accountNumber;
	private double balance;
	private StringBuilder passBook;
	private String accountHolderName;
	
	public BankAccount(int accountNumber, String name, double startBalance) throws InvalidAmountException, InvalidAccountNumberException{
		if(accountNumber <= 0){
			throw new InvalidAccountNumberException(this.accountNumber + " is not a valid account number.");
		}
		if(startBalance < 0){
			throw new InvalidAmountException("Starting balance must be positive.");
		}
		if(name == null){
			throw new NullPointerException("Null inputted for account holder name.");
		}
		this.accountNumber = accountNumber;
		this.balance = startBalance;
		this.accountHolderName = name;
		
		this.passBook = new StringBuilder();
		passBook.append("Account #: " + accountNumber + "\t").append("Account Holder Name: " + name + "\n");
	}
	
	public Double deposit(double deposit) throws InvalidAmountException{
		DecimalFormat df = new DecimalFormat("#.00");
		if(deposit < 0){
			throw new InvalidAmountException("The value $" + df.format(deposit) + " is not valid for deposit.");
		}
		else{
			balance += deposit;
			passBook.append("Deposit:\tDeposit Amount: $" + df.format(deposit) + "\tNew Balance: $" + df.format(balance) + "\n");
			return balance;
		}
	}
	
	public Double withdraw(double withdrawal) throws InsufficientBalanceException, InvalidAmountException{
		DecimalFormat df = new DecimalFormat("#.00");
		if(withdrawal > balance){
			throw new InsufficientBalanceException("Insufficient for withdrawal of $" + df.format(withdrawal));
		}
		else if(withdrawal < 0){
			throw new InvalidAmountException("The value $" + df.format(withdrawal) + " is not valid for withdrawal");
		}
		else{
			balance -= withdrawal;
			passBook.append("Withdrawal:\tWithdrawal Amount: $" + df.format(withdrawal) + "\tNew Balance: $" + df.format(balance) + "\n");
			return balance;
		}
	}
	
	public void printPassBook(){
		System.out.println(this.passBook.toString());
	}

}
