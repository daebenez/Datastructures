package com.ctci.TreesGraphs;
/**
 * CTCI Q 4.8
 * Program to find Least Common Ancestor
 * Time Complexity : O(n) -> Since it uses a modified depth first search
 * Space Complexity : O(log n) -> Uses the recursive stack.
 * Use DFS return null, or if one of the nodes is found in either its left or right subtrees return the node, or if both nodes are found return the node as ancestor.
 * This implementation does not handle the case where both destination nodes are found in the the rightmost subtree one below the other and the ancestor is their immediate parent.
 * @author daebenez
 *
 */
public class LeastCommonAncestor {
	
	private BinaryNode treeHead = null;
	
	public String FindAncestor(BinaryNode node, BinaryNode one, BinaryNode two)
	{
		// base case
		if(node == null)
		{
			return null;
		}
		
		String left = FindAncestor(node.getLeft(), one, two);
		String right = FindAncestor(node.getRight(), one, two);
		
		System.out.println("Node->"+node.getVal()+"Left->"+left+"Right->"+right);
		// If both subtrees are null return null
		 if((left == null && right == null) && (node.getVal()!=one.getVal() && node.getVal()!=two.getVal()))
		{
			return null;
		}
		 // If a leaf node is the first node return first node
		 else if((left == null && right == null) && (node.getVal()==one.getVal()))
		 {
			 return one.getVal()+"";
		 }
		 // If a leaf node is the second node return second node
		 else if((left == null && right == null) && (node.getVal()==two.getVal()))
		 {
			 return two.getVal()+"";
		 }
		// If both subtrees return one of each node return current node as ancestor
		else if((left!=null && right != null) && ((left.equals(one.getVal()+"") || left.equals(two.getVal()+"") && (right.equals(one.getVal()+"") || (right.equals(two.getVal()+""))))))
		{
			return node.getVal()+"A";
		}
		//If either of the subtrees return first node
		else if((left == one.getVal()+"") || (right == one.getVal()+""))
		{
			return one.getVal()+"";
		}
		//If either of subtrees return second node
		else if((left == two.getVal()+"") || (right == two.getVal()+""))
		{
			return two.getVal()+"";
		}
		//If both nodes don't return null, both nodes or if they don't return atleast one of the values
		else 
		{
			//System.out.println(node.getVal()+"~~~~~~"+right);
			if((left!=null) && (left.endsWith("A")))
			{
				return left;
			}
			else
			{
				return right;
			}
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
		BinaryNode seven = new BinaryNode(7);
		BinaryNode eight = new BinaryNode(8);
		BinaryNode nine = new BinaryNode(9);
		BinaryNode ten = new BinaryNode(10);
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setRight(six);
		
		six.setLeft(seven);
		six.setRight(eight);
		eight.setRight(nine);
		nine.setRight(ten);
		
		LeastCommonAncestor lca = new LeastCommonAncestor();
		lca.treeHead = one;
		
		System.out.println(lca.FindAncestor(lca.treeHead, seven, ten)+"++++++");
	} */

}
