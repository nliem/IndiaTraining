package interfaces;

import exceptions.NullValueException;

public interface Manager<T> {
	
	public void add (T newValue) throws NullValueException;
	public void remove (int identification);
	public String displayInformation (int identification);
	public String displayAllData();

}
