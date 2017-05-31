package com.datastructure.trees;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Program to print all binary nodes along vertical levels in a binary tree.
 * @author daebenez
 * Time Complexity : O(N) -> modified DFS
 */

public class VerticalOrder {
	
	private HashMap<String, String> list = new HashMap<String, String>();
	
	public void verticalOrder(BinaryNode head)
	{
		verticalLevel(head, 0);
	}
	
	public void verticalLevel(BinaryNode root,int level)
	{
		if(root==null)
		{
			return;
		}
		
		if(list.get(level+"")==null)
		{
			list.put(level+"", root.getVal()+"");
		}
		else
		{
			list.put(level+"",list.get(level+"")+root.getVal());
		}
		
		int leftLevel = level + 1;
		int rightLevel = level - 1;
		verticalLevel(root.getLeft(), leftLevel);
		verticalLevel(root.getRight(), rightLevel);
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
		two.setRight(five);
		three.setLeft(six);
		three.setRight(seven);
		VerticalOrder obj = new VerticalOrder();
		obj.verticalLevel(one, 0);
		
		for (HashMap.Entry entry : obj.list.entrySet()) {
		    System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		
	} */
}
