package composite;

public interface Profitable {
	
	public double getProfit();
	public void addLeaf(Profitable leaf);
	public void removeLeaf(Profitable leaf);

}
