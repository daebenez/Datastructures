package com.datastructure.sortingalgorithms;

/**
 * @author daebenez
 * Implementation of Quick sort in Java
 * Time complexity : Best & Average case -> Big-Oh n log n. Worst case -> Big-Oh n squared
 * Space complexity : Big-Oh log n
 */

public class QuickSort {
	
	int[] inputArray = {4,1,6,8,5,3,9,7,10};
	
	// Call the recursive quicksort
	public void Sort()
	{
		int low = 0;
		int high = inputArray.length-1;
		
		recursiveQuicksort(low,high);
		
	}
	
	/*
	 * find a number on the left of the pivot that is greater than the pivot
	 * find a number from the right which is less than the pivot
	 * swap values.
	 * Once all values to the left are less than te pivot and values to
	 * the right are greater than the pivot call quick sort recursively 
	 * 
	 */
	private void recursiveQuicksort(int first, int last) {
		int low = first;
		int high = last;
		int pivot = (high - low) / 2 + low;
		while(low<=high)
		{
			while(inputArray[low] < inputArray[pivot])
			{
				low++;
			}
			while(inputArray[high] > inputArray[pivot])
			{
				high--;
			}
			if(low <= high)
			{
				swap(low,high);
				low++;
				high--;
			}
		}
		if(first < high)
			recursiveQuicksort(first, high);
		if(last > low)
			recursiveQuicksort(low, last);
	}


	public void swap(int low, int high) {
		int temp = inputArray[low];
		inputArray[low] = inputArray[high];
		inputArray[high] = temp;
	}

	// Test function
	/*public static void main(String[] args)
	{
		QuickSort qs = new QuickSort();
		qs.Sort();
		for(int i=0;i<qs.inputArray.length;i++)
		{
			System.out.print(qs.inputArray[i]);
		}
		
		
	}*/

}
