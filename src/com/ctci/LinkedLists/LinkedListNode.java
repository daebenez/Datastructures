package com.ctci.LinkedLists;
/**
 * Singly linked list Node in Java.
 * @author daebenez
 *
 */
public class LinkedListNode {
	
	private int data;
	private LinkedListNode next;
	
	public LinkedListNode() {
		super();
	}
	public LinkedListNode(int data) {
		super();
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkedListNode getNext() {
		return next;
	}
	public void setNext(LinkedListNode next) {
		this.next = next;
	}
}
