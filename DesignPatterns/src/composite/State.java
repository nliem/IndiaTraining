package composite;

import java.util.ArrayList;

public class State implements Profitable{
	
	private ArrayList<Profitable> cities;
	private double profit;
	private String name;
	
	public State(String name, double profit){
		this.profit = profit;
		this.name = name;
		this.cities = new ArrayList<>();
	}

	@Override
	public double getProfit() {
		double total = profit;
		for(Profitable p : cities){
			total += p.getProfit();
		}
		return total;
	}

	@Override
	public void addLeaf(Profitable leaf) {
		if(!(leaf instanceof City)) return;
		cities.add(leaf);
		
	}

	@Override
	public void removeLeaf(Profitable leaf) {
		cities.remove(leaf);
		
	}

}
