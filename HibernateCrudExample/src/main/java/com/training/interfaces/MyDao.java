package com.training.interfaces;

public interface MyDao<T> {
	
	public Object add(T object);
	public T find(Object key);

}
