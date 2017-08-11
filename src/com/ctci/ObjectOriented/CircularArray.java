package com.ctci.ObjectOriented;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * CTCI Q 7.9
 * Design a circular Array data structure. Include a method to rotate the circular array structure.
 * Implement generics to store class instance.
 * Make the data structure iterable. 
 * @author daebenez
 */
public class CircularArray<T> implements Iterable<T> {
	
	private ArrayList<T> array = new ArrayList<T>();
	private final int MAX_LIMIT = 5;
	private int head = 0;
	
	public boolean rotate(int steps)
	{
		if(steps<MAX_LIMIT)
		{
			head+= steps;
		}
		else
		{
			steps = steps % MAX_LIMIT;
			head += steps;
		}
		return true;
	}
	
	public boolean add(T element,int index)
	{
		index = index + head;
		index = index % MAX_LIMIT;
		if(index<array.size())
		{
			array.remove(index);
		}
		array.add(index,element);
		return true;
	}
	
	public T get(int index)
	{
		index = index % MAX_LIMIT;
		return array.get(index);
	}
	
	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator<T>(array);
	}
}
