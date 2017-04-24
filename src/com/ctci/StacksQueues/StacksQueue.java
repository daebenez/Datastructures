package com.ctci.StacksQueues;
import java.util.Arrays;
import java.util.Stack;

/**
 * CTCI Q3.4
 * @author daebenez
 * Program to implement Queue using two stacks.
 * When an element is dequeue-ed move the items to a new stack, pop top.
 * Time Complexity : O(n) for shifting stacks, but we do not shift unless required. 
 */

public class StacksQueue {
	private Stack one = new Stack();
	private Stack two = new Stack();
	
	public void enqueue(int val)
	{
		one.push(val);
	}
	//to remove an element, reverse them by pushing them into second stack and pop the topmost element.
	public void dequeue()
	{
		//If second stack has element, pop topmost which is the oldest element.
		if(!two.isEmpty())
		{
			System.out.println("Deleted"+two.peek());
			two.pop();
		}
		//if stack two is empty get elements from stack one, reverse and pop the top.
		else if((two.isEmpty()) && (!one.isEmpty()))
		{
			while(!one.isEmpty())
			{
				two.push(one.pop());
			}
			System.out.println("Deleted"+two.peek());
			two.pop();
		}
		//If both stacks are empty.
		else
		{
			System.out.println("Queue empty !");
		}
	}
	
	public int size()
	{
		return one.size()+two.size();
	}
	/*
	public static void main(String[] args)
	{
		StacksQueue obj = new StacksQueue();
		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(3);
		obj.enqueue(4);
		obj.dequeue();
		System.out.println(Arrays.toString(obj.one.toArray()));
		System.out.println(Arrays.toString(obj.two.toArray()));
		System.out.println(obj.size());
	}*/
}
