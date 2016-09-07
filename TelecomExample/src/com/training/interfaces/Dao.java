package com.training.interfaces;

import java.util.List;

public interface Dao<T> {
	
	public int add(T object);
	public T find(int key);
	public List<T> findAll();

}
