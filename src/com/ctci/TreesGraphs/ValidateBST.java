package com.ctci.TreesGraphs;
/**
 * CTCI Q4.5
 * Program to check if a given Binary tree is a binary search tree.
 * Time Complexity : O(N) -> since we use modified DFS and touch every node.
 * Space Complexity : O(log N) -> we may have as many recursive calls on the stack due to tree depth
 * @author daebenez
 */
public class ValidateBST {
	
	public boolean isBST(BinaryNode parent,int min,int max)
	{
		//base case
		if(parent==null)
		{
			return true;
		}
		//check if current node is greater than min and less than max
		if(((min!=Integer.MIN_VALUE) && (parent.getVal() <= min)) || ((max!=Integer.MAX_VALUE) && (parent.getVal()>max)))
		{
			return false;
		}
		
		else if((!isBST(parent.getLeft(), min, parent.getVal())) || (!isBST(parent.getRight(), parent.getVal(), max)))
		{
			return false;
		}
		return true;
	}
	/*
	public static void main(String[] args)
	{
		ValidateBST obj = new ValidateBST();
		BinaryTree tree = new BinaryTree();
		tree.addNode(4);
		tree.addNode(2);
		tree.addNode(6);
		tree.addNode(1);
		tree.addNode(3);
		tree.addNode(5);
		tree.addNode(7);
		System.out.println(obj.isBST(tree.head,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}*/
}
