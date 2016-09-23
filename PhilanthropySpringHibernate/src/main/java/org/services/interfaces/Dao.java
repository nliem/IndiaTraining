package org.services.interfaces;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {
	
	public Object add(T object);
	public T find(Serializable key);
	public List<T> findAll();
	
}
