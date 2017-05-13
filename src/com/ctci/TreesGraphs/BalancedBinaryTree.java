package com.ctci.TreesGraphs;
/**
 * CTCI Q4.4
 * Program to check if a tree is a balanced tree.
 * Use modified DFS to calculate height of tree, but also check at each node 
 * if the left and right subtrees differ by value greater than 1, if so set
 * return value to Integer.Min_Value to show that the tree is not balanced.
 * Time Complexity -> O(N) since it is a modified DFS algorithm
 * Space Complexity -> O(H) since we need space equal to the height of the tree.
 * @author daebenez
 */
public class BalancedBinaryTree {
	
	public int checkIfBalanced(BinaryNode parent)
	{
		//base case
		if(parent==null)
		{
			return -1;
		}
		
		int leftSubtree = checkIfBalanced(parent.getLeft());
		if(leftSubtree == Integer.MIN_VALUE)
		{
			return Integer.MIN_VALUE;
		}
		int rightSubtree = checkIfBalanced(parent.getRight());
		if(rightSubtree == Integer.MIN_VALUE)
		{
			return Integer.MIN_VALUE;
		}
		//check if tree is balanced if its not set return value to min value.
		if(Math.abs(leftSubtree - rightSubtree)>1)
		{
			return Integer.MIN_VALUE;
		}
		else
		{
			return (Math.max(leftSubtree, rightSubtree)+1);
		}
		
	}
	
	public boolean isBalanced(BinaryTree tree)
	{
		int result = checkIfBalanced(tree.head);
		if(result != Integer.MIN_VALUE)
		{
			return true;
		}
		return false;
	}
	/*
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.addNode(1);
		tree.addNode(2);
		tree.addNode(3);
		tree.addNode(4);
		tree.addNode(5);
		tree.addNode(6);
		tree.addNode(7);
		tree.addNode(8);
		
		BalancedBinaryTree obj = new BalancedBinaryTree();
		System.out.println(obj.isBalanced(tree));
	}*/
}
