package com.ctci.ObjectOriented;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Helper class to create iterator for Circular Array datastructure
 * @author daebenez
 * @param <T>
 */
public class CircularArrayIterator<T> implements Iterator<T> {

	private int position = 0;
	private ArrayList<T> list;

	public CircularArrayIterator(ArrayList<T> list) {
		this.list = list;
	}
	
	@Override
	public boolean hasNext() {
		if(list.size()>=position+1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public T next() {
		T obj = list.get(position);
		position++;
		return obj;
	}

}
