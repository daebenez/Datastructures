package com.datastructure.trees;
/**
 * Program to print right most nodes in a binary tree.
 * @author daebenez
 * Time Complexity : O(n) -> because this is modified DFS
 */
public class RightView {
	
	public int currLevel = 0;
	
	public void findRight(BinaryNode parent,int level)
	{
		if(parent==null)
		{
			return;
		}
		
		if(currLevel < level)
		{
			System.out.println(parent.getVal());
			currLevel = level;
		}
		findRight(parent.getRight(),level+1);
		findRight(parent.getLeft(),level+1);
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
		BinaryNode seven = new BinaryNode(7);
		
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		four.setRight(five);
		five.setRight(six);
		//three.setLeft(seven);
		
		RightView obj = new RightView();
		obj.findRight(one, 1);
	} */

}
