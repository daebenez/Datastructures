package com.datastructure.trees;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author daebenez
 * Program to create a min heap from an unsorted array.
 * Insert element and remove min.
 * Time complexity : create heap O(n) since we iterate through size/2 to start of the array.
 * Add or remove element : O(n) -> Heapify works similarly iterating through all parent nodes.
 * Array representation of balanced binary tree Parent-> i, Left Child -> 2i+1 Right child-> 2i+2
 */
public class MinHeap {
	
	BinaryNode head = new BinaryNode();
	
	//Given an unsorted array rearrange elements in min heap order.
	public void createMinHeap(int[] input)
	{
		int size = input.length;
		int parentNodes = (size/2);
		int parent = parentNodes;
		while(parent>-1)
		{
			if((2*parent+1)<size && input[(2*parent+1)]<input[parent])
			{
				swap(input,parent,(2*parent+1));
			}
			if((2*parent+2)<size && input[(2*parent+2)]<input[parent])
			{
				swap(input,parent,(2*parent+2));
			}
			parent = parent -1 ;
		}
	}
	
	//Method to swap 2 integers.
	private void swap(int[] input, int parent, int i) {
		input[parent] = input[parent] ^ input[i];
		input[i] = input[parent] ^ input[i];
		input[parent] = input[parent] ^ input[i];
	}

	//Given an array in min heap order, create a min heap tree.
	public void createHeapTree(int[] input)
	{
		int size = input.length;
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		int i = 0;
		BinaryNode temp = head;
		queue.add(temp);
		while(i<size)
		{
			BinaryNode temp2 = queue.remove();
			temp2.setVal(input[i]);
			if((2*i+1)<size)
			{
				BinaryNode tempLeft = new BinaryNode();
				temp2.setLeft(tempLeft);
				queue.add(tempLeft);
			}
			if((2*i+2)<size)
			{
				BinaryNode tempRight = new BinaryNode();
				temp2.setRight(tempRight);
				queue.add(tempRight);
			}
			i++;
		}
	}
	
	//Method to add an element to min heap.
	public void addElement(int val,int[] input)
	{
		int index = input.length;
		input[index-1] = val;
		createMinHeap(input);
		createHeapTree(input);
	}
	
	//Method to maintain heap order from top down after removal of min elements
	public void Heapify(int[] input)
	{
		int size = input.length;
		int parentNode = size/2;
		int parent=0;
		while(parent<parentNode+1)
		{
			if((2*parent+1)<size && input[(2*parent+1)]<input[parent])
			{
				swap(input,parent,(2*parent+1));
			}
			if((2*parent+2)<size && input[(2*parent+2)]<input[parent])
			{
				swap(input,parent,(2*parent+2));
			}
			parent++ ;
		}
	}
	
	//Method to remove min element from heap.
	public void getMin(int[] input)
	{
		swap(input,0,input.length-1);
		input[input.length-1] = 1000;
		Heapify(input);
	}

	//Method to print min heap tree.
	public void printHeap()
	{
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		BinaryNode temp = head;
		queue.add(temp);
		while(!queue.isEmpty())
		{
			BinaryNode ty = queue.remove();
			System.out.println(ty.getVal());
			if(ty.getLeft() != null)
			{
				queue.add(ty.getLeft());
			}
			if(ty.getRight() != null)
			{
				queue.add(ty.getRight());
			}
		}
	}
	
	
	/*public static void main(String[] args)
	{
		MinHeap t = new MinHeap();
		int[] input = {2,3,6,1,8,9};
		t.createMinHeap(input);
		t.createHeapTree(input);
		//t.printHeap();
		int[] input1 = {2,3,6,1,8,9,10};
		MinHeap t1 = new MinHeap();
		//t1.addElement(-2, input1);
		t1.getMin(input1);
		System.out.println(Arrays.toString(input1));
	} */
}
