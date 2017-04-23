package com.ctci.LinkedLists;

/**
 * CTCI Q2.6
 * @author daebenez
 * Program to check if a singly linked list is a palindrome.
 * Use curr, prev, next pointer to reverse the second half of the list
 * Compare each element of the first half and reversed second half to see if they are equal.
 * Time Complexity : O(n) -> since we iterate through the list.
 * Space Complexity : O(1) -> since we use a few pointers.
 *
 */
public class Palindrome {
	
	public boolean palindrome(SinglyLinkedList input)
	{
		// true if no of elements in input is even.
		boolean eve = false;
		int count =0;
		if((input.size()%2)==0)
		{
			eve = true;
		}
		LinkedListNode prev = null, curr = null, next = null, tailTwo = null;
		curr = input.getHead();
		next = curr;
		//use fast and slow runners to find mid of the list.
		while(!next.equals(input.getTail()))
		{
			//moves once
			curr = curr.getNext();
			//moves twice.
			next = next.getNext();
			if(!next.equals(input.getTail()))
			{
				next = next.getNext();
			}
			
		}
		// Reverse list
		LinkedListNode end = new LinkedListNode(-1);
		prev = end;
		while(!curr.equals(input.getTail()))
		{
			
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
			next = next.getNext();
		}
		curr.setNext(prev);
		// Compare first and reversed second half.
		LinkedListNode pnt = null;
		pnt = curr;
		tailTwo = input.getHead();
		   while(pnt.getNext()!=null)
		{
			   System.out.println(pnt.getData()+""+tailTwo.getData());
			if(pnt.getData()!=tailTwo.getData())
			{
				count++;
			}
			pnt = pnt.getNext();
			tailTwo = tailTwo.getNext();
		}
		   
		System.out.println(count);  
		if(eve && (count > 0))
		{
			return false;
		}else if((!eve) && count > 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	/*
	public static void main(String[] args)
	{
		Palindrome obj = new Palindrome();
		SinglyLinkedList input = new SinglyLinkedList();
		input.insert(1);
		input.insert(2);
		input.insert(3);
		input.insert(4);
		input.insert(3);
		input.insert(2);
		input.insert(1);
		System.out.println(obj.palindrome(input));
		SinglyLinkedList inputTwo = new SinglyLinkedList();
		inputTwo.insert(1);
		inputTwo.insert(2);
		inputTwo.insert(2);
		inputTwo.insert(1);
		System.out.println(obj.palindrome(inputTwo));
	} */
}
