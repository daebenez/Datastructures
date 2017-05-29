package com.datastructure.trees;
/**
 * Program to create a Binary Tree from Inorder and Preorder traversals
 * @author daebenez
 * Time Complexity : O(N)
 *
 */
public class InorderPreorder {
	
	private int prePointer = 0;
	
	public BinaryNode buildTree(int[] inorder,int[] preorder)
	{
		return recursiveBuild(inorder, preorder, 0, inorder.length-1);
	}
	
	public BinaryNode recursiveBuild(int[] inorder,int[] preorder,int start,int end)
	{
		if(start>end)
		{
			return null;
		}
		
		BinaryNode node = new BinaryNode(preorder[prePointer]);
		int x = 0;
		while(inorder[x]!=preorder[prePointer])
		{
			x++;
		}
		prePointer++;
		node.setLeft(recursiveBuild(inorder, preorder, start, x-1));
		node.setRight(recursiveBuild(inorder, preorder, x+1, end));
		return node;
	}
	/*
	public static void main(String[] args)
	{
		int[] inorder = {2,5,6,10,12,14,15};
		int[] preorder = {10,5,2,6,14,12,15};
		InorderPreorder obj = new InorderPreorder();
		BinaryNode head = obj.buildTree(inorder, preorder);
		System.out.println(head.getRight().getLeft().getVal());
	} */

}
