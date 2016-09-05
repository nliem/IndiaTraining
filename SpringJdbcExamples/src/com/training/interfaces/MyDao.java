package com.training.interfaces;

import java.util.List;

public interface MyDao<T> {
	
	public int add(T object);
	public T find(long key);
	public List<T> findAll();

}
