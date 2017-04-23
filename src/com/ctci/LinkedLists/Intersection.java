package com.ctci.LinkedLists;
/**
 * Q2.7
 * @author daebenez
 * Program to find intersection in two singly linked list.
 * If both lists have the same node they intersect.
 * 2 find intersection first move the pointer in the longer list by
 * k nodes where k is the difference between the sizes of 2 lists.
 * Then iterate through looking for similar nodes.
 * Time Complexity : O(n) -> we iterate through the list multiple times.
 * Space Complexity : O(1) 
 */
public class Intersection {
	
	public void findIntersection(SinglyLinkedList listOne,SinglyLinkedList listTwo)
	{
		int diff = 0,count=0;
		LinkedListNode runOne = null;
		LinkedListNode runTwo = null;
		//Find if lists have intersection, intersecting lists have the same tail node.
		runOne = listOne.getHead();
		while(runOne.getNext()!=null)
		{
			runOne = runOne.getNext();
		}
		runTwo = listTwo.getHead();
		while(runTwo.getNext()!=null)
		{
			runTwo = runTwo.getNext();
		}
		
		if(runOne.equals(runTwo))
		{
			System.out.println("Intersects !");
		}
		//find intersecting node.
		LinkedListNode tempOne = listOne.getHead(),tempTwo = listTwo.getHead();
		// Use the difference in size to move the pointer to the longer linked list forward.
		if(listOne.size() > listTwo.size())
		{
			diff = listOne.size() - listTwo.size();
			for(int i=0;i<diff;i++)
			{
				tempOne = tempOne.getNext();
			}
		}
		else
		{
			diff = listTwo.size() - listOne.size();
			for(int i=0;i<diff;i++)
			{
				tempTwo = tempTwo.getNext();
			}
		}
		
		while(tempOne.getNext()!=null)
		{
			if(tempOne.equals(tempTwo))
			{
				System.out.println(tempOne.getData());
				return;
			}
			tempOne = tempOne.getNext();
			tempTwo = tempTwo.getNext();
		}
	}
	/*
	public static void main(String[] args)
	{
		
		SinglyLinkedList one = new SinglyLinkedList();
		SinglyLinkedList two = new SinglyLinkedList();
		SinglyLinkedList half = new SinglyLinkedList();
		
		one.insert(11);
		one.insert(12);
		one.insert(13);
		one.insert(14);
		one.insert(15);
		two.insert(21);
		two.insert(22);
		two.insert(23);
		half.insert(31);
		half.insert(32);
		half.insert(33);
		half.insert(34);
		half.insert(35);
		
		one.getTail().setNext(half.getHead());
		two.getTail().setNext(half.getHead());
		
		Intersection obj = new Intersection();
		obj.findIntersection(one, two);
	} */
}
