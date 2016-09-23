package singleResponsibility;

import java.util.ArrayList;

public class Numbers {
	
	private ArrayList<Integer> factors;
	
	public Numbers(){
		super();
	}
	
	protected boolean isValidInput(int number){
		if(number <= 0) return false;
		
		return true;
	}
	
	protected void findFactors(int number){
		factors = new ArrayList<>();
		
		int i = 1;
		
		while(i <= Math.sqrt(number)){
			if(number % i == 0){
				factors.add(i);
				factors.add(number/i);
			}
			i++;
		}
		
	}
	
	protected int sumFactors(){
		int sum = 0;
		
		for(int i : factors){
			sum += i;
		}
		
		return sum;
	}
	
	public boolean isPerfect(int number){
		if(isValidInput(number)){
			findFactors(number);
			
			int sum = sumFactors();
			
			System.out.println("Number: " + number + "\tFactors: " + factors + "\tSum: " + (sum-number));
			
			return (sum - number) == number;
		}
		
		return false;
	}

}
