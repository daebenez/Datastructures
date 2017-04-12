package com.ctci.LinkedLists;
/**
 * @author daebenez
 * Program to find Kth to the last element in a singly linkedlist.
 * Use runners i.e 2 pointers that are k distance apart, increment them
 * until the 2nd pointer hits the last element in the list, the first pointer 
 * will be the kth element.
 * Time Complexity : O(n) -> since we iterate through elements of the list.
 * Space Complexity : O(1)
 * Since Java Linkedlist is just a list with no explicit access to head and tail node
 * we send those in as input to the function.
 * 
 */
import java.util.LinkedList;

public class KthElement {

	public String findElement(LinkedList<String> input,int head,int tail, int k)
	{
		int pointerOne=0, pointerTwo = 0;
		pointerOne = head;
		pointerTwo = head + (k-1);
		// Move the second pointer to the tail.
		while(pointerTwo!=tail)
		{
			pointerOne++;
			pointerTwo++;
		}
		//first element is the kth element.
		return input.get(pointerOne);
	}
	/*
	public static void main(String[] args)
	{
		KthElement obj = new KthElement();
		LinkedList<String> input = new LinkedList<String>();
		input.add("cow");
		input.add("dog");
		input.add("cat");
		input.add("human");
		input.add("whale");
		input.add("tiger");
		input.add("parrot");
		input.add("bobcat");
		System.out.println(obj.findElement(input, 0, 7, 4));
	} */
}
