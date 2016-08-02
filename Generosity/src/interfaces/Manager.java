package interfaces;

import exceptions.UnknownIdException;

public interface Manager<T> {
	
	public void add(T newvalue);
	public void remove(int identification) throws UnknownIdException;
	public String displayInformation(int identification) throws UnknownIdException;
	public String displayAllData();

}
