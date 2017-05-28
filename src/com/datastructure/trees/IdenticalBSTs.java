package com.datastructure.trees;
/**
 * Program to check if 2 binary trees are identical.
 * @author daebenez
 * Time Complexity : O(n) -> DFS simultaneously on 2 binary trees and check if each node is the same.
 */
public class IdenticalBSTs {
	
	private BinaryNode headOne = null;
	private BinaryNode headTwo = null;
	
	public boolean checkBST(BinaryNode parent, BinaryNode parentTwo)
	{
		if(parent==null && parentTwo==null)
		{
			return true;
		}
		if(parent.equals(parentTwo))
		{
			return (checkBST(parent.getLeft(), parentTwo.getLeft()) && checkBST(parent.getRight(), parentTwo.getRight()));
		}
		else
		{
			return false;
		}
		
	}
	/*
	public static void main(String[] args)
	{
		IdenticalBSTs obj = new IdenticalBSTs();
		
		BinaryNode one = new BinaryNode(1);
		BinaryNode two = new BinaryNode(2);
		BinaryNode three = new BinaryNode(3);
		BinaryNode four = new BinaryNode(4);
		BinaryNode five = new BinaryNode(5);
		BinaryNode six = new BinaryNode(6);
		
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		four.setRight(five);
		five.setRight(six);
		obj.headOne = one;
		obj.headTwo = one;
		System.out.println(obj.checkBST(obj.headOne, obj.headTwo));
		
	} */
}
