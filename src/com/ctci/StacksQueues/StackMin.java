package com.ctci.StacksQueues;
/**
 * CTCI Q3.2
 * @author daebenez
 * Program to create a stack that can push, pop and findMin in constant time.
 * Use of seperate min stack ensures that when an element is pop ed, it can still track the next min element.
 * Time Complexity : O(1)
 * Space Complexity : O(n) since we use an extr min stack.
 */

public class StackMin {
	
	private int[] stack = new int[10];
	private int[] min = new int[10];
	private int top = -1;
	private int minTop = -1;
	
	// If new element is lower than the min, push to min stack.
	public void push(int value)
	{
		if(top<stack.length)
		{
			top++;
			stack[top] = value;
			if((minTop == -1) || (min[minTop] > value))
			{
				minTop++;
				min[minTop] = value;
			}
		}
		else
		{
			System.out.println("Stack overflow !");
		}
	}
	
	//if the element being removed is the same as min remove both.
	public void pop()
	{
		if(top>-1)
		{
			
			top = top-1;
			
			if(min[minTop]==(stack[top+1]))
			{
				minTop = minTop-1;
			}
		}
	}
	
	public void getMin()
	{
		if(min.length>0)
		{
			System.out.println(min[minTop]);
		}
		
	}
	/*
	public static void main(String[] args)
	{
		StackMin obj = new StackMin();
		obj.push(6);
		obj.push(5);
		obj.push(4);
		obj.getMin();
		obj.pop();
		obj.pop();
		obj.getMin();	
	} */
}
