package com.datastructure.trees;
/**
 * Program to calculate Max Height of a binary tree.
 * Time Complexity : O(n) -> small modification of DFS
 * @author daebenez
 */
public class MaxHeight {
	
	private BinaryNode head = null;
	
	public int maxHeight(BinaryNode parent)
	{
		if(parent==null)
		{
			return 0;
		}
		
		int left = maxHeight(parent.getLeft());
		int right = maxHeight(parent.getRight());
		
		if(left < right)
		{
			return right+1;
		}
		else
		{
			return left+1;
		}
	}
	
	/*
	public static void main(String[] args)
	{
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
		
		MaxHeight obj = new MaxHeight();
		obj.head = one;
		
		System.out.println("Max Height ->"+obj.maxHeight(obj.head));
	} */

}
