package com.ctci.TreesGraphs;
/**
 * CTCI Q 4.2
 * Program to create a balanced BST with minimum possible height, from
 * a sorted (ascending order) array.
 * @author daebenez
 */
public class MinBST {
	
	BinaryNode head = null;
	
	public BinaryNode minBST(int[] input,int start,int end)
	{
		//base case
		if(start > end)
		{
			return null;
		}
		// make a node using the mid element.
		int mid = start + (end - start) / 2;
		BinaryNode temp = new BinaryNode(input[mid]);
		
		//send the left sub array into left sub tree
		temp.setLeft(minBST(input,start,mid-1));
		//send the right sub array into right sub tree.
		temp.setRight(minBST(input,mid+1,end));
		//Set root as head node for BST.
		head = temp;
		return temp;
	}
	/*
	public static void main(String[] args)
	{
		MinBST obj = new MinBST();
		int[] input = {1,2,3,4,5,6,7};
		obj.minBST(input, 0, 6);
	} */
}
