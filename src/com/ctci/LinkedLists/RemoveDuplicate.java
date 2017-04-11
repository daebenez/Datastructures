package com.ctci.LinkedLists;
/**
 * @author daebenez
 * Program to remove duplicates from an unsorted linkedlist.
 * Use a Hash Set to track duplicates and remove it.
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * If asked to remove duplicates without using a buffer and without sorting,
 * use 2 pointers, with one pointer to track items and the other pointer to check for duplicates.
 * 
 */
import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDuplicate {
	
	public LinkedList<String> removeDups(LinkedList<String> input)
	{
		HashSet<String> buffer = new HashSet<String>();
		for(int i=0;i<input.size();i++)
		{
			// If item is not in the buffer add it to the buffer otherwise delete it as its a duplicate.
			if(!buffer.contains(input.get(i)))
			{
				buffer.add(input.get(i));
			}
			else
			{
				//decrement index after remove because the size decreases in a linkedlist.
				input.remove(i);
				i = i - 1;
			}
		}
		return input;
	}
	
	/*
	public static void main(String[] args)
	{
		RemoveDuplicate rdups = new RemoveDuplicate();
		LinkedList<String> input = new LinkedList<String>();
		input.add("cow");
		input.add("dog");
		input.add("cat");
		input.add("wolf");
		input.add("cow");
		input.add("wolf");
		input.add("cat");
		input.add("wolf");
		System.out.println(rdups.removeDups(input).toString());
	} */
}
