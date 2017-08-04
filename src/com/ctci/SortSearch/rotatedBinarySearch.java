package com.ctci.SortSearch;
/**
 * CTCI Q 10.3
 * Program to implement binary search on a rotated array.
 * @author daebenez
 * Time Complexity : log(N)
 */
public class rotatedBinarySearch {
	
	public int search(int[] input,int target)
	{
		int start = 0;
		int end = input.length-1;
		int pivot = (end - start)/2 + (start);
		
		// If element at pivot is > at start, find the rotation at the right half.
		if(input[pivot]>input[start])
		{
			while(input[pivot+1]>input[pivot])
			{
				pivot++;
			}
			// find if the element at pivot is the number else send either left or right half to binary search.
			if(input[pivot]==target)
			{
				return pivot;
			}
			else if(input[pivot]<target)
			{
				return binarySearch(input, pivot+1, end, target);
			}
			else
			{
				return binarySearch(input, start, pivot-1, target);
			}
		}
		else
		{
			//find the rotation in the left half.
			while(input[pivot-1]<input[pivot])
			{
				pivot--;
			}
			if(input[pivot]==target)
			{
				return pivot;
			}
			// send the left and right half in reverse order.
			else if(input[pivot]<target)
			{
				return binarySearch(input, start, pivot-1, target);
			}
			else
			{
				return binarySearch(input, pivot+1, end, target);
			}
		}
	}
	
	private int binarySearch(int[] input, int start, int end, int target) {
		int pivot = (end - start)/2 + (start);
		if(start<end)
		{
			if(input[pivot]==target)
			{
				return pivot;
			}
			else if(input[pivot]<target)
			{
				return binarySearch(input, pivot+1, end, target);
			}
			else
			{
				return binarySearch(input, start, pivot-1, target);
			}
		}
		else
		{
			if(input[pivot]!=target)
			{
				return -1;
			}
			else
			{
				return pivot;
			}
		}
	}
	/*
	public static void main(String[] args)
	{
		rotatedBinarySearch obj = new rotatedBinarySearch();
		int[] input = {15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println(obj.search(input, 16));
	} */

}
