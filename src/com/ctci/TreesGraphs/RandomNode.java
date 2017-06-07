package com.ctci.TreesGraphs;
import java.util.Random;
/**
 * Q 4.11
 * Program to get a random node from a binary tree in such a way that each node is equally
 * likely to be chosen.
 * Store attribute size in each binary node, that denotes number of children including itself
 * use random function to pick a number between 1 and size of node, if number is 1 return node
 * otherwise if number is less than size of left child recurse left else recurse right.
 * When inserting a node increment size of all parents when traversing to insert position.
 * @author daebenez
 * Time Complexity : O(N) modified DFS
 */
public class RandomNode {
	
	public void getRandom(TreeNode parent)
	{
		if(parent==null)
		{
			return;
		}
		Random rand = new Random();
		int index = rand.nextInt(parent.getSize());
		if(index==1)
		{
			System.out.println("Random value:"+parent.getVal());
		}
		else
		{
			int leftIndex = parent.getLeft()==null ? 0:rand.nextInt(parent.getSize()-1); 
			
			if(leftIndex==0)
			{
				System.out.println("Random Value:"+parent.getVal());
			}
			//If random number is less than size of left child recurse left else recurse right.
			else if(leftIndex <= parent.getLeft().getSize())
			{
				getRandom(parent.getLeft());
			} 
			else
			{
				getRandom(parent.getRight());
			}
		}
	}
	
	public void insertInorder(TreeNode parent,int val)
	{
		if(parent==null)
		{
			return;
		}
		
		if(val <= parent.getVal())
		{
			parent.setSize(parent.getSize()+1);
			if(parent.getLeft()==null)
			{
				TreeNode node = new TreeNode(val, parent.getSize()+1);
				parent.setLeft(node);
			}
			else
			{
				insertInorder(parent.getLeft(), val);
			}
		}
		else 
		{
			parent.setSize(parent.getSize()+1);
			if(parent.getRight()==null)
			{
				TreeNode node = new TreeNode(val, parent.getSize()+1);
				parent.setRight(node);
			}
			else
			{
				insertInorder(parent.getRight(), val);
			}
		}
	}
	/*
	public static void main(String[] args)
	{
		TreeNode twenty = new TreeNode(20, 8);
		TreeNode ten = new TreeNode(10, 6);
		TreeNode thirty = new TreeNode(30, 1);
		TreeNode five = new TreeNode(5, 3);
		TreeNode three = new TreeNode(3, 1);
		TreeNode seven = new TreeNode(7, 1);
		TreeNode fifteen = new TreeNode(15, 2);
		TreeNode seventeen = new TreeNode(17, 1);
		
		twenty.setLeft(ten);
		twenty.setRight(thirty);
		ten.setLeft(five);
		ten.setRight(fifteen);
		fifteen.setRight(seventeen);
		five.setLeft(three);
		five.setRight(seven);
		
		RandomNode obj = new RandomNode();
		obj.getRandom(twenty);
	} */

}
