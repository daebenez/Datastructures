package com.ctci.LinkedLists;

/**
 * @author daebenez
 * Program to implement Floyd's cycle detection algorithm.
 * Use slow and fast runners to detect loop.
 * Reset fast runner to head and increment both by one until they meet.
 * Time Complexity : O(n)
 * Space complexity : O(1)
 *
 */
public class FloydsAlgorithm {
	public void cycleDetection(SinglyLinkedList input)
	{
		LinkedListNode slowRunner = new LinkedListNode();
		LinkedListNode fastRunner = new LinkedListNode();
		
		//Use runners to detect cycles
		slowRunner = input.getHead();
		fastRunner = slowRunner;
		
		slowRunner = slowRunner.getNext();
		fastRunner = fastRunner.getNext().getNext();
		// If both runners meet, they form a cycle.
		while(!slowRunner.equals(fastRunner))
		{
			slowRunner = slowRunner.getNext();
			fastRunner = fastRunner.getNext().getNext();
		}
		//find start of cycle
		fastRunner = input.getHead();
		//The node at which both meet is the node that starts the cycle.
		while(!slowRunner.equals(fastRunner))
		{
			slowRunner = slowRunner.getNext();
			fastRunner = fastRunner.getNext();
		}
		System.out.println(slowRunner.getData()+""+fastRunner.getData());
	}
	/*
	public static void main(String[] args)
	{
		SinglyLinkedList input = new SinglyLinkedList();
		input.insert(1);
		input.insert(2);
		input.insert(3);
		input.insert(4);
		input.insert(5);
		input.insert(6);
		input.getTail().setNext(input.getHead().getNext());
		FloydsAlgorithm fa = new FloydsAlgorithm();
		fa.cycleDetection(input);
	} */

}
