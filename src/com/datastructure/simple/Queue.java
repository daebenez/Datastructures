package com.datastructure.simple;

/**
 * @author daebenez
 * Linear Queue Implementation in Java using array
 * Space Complexity : O(n)
 * Time Complexity : Search/find : O(n), Enqeue : O(n), Dequeue : O(n) 
 */
public class Queue {
	
	private int[] queueArray;
	private int head,tail,queueSize;
	
	/**
	 * Constructor to initialize queue size
	 * @param size
	 */
	public Queue(int size)
	{
		head = 0;
		tail = 0;
		queueSize = size;
		queueArray = new int[queueSize];
	}
	
	/**
	 * Checks if queue is empty
	 * @return true or false
	 */
	public boolean isEmpty()
	{
		if (head == tail)
			return true;
		else
			return false;
	}
	
	/**
	 * Adds element to queue
	 * @param elem
	 */
	public void enqueue(int elem)
	{
		// check if tail is equal to array size before insertion, which means queue is full
		if(tail == (queueSize-1))
			System.out.println("Queue is full. Cannot insert element !");
		else
			queueArray[tail] = elem;
			tail++;	
			
	}
	
	/**
	 * Removes an element
	 */
	public void dequeue()
	{
		// Check if head is equal to tail before deletion, which means queue is empty
		if(isEmpty())
			System.out.println("Queue is empty, No elements to dequeue !");
		else
			for(int i=head+1;i<tail;i++)
			{
				queueArray[i-1] = queueArray[i];
			}
			queueArray[tail] = 0;
			tail = tail - 1;
	}
	
	/**
	 * Display elements in queue
	 */
	public void display()
	{
		for(int i=head;i<tail;i++)
		{
			System.out.println(i+"th element in queue is"+queueArray[i]);
		}
	}
	
	/**
	 * @return queue size
	 */
	public int queueSize()
	{
		return tail;
	}
	
	/*public static void main(String args[])
	{
		Queue testQueue = new Queue(5);
		System.out.println(testQueue.isEmpty());
		testQueue.enqueue(5);
		testQueue.enqueue(8);
		testQueue.enqueue(46);
		testQueue.dequeue();
		testQueue.display();
		System.out.println(testQueue.queueSize());
		
	}*/

}
