package classes;


public class FindPerfectNumber {
	
	public boolean checkPerfectNumber(int number){
		if(number <= 0){
			return false;
		}
		
		int i = 1;
		int sum = 0;
		
		while(i <= Math.sqrt(number)){
			if(number % i == 0){
				sum += i;
				sum += (number/i);
			}
			i++;
		}
		
		return (sum/2) == number;
		
	}

}
