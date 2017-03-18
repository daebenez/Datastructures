package com.ds.simple;
/**
 * @author daebenez
 * Implementation of a Binary Tree Node using Java
 * Implements CompareTo interface.
 */	

public class BinaryNode implements Comparable<BinaryNode> {

	private BinaryNode left,right;
	private int val;
	
	public BinaryNode() {
		super();
	}

	public BinaryNode(int val) {
		super();
		this.val = val;
	}

	public BinaryNode(BinaryNode left, BinaryNode right, int val) {
		super();
		this.left = left;
		this.right = right;
		this.val = val;
	}
	
	public BinaryNode getLeft() {
		return left;
	}
	public void setLeft(BinaryNode left) {
		this.left = left;
	}
	public BinaryNode getRight() {
		return right;
	}
	public void setRight(BinaryNode right) {
		this.right = right;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	// compare by value and retuen 1 if current object value is lesser, -1 if greater and 0 if they are equal.
	public int compareTo(BinaryNode two){
		if(this.val > two.val)
			return -1;
		else if(this.val < two.val)
			return 1;
		else
			return 0;
	}
}
