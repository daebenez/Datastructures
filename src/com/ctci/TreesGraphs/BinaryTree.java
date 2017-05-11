package com.ctci.TreesGraphs;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Uses binary nodes to create a simple binary tree that is balanced.
 * @author daebenez
 */
public class BinaryTree {
	BinaryNode head = null;
	/**
	 * Use BFS to create a balanced tree.
	 * @param val
	 * @return true
	 */
	public boolean addNode(int val)
	{
		BinaryNode temp = new BinaryNode(val);
		if(head==null)
		{
			head = temp;
			return true;
		}
		else
		{
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(head);
			while(!queue.isEmpty())
			{
				if(queue.peek().getLeft()==null)
				{
					queue.peek().setLeft(temp);
					return true;
				}
				else if(queue.peek().getRight()==null)
				{
					queue.peek().setRight(temp);
					return true;
				}
				else
				{
					queue.add(queue.peek().getLeft());
					queue.add(queue.peek().getRight());
					queue.remove();
				}
			}
		}
		return false;
	}
	/**
	 * Method to print out tree contents
	 */
	public void printTree()
	{
		if(head==null)
		{
			System.out.println("Tree does not exist !");
		}
		else
		{
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(head);
			while(!queue.isEmpty())
			{
				System.out.println(queue.peek().getVal());
				if(queue.peek().getLeft()!=null)
				{
					queue.add(queue.peek().getLeft());
				}
				if(queue.peek().getRight()!=null)
				{
					queue.add(queue.peek().getRight());
				}
				queue.remove();
			}
		}
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
		tree.printTree();
	} */
}
