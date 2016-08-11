package composite;

import java.util.ArrayList;

public class City implements Profitable{
	
	private ArrayList<Profitable> stores;
	private double profit;
	private String name;
	
	public City(String name, double profit){
		this.profit = profit;
		this.name = name;
		this.stores = new ArrayList<>();
	}

	@Override
	public double getProfit() {
		double total = profit;
		for(Profitable p : stores){
			total += p.getProfit();
		}
		return total;
	}

	@Override
	public void addLeaf(Profitable leaf) {
		if(! (leaf instanceof Store)){
			return;
		}
		stores.add(leaf);
		
	}

	@Override
	public void removeLeaf(Profitable leaf) {
		stores.remove(leaf);
		
	}

}
