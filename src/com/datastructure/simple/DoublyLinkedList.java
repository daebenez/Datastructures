package com.datastructure.simple;
import com.datastructure.simple.LinkedListNode;

/** 
 * @author daebenez
 * Implementation of Doubly Linked List in Java.
 * Time Complexity : Insertion & Deletion : O(1), Search/find : O(n).
 * Space Complexity : O(n).
 */

public class DoublyLinkedList {
	
	LinkedListNode head,tail;
	int size;
	
	/**
	 * Get size of LinkedList
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Method to insert value at the first position (Head)
	 * @param elem
	 */
	public void insertAtStart(int elem)
	{
		LinkedListNode node = new LinkedListNode(elem);
		//If there is no elements in the list, insert at head.
		if(head == null)
		{
			head = node;
			tail = node;
		}
		else
		{
			/* set head's prev pointer to node, node's next pointer to head, 
			 * then set node as head 
			 */
			head.setPrev(node);
			node.setNext(head);
			head = node;
		}
		//increment size.
		size++;
	}
	
	/**
	 * Insert value at end of list (Tail)
	 * @param elem
	 */
	public void insertAtEnd(int elem)
	{
		LinkedListNode node = new LinkedListNode(elem);
		// If list is empty insert at head.
		if(head == null)
		{
			head = node;
			tail = node;
		}
		else
		{
		/* Set tail's next pointer to node and node's prev to tail, 
		 * then set new node as tail.
		 */
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
		}
		size++;
	}
	
	/**
	 * Insert element at any position
	 * @param elem
	 * @param pos
	 * 
	 */
	public void insertAtPos(int elem, int pos)
	{
		// Decrement position since we count from 0.
		pos--;
		LinkedListNode node = new LinkedListNode(elem);
		// If list is empty insert at head.
		if(head == null)
		{
			System.out.println("List is empty, inserting at the first position");
			head = node;
			tail = node;
		}
		else
		{
			LinkedListNode currentNode = new LinkedListNode();
			LinkedListNode temp = new LinkedListNode();
			currentNode = head;
			// Loop through the list and find position. Insert into position.
			for(int i=0;i<size;i++)
			{
				if(i == pos)
				{
					temp = currentNode.prev;
					node.prev = currentNode.prev;
					temp.next = node;
					node.next = currentNode;	
				}
				currentNode = currentNode.next;
				
			}
			size++;
		}
		
	}
	
	/**
	 * Delete element from any position
	 * @param pos
	 */
	public void delete(int pos)
	{
		LinkedListNode currentNode = new LinkedListNode();
		currentNode = head;
		LinkedListNode temp = new LinkedListNode();
		// If the position is the first element.
		if(pos == 1)
		{
			head = head.next;
			head.prev = null;
		}
		else if(pos==size)
		{
		// If position is the last element.
			tail = tail.prev;
			tail.next = null;
		}
		else
		{
			// Loop through to find the node at position and delete it.
			for(int i=1;i<size;i++)
			{
				if(pos == i)
				{
					temp = currentNode.prev;
					currentNode = currentNode.next;
					temp.next = currentNode;
					currentNode.prev = temp;
				}
				currentNode = currentNode.next;
			}
		}
		size = size - 1;
	}
	
	//display all data from linkedlist
	public void displayData()
	{
		LinkedListNode currentNode = new LinkedListNode();
		currentNode = head;
		
		for(int i=0;i<size;i++)
		{
			System.out.print(currentNode.getData());
			System.out.print(" ");
			currentNode = currentNode.next;
		}
		System.out.println("");
		
	}
	
	//Test function
	/*public static void main(String[] args)
	{
		DoublyLinkedList db = new DoublyLinkedList();
		db.insertAtStart(15);
		db.insertAtEnd(9);
		db.insertAtStart(18);
		db.insertAtPos(5, 2);
		db.displayData();
		db.delete(2);
		db.displayData();
	}*/
	
}
