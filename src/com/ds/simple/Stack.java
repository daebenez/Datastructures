package com.ds.simple;

/**
 * @author daebenez
 * Stack Implementation in Java using arrays
 */

public class Stack {
	
	private int[] stackArray;
	private int top;
	int stackSize;
	
	/**
	 * Constructor, initializes size
	 * @param stackSize
	 */
	public Stack(int size)
	{
		top = -1;
		stackSize = size;
		stackArray = new int[stackSize];
	}
	
	
	/**
	 * Method to check if stack is empty
	 * @param stackArray
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		if (top == -1)
			return true;
		else
			return false;
					
	}
	
	
	/**
	 * Insert an element into stack
	 * @param stackArray
	 * @param elem
	 */
	public void push(int elem)
	{
		//check for overflow, then insert
		if(top == stackSize-1)
			System.out.println("Stack overflow, cannot insert element");
		else
			top++;
			stackArray[top] = elem;
			System.out.println("Item inserted at position"+ top);
		
	}
	
	
	/**
	 * Remove an element from stack
	 * @param stackArray
	 */
	public void pop()
	{
		if(isEmpty())
			System.out.println("Stack Underflow, No element to delete !");
		else
			top = top - 1;
			System.out.println("Element popped is->"+stackArray[top+1]);	
	}
	
	/**
	 * Display contents of the stack
	 */
	public void displayStack()
	{
		if(isEmpty())
			System.out.println("Stack is empty");
		else
			for(int i=0;i<=top;i++)
			{
				System.out.println(i+"th Element in the stack is ->"+stackArray[i]);
			}
	}
	
	
	/*public static void main(String[] args)
	{
		Stack testStack = new Stack(15);
		System.out.println(testStack.isEmpty());
		testStack.push(5);
		testStack.push(45);
		testStack.push(80);
		testStack.pop();
		testStack.displayStack();
		
	}*/
	
}


