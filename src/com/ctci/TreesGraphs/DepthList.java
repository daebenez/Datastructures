package com.ctci.TreesGraphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * CTCI Q 4.3
 * Program to create a list of linkedlists of all nodes at each depth 
 * In the first pass track height of node by adding 1 to each child node. For the second pass
 * create a new linkedlist for each new level and insert into the appropriate lists.
 * @author daebenez
 * Time Complexity : O(n) -> 2 pass BFS
 * Space complexity : O(n) -> for the queue.
 */
public class DepthList {
	//Track height using array.
	int[] height = new int[20];
	//Stores all linkedlists
	ArrayList<LinkedList<BinaryNode>> listOfLists = new ArrayList<LinkedList<BinaryNode>>();
	
	/**
	 * Method to create linkedlists to store nodes at each depth
	 */
	public boolean createDepthList(BinaryTree input)
	{
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(input.head);
		height[input.head.getVal()] = 0;
		//1st pass
		while(!queue.isEmpty())
		{
			// If left child is available update height and add node to queue.
			if(queue.peek().getLeft()!=null)
			{
				height[queue.peek().getLeft().getVal()] = height[queue.peek().getVal()] + 1;
				queue.add(queue.peek().getLeft());
			}
			// Do the same if right child is available.
			if(queue.peek().getRight()!=null)
			{
				height[queue.peek().getRight().getVal()] = height[queue.peek().getVal()] + 1;
				queue.add(queue.peek().getRight());
			}
			//remove current node from queue.
			queue.remove();
		}
		
		// 2nd pass
		queue.add(input.head);
		//Track current height
		int currCount = -1;
		while(!queue.isEmpty())
		{
			//If new height is create new linked list and insert node.
			if(currCount < height[queue.peek().getVal()])
			{
				currCount++;
				LinkedList<BinaryNode> tempList = new LinkedList<BinaryNode>();
				
				if(queue.peek().getLeft()!=null)
				{
					queue.add(queue.peek().getLeft());
				}
				if(queue.peek().getRight()!=null)
				{
					queue.add(queue.peek().getRight());
				}
				
				tempList.add(queue.remove());
				listOfLists.add(tempList);
				
			}
			else
			{
				if(queue.peek().getLeft()!=null)
				{
					queue.add(queue.peek().getLeft());
				}
				if(queue.peek().getRight()!=null)
				{
					queue.add(queue.peek().getRight());
				}
				listOfLists.get(currCount).add(queue.remove());
			}
		}
		
		return true;
	}
	
	/**
	 * Method to print all the LinkedLists.
	 */
	public void printLists()
	{
		for(LinkedList<BinaryNode> ls : listOfLists)
		{
			System.out.println();
			for(int i=0;i<ls.size();i++)
			{
				System.out.print(ls.get(i).getVal()+"|");
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
		tree.addNode(6);
		tree.addNode(7);
		tree.addNode(8);
		DepthList obj = new DepthList();
		obj.createDepthList(tree);
		obj.printLists();
	} */
}
