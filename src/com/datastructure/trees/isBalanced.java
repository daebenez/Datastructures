package com.datastructure.trees;
/**
 * Program to check if a Binary Tree is balanced.
 * Time Complexity : O(n)
 * Space Complexity : O(h) where h is the height of the tree.
 */
import com.ctci.TreesGraphs.BalancedBinaryTree;

public class isBalanced {
	
	public int getHeight(BinaryNode parent)
	{
		if(parent==null)
		{
			return 0;
		}
		
		int left = getHeight(parent.getLeft());
		int right = getHeight(parent.getRight());
		int heightDiff = left - right;
		
		if(heightDiff > 1)
		{
			return Integer.MIN_VALUE;
		}
		else if(heightDiff <0)
		{
			return Integer.MIN_VALUE;
		}
		else
		{
			return 1+Math.max(left, right);
		}
	}
	
	  public boolean isBalancedTree(BinaryNode parent)
	{
		int sol = getHeight(parent);
		if(sol > -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*public static void main(String[] args)
	{
		isBalanced obj = new isBalanced();
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
		
		System.out.println(obj.isBalancedTree(one));
	}*/
}
