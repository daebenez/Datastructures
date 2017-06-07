package com.ctci.TreesGraphs;

public class TreeNode {
	
	private TreeNode left,right;
	private int val;
	private int size;
	
	public TreeNode(int val, int size) {
		super();
		this.val = val;
		this.size = size;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
