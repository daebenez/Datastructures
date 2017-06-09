package com.ctci.TreesGraphs;
/**
 * Q 4.10
 * Program to check if Binary tree T2 is a subtree of T1.
 * Use preOrder traversal, to make preOrder traversal unique print a special
 * character in place of null nodes.
 * @author daebenez
 * Time Complexity : O(n*m) -> DFS takes linear time, but checking if T1 string is a substring of T2
 * can take n*m where n and m are the number of nodes in the 2 binary tree.
 * Space Complexity : O(n+m) -> 2 strings are used to hold the values of preorder.
 */
public class CheckSubtree {
	
	private StringBuilder treeOne = new StringBuilder();
	private StringBuilder treeTwo = new StringBuilder();
	
	public boolean isSubtree(BinaryNode T1,BinaryNode T2)
	{
		preOrder(T1, treeOne);
		preOrder(T2, treeTwo);
		
		if(treeOne!=null && treeTwo!=null)
		{
			if(treeOne.indexOf(treeTwo.toString())!=-1)
			{
				System.out.println("YES T2 is a subtree of T1!!");
			}
			else
			{
				System.out.println("NO T2 is not s subtree of T1");
			}
		}
		else
		{
			System.out.println("ERROR!");
		}
		return false;
	}
	//assign preorder value of the given Binary tree to the global string
	public void preOrder(BinaryNode parent,StringBuilder preOrder)
	{
		if(parent==null)
		{
			preOrder.append("#");
			return;
		}
		
		preOrder.append(parent.getVal());
		preOrder(parent.getLeft(),preOrder);
		preOrder(parent.getRight(),preOrder);
	}
	/*
	public static void main(String[] args)
	{
		BinaryNode one = new BinaryNode(1);
		BinaryNode two = new BinaryNode(2);
		BinaryNode three = new BinaryNode(3);
		BinaryNode four = new BinaryNode(4);
		BinaryNode five = new BinaryNode(5);
		
		one.setLeft(two);
		one.setRight(three);
		three.setLeft(four);
		three.setRight(five);
		
		CheckSubtree obj = new CheckSubtree();
		StringBuilder result = new StringBuilder();
		obj.preOrder(one,result);
		
		
		obj.isSubtree(one, three);
	} */

}
