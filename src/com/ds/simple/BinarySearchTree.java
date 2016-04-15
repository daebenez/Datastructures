package com.ds.simple;
import com.ds.simple.BinaryNode;
/**
 * @author daebenez
 * Implementation of binary search tree using Java (Recursive version)
 * Time Complexity : Insertion, deletion, search : Big Oh log n
 */

public class BinarySearchTree {
	
	private BinaryNode root = null;
	
	public BinaryNode getRoot() {
		return root;
	}

	/*
	 * Method to set root node
	 */
	public void setRoot(BinaryNode root) {
		this.root = root;
	}
	
	private void insert(int val)
	{
		insertRecursive(root, val);
		//System.out.println("Value inserted correctly");
	}

	/*
	 * Method to insert a value recursively traversing left or right subtrees of the tree
	 */
	private void insertRecursive(BinaryNode node, int val) {
		
		if(node==null && root==null)
		{
			BinaryNode input = new BinaryNode(val);
			System.out.println("Root set to:"+ input.getVal());
			root = input;
		}
		else if(node.getVal()==0)
		{
			node.setVal(val);
		}
		else if(node.getVal() > val)
		{
			if(node.getLeft() == null)
			{
				BinaryNode empty = new BinaryNode();
				node.setLeft(empty);
				insertRecursive(empty, val);
			}
			else
			{
				insertRecursive(node.getLeft(), val);
			}
			
		}
		else if(node.getVal() < val)
		{
			if(node.getRight() == null)
			{
				BinaryNode empty = new BinaryNode();
				node.setRight(empty);
				insertRecursive(empty, val);
			}
			else
			{
				insertRecursive(node.getRight(),val);
			}
			
		}
		else
		{
			System.out.println("Cannot insert duplicates");
		}
	}

	
	private void delete(int val)
	{
		deleteRecursive(root,val);
	}

	/*
	 * Method to recursively traverse the tree and delete a node in the left or right sub tree
	 * Deleted Elements are set to zero !
	 */
	private void deleteRecursive(BinaryNode node, int val) {
		
		if(node==null)
		{
			System.out.println("Value does not exist in the tree");
		}
		else if(node.getVal()> val)
		{
			deleteRecursive(node.getLeft(), val);
		}
		else if(node.getVal()< val)
		{
			deleteRecursive(node.getRight(), val);
		}
		else if(node.getVal() == val)
		{
			BinaryNode lft = node.getLeft();
			BinaryNode rgt = node.getRight();
			
			if(lft == null && rgt == null)
			{
				node.setVal(0);
			}
			else if(lft == null)
			{
				node.setVal(0);
				node = node.getRight();
			}
			else if(rgt == null)
			{
				node = node.getLeft();
			}
			else
			{
				node.setVal(0);
				node = rgt;
				BinaryNode nodeptr = new BinaryNode();
				while(node.getLeft()!= null)
				{
					nodeptr = node.getLeft();
				}
				nodeptr.setLeft(lft);
			}
		}
	}
	
	private void Inorder()
	{
		System.out.println("");
		System.out.println("Inorder Tree Trsversal");
		InorderRecursive(root);
	}
	
	/*
	 * Inorder Traversal > left, root and right
	 */
	private void InorderRecursive(BinaryNode node)
	{ 
		if(node != null)
		{
			InorderRecursive(node.getLeft());
			System.out.print(node.getVal());
			InorderRecursive(node.getRight());
		}
	}
	
	private void Preorder()
	{
		System.out.println("");
		System.out.println("Preorder Tree traversal");
		PreorderRecursive(root);
	}
	
	/*
	 * Preorder Traversal > root left right
	 */
	private void PreorderRecursive(BinaryNode node)
	{
		if(node != null)
		{
			System.out.print(node.getVal());
			PreorderRecursive(node.getLeft());
			PreorderRecursive(node.getRight());
		}
	}
	
	private void Postorder()
	{
		System.out.println("");
		System.out.println("Postorder Tree traversal");
		PostOrderRecursive(root);
	}
	
	/*
	 * Postorder traversal > left right root
	 */
	private void PostOrderRecursive(BinaryNode node)
	{
		if(node != null)
		{
			PostOrderRecursive(node.getLeft());
			PostOrderRecursive(node.getRight());
			System.out.print(node.getVal());
		}
	}
	/*
	 * Test function
	 */
	/*public static void main(String[] args)
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(4);
		bst.insert(2);
		bst.insert(7);
		bst.insert(5);
		bst.insert(6);
		bst.insert(8);
		bst.insert(1);
		bst.insert(3);
		System.out.println(bst.getRoot().getVal());
		System.out.println(bst.getRoot().getLeft().getVal());
		System.out.println(bst.getRoot().getRight().getVal());
		BinaryNode rt = bst.getRoot();
		BinaryNode rt_left = rt.getLeft();
		BinaryNode rt_rght = rt.getRight();
		System.out.println(rt_left.getLeft().getVal());
		System.out.println(rt_left.getRight().getVal());
		bst.Inorder();
		bst.Preorder();
		bst.Inorder();
		bst.delete(7);
		bst.Inorder();
		
	}*/
}
