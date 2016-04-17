package com.datastructure.sortingalgorithms;

/**
 * @author daebenez
 * Implementation of Binary Search in Java
 * Time complexity : Best case : Big oh 1 Average & Worst Case : Big oh log n
 */

public class BinarySearch {
	
	/*
	 * Binary Search for a number given a sorted array (Recursive version)
	 */
	public void binarySearch(int[] input_arr,int element)
	{
		binaryRecursive(input_arr,element,0,input_arr.length-1);
	}
	
	
	private void binaryRecursive(int[] input_arr, int element, int start, int end) {
		int mid = start + (end-start)/2;
		int index = -1;
		if(start < end)
		{
			if(input_arr[mid]==element)
			{
				index= mid;
				System.out.println("The position of number"+" "+element+" "+"is"+" "+(index+1));
			}
			
			else if(input_arr[mid] > element)
			{
				binaryRecursive(input_arr, element, start, mid-1);
			}
			else if(input_arr[mid] < element)
			{
				binaryRecursive(input_arr, element, mid+1, end);
			}
		}
		else
		{
			System.out.println("Element not found !!");
		}
	}


	/*
	 * Test function
	 */
	/*public static void main(String[] args)
	{
		BinarySearch bs = new BinarySearch();
		int[] input_arr = {1,2,3,4,5,6,7,8};
		int elem = 6;
		bs.binarySearch(input_arr, elem);
		
	}*/

}
