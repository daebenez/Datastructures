package com.ctci.StacksQueues;
/**
 * CTCI Q3.1
 * @author daebenez
 * Program to create 3 stacks using a single array.
 * Divide the array by 3 and create 3 stacks. 
 * 2 stacks grow inward, while the middle stack can grow either way.
 * Time Complexity : Insert O(1)
 *
 */
public class NStacks {
	private int[] stack = null;
	private int topOne = 0;
	private int topTwo = 0;
	private int topThree = 0;
	private int size = 0;
	
	public NStacks(int size)
	{
		stack = new int[size];
		topOne = -1;
		topTwo = size/3;
		topThree = size;
		this.size = size;
	}
	//Grows right
	public void insertStackOne(int item)
	{
		if((topOne+1)==size/3)
		{
			System.out.println("Stack Overflow !");
			return;
		}
		topOne++;
		stack[topOne] = item;
	}
	// Grows right
	public void insertStackTwo(int item)
	{
		if((topTwo+1)==topThree)
		{
			System.out.println("Stack Overflow !");
			return;
		}
		topTwo++;
		stack[topTwo] = item;
	}
	//Grows leftward
	public void insertStackThree(int item)
	{
		if((topThree-1)==topTwo)
		{
			System.out.println("Stack Overflow !");
			return;
		}
		topThree = topThree-1;
		stack[topThree] = item;
	}
	/*
	public static void main(String[] args)
	{
		NStacks obj = new NStacks(8);
		obj.insertStackOne(11);
		obj.insertStackOne(12);
		obj.insertStackThree(31);
		obj.insertStackThree(32);
		obj.insertStackThree(33);
		obj.insertStackThree(34);
		obj.insertStackTwo(21);	
		obj.insertStackTwo(22);
	}*/
}
