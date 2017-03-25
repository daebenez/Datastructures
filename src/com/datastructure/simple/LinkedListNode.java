package com.datastructure.simple;

/**
 * @author daebenez
 * Implementation of LinkedList Node in Java
 * Has a data field, pointers to the previous node and the next node
 *
 */

public class LinkedListNode {
	
	int data;
	LinkedListNode prev, next;
	
	
	/**
	 * Constructor 
	 */
	
	public LinkedListNode() {
		super();
	}

	/**
	 * Constructor 
	 * @param data
	 */
	
	public LinkedListNode(int data) {
		super();
		this.data = data;
	}

	/**
	 * Constructor
	 * @param prev
	 * @param next
	 * @param data
	 */
	
	public LinkedListNode(LinkedListNode prev, LinkedListNode next, int data) {
		super();
		this.prev = prev;
		this.next = next;
		this.data = data;
	}
	
	/**
	 * Setters and getters
	 */
	public LinkedListNode getPrev() {
		return prev;
	}
	public void setPrev(LinkedListNode prev) {
		this.prev = prev;
	}
	public LinkedListNode getNext() {
		return next;
	}
	public void setNext(LinkedListNode next) {
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
}
