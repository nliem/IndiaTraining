package composite;

public class Client {
	
	public static void main(String[] args){
		Store s1 = new Store("A", 10);
		Store s2 = new Store("B", 20);
		Store s3 = new Store("C", 30);
		Store s4 = new Store("D", 40);
		Store s5 = new Store("E", 50);
		Store s6 = new Store("F", 60);
		
		
		City c1 = new City("Chicago", 400);
		c1.addLeaf(s1);
		c1.addLeaf(s2);
		c1.addLeaf(s3);
		
		City c2 = new City("Honolulu", 600);
		c2.addLeaf(s4);
		c2.addLeaf(s5);
		c2.addLeaf(s6);
		
		State state = new State("US", 1000);
		state.addLeaf(c1);
		state.addLeaf(c2);
		
		System.out.println("Profit of state: " + state.getProfit());
	}

}
