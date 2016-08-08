package interfaces;

public interface Manager<T> {
	
	public void add (T newValue);
	public void remove (int identification);
	public String displayInformation (int identification);
	public String displayAllData();

}
