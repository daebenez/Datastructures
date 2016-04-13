package com.ds.simple;

/**
 * @author daebenez
 * Implementation of a Binary Tree Node using Java
 *
 */

public class BinaryNode {
	
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
	
	
}
