package interfaces;

import java.util.Collection;
public interface Dao <T> {
	
	//or should this return a boolean??? D: I have no idea
	public int add(T item);
	
	public T get(int id);
	
	public Collection<T> getAll();
	
	//once again, should this return a bool? 
	public int remove(int id);

}
