package interfaces;

import java.util.List;

public interface MyDAO<T> {
	
	public int add(T thingToAdd);
	public int update(long id, String email);
	public T find(long id);
	public int delete(long id);
	public List<T> findAll();

}
