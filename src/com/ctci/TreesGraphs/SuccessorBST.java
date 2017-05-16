package com.ctci.TreesGraphs;
/**
 * CTCI Q4.6
 * Program to find succesor of a node in a Binary Search tree.
 * Assume each node knows its parent.
 * @author daebenez
 * Time complexity : O(n) -> we use while loops to traverse through the tree.
 * Space complexity : O(1) -> No extra memory is used.
 */
public class SuccessorBST {
	
	BinaryNodeBackEdge treeHead = null;
	/**
	 * 
	 * @param parent -  The node for which succesor will be found.
	 * @return - The succesor.
	 */
	public BinaryNodeBackEdge findSuccessor(BinaryNodeBackEdge parent)
	{
		if(parent==null)
		{
			return null;
		}
		
		// If the node has a right subtree, return the leftmost child of the subtree.
		if(parent.getRight()!=null)
		{
			//find and return the leftmost node from right subtree.
			BinaryNodeBackEdge temp = parent.getRight();
			while(temp.getLeft()!=null)
			{
				temp = temp.getLeft();
			}
			return temp;
		}else
		{
			// If the node does not have a right child return the node that is the parent of the subtree whose rightmost child the current node is.
			BinaryNodeBackEdge currNode = parent;
			BinaryNodeBackEdge ancestor = currNode.getParent();
			// loop until parent is not null and child is not right node of the parent.
			while(ancestor!=null && currNode!=ancestor.getLeft())
			{
				currNode = ancestor;
				ancestor = currNode.getParent();
			}
			return ancestor;
		}
	}
	

	/*
	public static void main(String[] args)
	{
		SuccessorBST obj = new SuccessorBST();
		
		BinaryNodeBackEdge one = new BinaryNodeBackEdge(1);
		BinaryNodeBackEdge two = new BinaryNodeBackEdge(2);
		BinaryNodeBackEdge three = new BinaryNodeBackEdge(3);
		BinaryNodeBackEdge four = new BinaryNodeBackEdge(4);
		BinaryNodeBackEdge five = new BinaryNodeBackEdge(5);
		BinaryNodeBackEdge six = new BinaryNodeBackEdge(6);
		BinaryNodeBackEdge seven = new BinaryNodeBackEdge(7);
		
		four.setLeft(two);
		two.setParent(four);
		four.setRight(six);
		six.setParent(four);
		two.setLeft(one);
		one.setParent(two);
		two.setRight(three);
		three.setParent(two);
		six.setLeft(five);
		five.setParent(six);
		six.setRight(seven);
		seven.setParent(six);
		obj.treeHead = four;
		
		System.out.println(obj.findSuccessor(five).getVal());
	} */

}
