package com.datastructure.trees;
/**
 * Program to print all nodes in a Binary tree that are the only child of its parent
 * @author daebenez
 * Time Complexity : O(n) -> Modified DFS
 */
public class NodesWithoutSiblings {
	
	private String result = "";
	
	public int findNode(BinaryNode parent)
	{
		if(parent==null)
		{
			return 0;
		}
		
		int left = findNode(parent.getLeft());
		int right = findNode(parent.getRight());
		
		if(left==1 && right==0)
		{
			result = result + parent.getLeft().getVal();
		}
		if(left==0 && right==1)
		{
			result = result + parent.getRight().getVal();
		}
		
		return 1;
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
		BinaryNode eight = new BinaryNode(8);
		BinaryNode nine = new BinaryNode(9);
		
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		three.setRight(eight);
		eight.setLeft(nine);
		four.setLeft(six);
		five.setLeft(seven);
		eight.setLeft(nine);
		
		NodesWithoutSiblings obj = new NodesWithoutSiblings();
		obj.findNode(one);
		System.out.println(obj.result);
	} */

}
