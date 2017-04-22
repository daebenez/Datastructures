package com.ctci.LinkedLists;
import com.ctci.LinkedLists.*;
/**
 * Program to add 2 integers using 2 linked lists. The most significant digit is in the head'
 * least significant in the tail.
 * Use recursion to reverse the order. Use an object to return both sum and carry.
 * When inserting into linked list insert into head so that the solution is in the correct order.
 * Draft version needs improvement. (solution is not in list form and is in reverse order)
 * @author daebenez
 */

public class Listaddition {
	
	public SumCarryObj addition(SinglyLinkedList l1,SinglyLinkedList l2,LinkedListNode p1,LinkedListNode p2,SinglyLinkedList res)
	{	
		if(p1.equals(l1.getTail()))
		{
			int car=0;
			int sum = p1.getData() + p2.getData();
			if(sum > 9)
			{
				car = 1;
			}
			//System.out.println(sum % 10+"-");
			res.insert(sum % 10);
			SumCarryObj objOne = new SumCarryObj();
			objOne.setSum(sum);
			objOne.setCarry(car);
			return objOne;
		}
			
		SumCarryObj carry = addition(l1,l2,p1.getNext(),p2.getNext(),res);
		int sol = p1.getData() + p2.getData() + carry.getCarry();
		SumCarryObj car = new SumCarryObj();
		car.setSum(sol);
		if(sol > 9)
		{
			car.setCarry(1);
		}
		//System.out.println(sol % 10+"-");
		if(p1.equals(l1.getHead()))
		{
			res.insert(sol);
		}
		else
		{
			res.insert(sol % 10);
		}
		res.printList();
		return car;
	}
	/*
	public static void main(String[] args)
	{
		Listaddition obj = new Listaddition();
		SinglyLinkedList input = new SinglyLinkedList();
		input.insert(7);
		input.insert(1);
		input.insert(6);
		SinglyLinkedList input2 = new SinglyLinkedList();
		input2.insert(5);
		input2.insert(9);
		input2.insert(2);
		SinglyLinkedList res = new SinglyLinkedList();
		SinglyLinkedList out = new SinglyLinkedList();
	    obj.addition(input, input2, input.getHead(), input2.getHead(), res);
	} */

}
