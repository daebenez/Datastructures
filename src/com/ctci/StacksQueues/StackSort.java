package com.ctci.StacksQueues;
import java.util.Arrays;
import java.util.Stack;
/**
 * CTCI Q3.5
 * @author daebenez
 * Program to sort a list of items in a stack with help of an additional stack.
 * Use the additional stack to store sorted items, when required use first stack
 * as additional storage.
 * Time Complexity : O(N^2) because in worst case where every element in the first
 * stack is always greater than every element in the second stack, requiring the 
 * moving of all elements to the first stack and back.
 * Space Complexity : O(N) -> because of the extra stack.
 *
 */
public class StackSort {
	
	public Stack sort(Stack input)
	{
		Stack secondary = new Stack();
		// Use secondary stack to store sorted elements.
		while(!input.isEmpty())
		{
			// If stack 2 is empty. Insert.
			if(secondary.isEmpty())
			{
				secondary.push(input.pop());
			}
			else
			{
				//Element in stack 2 is greater than element at stack 1. insert
				if((int)input.peek() < (int)secondary.peek())
				{
					secondary.push(input.pop());
				}
				else
				{
					// If not remove elements in stack two until element in stack one can be reinserted.
					int temp = (int)input.pop();
					int count = 0;
					while((!secondary.isEmpty()) && (temp > (int)secondary.peek()))
					{
						input.push(secondary.pop());
						count++;
					}
					secondary.push(temp);
					while(count>0)
					{
						secondary.push(input.pop());
						count = count - 1;
					}
				}
			}
		}
		return secondary;
	}
	/*
	public static void main(String[] args)
	{
		StackSort obj = new StackSort();
		Stack input = new Stack();
		input.push(1);
		input.push(4);
		input.push(2);
		input.push(3);
		System.out.println(Arrays.toString(obj.sort(input).toArray()));
	} */

}
