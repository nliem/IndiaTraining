package composite;

public class Store implements Profitable {
	
	private double profit;
	private String name;
	
	public Store(String name, double profit){
		this.profit = profit;
		this.name = name;
	}

	@Override
	public double getProfit() {
		return profit;
	}

	@Override
	public void addLeaf(Profitable leaf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLeaf(Profitable leaf) {
		// TODO Auto-generated method stub
		
	}

}
