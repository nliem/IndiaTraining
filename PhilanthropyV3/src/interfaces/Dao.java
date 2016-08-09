package interfaces;

import java.util.Collection;

public interface Dao <T> {
	
	public int add(T item);
	
	public T get(int id);
	
	public Collection<T> getAll();
	
	public int remove(int id);

}
