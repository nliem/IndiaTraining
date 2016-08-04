package classes;

public class PrintMaximum {
	
	public int findMaximum(int[] args){
		if(args.length < 1) {
			return 0;
		}
		
		int max = args[0];
		
		for(int i = 0; i < args.length; i++){
			if(args[i] > max){
				max = args[i];
			}
		}
		
		return max;
	}

}
