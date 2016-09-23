package test;

public class Test {
	
	public static void test(int x){
		if(x >= 0)
			if(x == 0)
				System.out.println("1");
		else
			System.out.println("2");
		System.out.println("3");
	}
	
	public static void main(String[] args){
		test(3);
	}

}
