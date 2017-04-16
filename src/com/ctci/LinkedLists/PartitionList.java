package com.ctci.LinkedLists;
/**
 * Program to partition a linkedlist based of a single item.
 * All numbers greater than item are on the left side, while all items lesser are on the right side.
 * Create 2 separate linked list for lesser and greater numbers then iterate through the input list 
 * filling both lists and connect the two linkedlists at the end.
 * @author daebenez
 */

public class PartitionList {
	
	public SinglyLinkedList partition(SinglyLinkedList input,int partition)
	{
		SinglyLinkedList lesser = new SinglyLinkedList();
		SinglyLinkedList greater = new SinglyLinkedList();
		LinkedListNode temp = input.getHead();
		while(!temp.equals(input.getTail()))
		{
			if(temp.getData()<partition)
			{
				lesser.insert(temp.getData());
			}
			else
			{
				greater.insert(temp.getData());
			}
			temp = temp.getNext();
		}
		//tail
		if(temp.getData()<partition)
		{
			lesser.insert(temp.getData());
		}
		else
		{
			greater.insert(temp.getData());
		}
		
		lesser.getTail().setNext(greater.getHead());
		lesser.setTail(greater.getTail());
		return lesser;
	}
	
	public static void main(String[] args)
	{
		PartitionList obj = new PartitionList();
		SinglyLinkedList input = new SinglyLinkedList();
		input.insert(1);
		input.insert(2);
		input.insert(3);
		input.insert(4);
		input.insert(5);
		input.insert(6);
		SinglyLinkedList res = obj.partition(input, 3); 
		res.printList();
		
	}

}
