package com.ctci.LinkedLists;
import com.ctci.LinkedLists.LinkedListNode;
/**
 * Implementation of a singly linked list in Java.
 * Time Complexity : Insertion & Deletion : O(1), Search/find : O(n).
 * Space Complexity : O(n).
 * @author daebenez
 */
public class SinglyLinkedList {
	
	private LinkedListNode head = null;
	private LinkedListNode tail = null;
	
	public LinkedListNode getHead() {
		return head;
	}
	public void setHead(LinkedListNode head) {
		this.head = head;
	}
	public LinkedListNode getTail() {
		return tail;
	}
	public void setTail(LinkedListNode tail) {
		this.tail = tail;
	}
	/**
	 * Method to insert item.
	 * @param item
	 * @return
	 */
	public boolean insert(int item)
	{
		//Insert at head is list is empty.
		if(head == null)
		{
			LinkedListNode newNode = new LinkedListNode(item);
			head = newNode;
			tail = head;
		}
		else
		{
			//Insert item and move tail to the new item.
			LinkedListNode newNode = new LinkedListNode(item);
			tail.setNext(newNode);
			tail = newNode;
		}
		return true;
	}
	/**
	 * method to delete an item from linkedlist.
	 * @param item
	 * @return
	 */
	public boolean delete(int item)
	{
		//If list is empty nothing to delete.
		if(head == null)
		{
			return false;
		}
		else if(head.getData() == item)
		{
			//If item to delete is the first item.
			if(head.getNext()== null)
			{
				head.setData(-1);
			}
			else
			{
				head = head.getNext();
			}
		}
		else if(tail.getData() == item)
		{
			//If item to delete is the last item.
			LinkedListNode temp = new LinkedListNode();
			temp = head;
			while(!temp.getNext().equals(tail))
			{
				temp = temp.getNext();
			}
			tail = temp;
		}
		else
		{
			//If item to delete is inbetween.
			LinkedListNode temp = new LinkedListNode();
			temp = head;
			while(temp.getData()!=item)
			{
				temp = temp.getNext();
			}
			temp.setData(-1);
		}
		
		 return true;
		
	}
	/**
	 * Method to print all items in the linked list.
	 */
	public void printList()
	{
		if(head.getData()==-1)
		{
			System.out.println("List is empty");
			return;
		}
		LinkedListNode temp = new LinkedListNode();
		temp = head;
		while(!temp.equals(tail))
		{
			if(temp.getData()!=-1)
			{
				System.out.print(temp.getData()+"->");
			}
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	}
	
	/**
	 * Method to find the size of the linkedlist
	 * @return size of the linkedlist.
	 */
	public int size()
	{
		int len = 0;
		if((head == null) && (tail ==null))
		{
			return 0;
		}
		LinkedListNode temp = new LinkedListNode();
		temp = head;
		while(!temp.equals(tail))
		{
			if(temp.getData()!=-1)
			{
				len++;
			}
			temp = temp.getNext();
		}
		len++;
		return len;
	}
	/*
	public static void main(String[] args)
	{
		SinglyLinkedList testList = new SinglyLinkedList();
		testList.insert(1);
		testList.insert(2);
		testList.insert(3);
		testList.insert(4);
		testList.insert(5);
		testList.insert(6);
		testList.insert(7);
		testList.delete(4);
		testList.printList();
		System.out.println(testList.size());
	} */
}
