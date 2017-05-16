package com.ctci.TreesGraphs;
/**
 * Helper class Binary Node with a each node having a pointer to its parent.
 * @author daebenez
 *
 */
public class BinaryNodeBackEdge {
	
	private BinaryNodeBackEdge left,right,parent;
	private int val;
	
	public BinaryNodeBackEdge(int val) {
		super();
		this.val = val;
	}
	public BinaryNodeBackEdge getLeft() {
		return left;
	}
	public void setLeft(BinaryNodeBackEdge left) {
		this.left = left;
	}
	public BinaryNodeBackEdge getRight() {
		return right;
	}
	public void setRight(BinaryNodeBackEdge right) {
		this.right = right;
	}
	public BinaryNodeBackEdge getParent() {
		return parent;
	}
	public void setParent(BinaryNodeBackEdge parent) {
		this.parent = parent;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}

}
