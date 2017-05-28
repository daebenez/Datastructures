package com.datastructure.trees;
/**
 * Program to print path from root node to a destination node.
 * @author daebenez
 * Time Complexity : O(n) -> Modified DFS
 */
public class PrintPath {
	
	public void findPath(BinaryNode root,BinaryNode node)
	{
		path(root,node,"");
	}
	
	public void path(BinaryNode root,BinaryNode node,String result)
	{
		if(root==null)
		{
			return;
		}
		
		result = result + root.getVal();
		if(root==node)
		{
			System.out.println(result);
		}
		path(root.getLeft(),node,result);
		path(root.getRight(),node,result);
		
	}
	/*
	public static void main(String[] args)
	{
		PrintPath obj = new PrintPath();
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
		three.setLeft(seven);
		
		obj.findPath(one,six);
	} */

}
