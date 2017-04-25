package com.ctci.StacksQueues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
/**
 * Q3.3
 * Program to create Set of Stacks.
 * When an element is inserted and the current stack size is full(3),
 * it creates a new stack for the element.
 * When the element to be pop ed is not in the current stack i.e it is empty,
 * element from the previous stack is pop ed.
 * Time complexity for push/pop -> O(1) Amortized?
 * @author daebenez
 */
public class SetofStacks {
	private ArrayList<Stack> sos = new ArrayList<Stack>();
	
	public boolean push(int val)
	{
		// If set of stacks is empty create a new stack.
		if((sos.isEmpty()))
		{
			Stack temp = new Stack();
			temp.push(val);
			sos.add(temp);
			return true;
		}
		else
		{
			int size = sos.size();
			//if current stack has empty spots insert.
			if(sos.get(size-1).size() < 3)
			{
				sos.get(size-1).push(val);
				return true;
			}
			else
			{
				//If current stack is full, create new stack.
				Stack temp = new Stack();
				temp.push(val);
				sos.add(temp);
				return true;
			}
		}
	}
	
	public void printAll()
	{
		for(Stack t : sos)
		{
			System.out.println(Arrays.toString(t.toArray()));
		}
	}
	
	public boolean pop()
	{
		if(sos.isEmpty())
		{
			return false;
		}
		else
		{
			// If current stack is empty.
			if(sos.get(sos.size()-1).size()==0)
			{
				sos.remove(sos.size()-1);
				if(sos.isEmpty())
				{
					return false;
				}
				else
				{
					sos.get(sos.size()-1).pop();
					return true;
				}
			}
			else
			{
				sos.get(sos.size()-1).pop();
				return true;
			}
		}
	}
	/*
	public static void main(String[] args)
	{
		SetofStacks obj = new SetofStacks();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.push(6);
		obj.push(7);
		obj.push(8);
		obj.printAll();
		obj.pop();
		obj.printAll();
		obj.pop();
		obj.printAll();
		obj.pop();
		obj.printAll();
	} */
}
