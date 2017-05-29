package com.datastructure.trees;
/**
 * Program to find the maximum sum from root to any leaf node.
 * @author daebenez
 * Time Complexity : O(n)
 */
public class maxSumPath {
	
	public int findMaxPath(BinaryNode node)
	{
		if(node==null)
		{
			return 0;
		}
		
		int left = findMaxPath(node.getLeft());
		int right = findMaxPath(node.getRight());
		
		if(left > right)
		{
			return left + node.getVal();
		}
		else
		{
			
			return right + node.getVal();
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
		
		maxSumPath obj = new maxSumPath();
		
		
		System.out.println(obj.findMaxPath(one));
	} */

}
