package com.datastructure.sortingalgorithms;

/**
 * @author daebenez
 * Implementation of Merge sort in Java
 * Time complexity : Best,Worst case & Average case -> Big oh nlog n.
 * Space complexity : Big Oh n
 */

public class MergeSort {
	
	int[] inputArray = {4,1,6,8,5,3,9,7,10};
	int[] tempArray = new int[inputArray.length];
	public void startSort()
	{
		sort(0,inputArray.length-1);
	}
	
	/*
	 * Function that sorts an array by recursively dividing it until 
	 * they become single element sorted array 
	 */
	private void sort(int low, int high) {
		if(low < high)
		{
			int mid = low + (high - low) / 2;
			sort(low,mid);
			sort(mid+1,high);
			
			merge(low,mid,high);
		}
		
	}
	
	/*
	 * Merge split and sorted arrays togther in the sorted order
	 */
	private void merge(int low, int mid, int high) {
		
		for(int arr_i = low;arr_i <= high;arr_i++)
		{
			tempArray[arr_i] = inputArray[arr_i];
		}
		int i = low;
		int j = mid+1;
		int k = low;
		
		while(i<=mid && j<=high)
		{
			if(tempArray[i] <= tempArray[j])
			{
				inputArray[k] = tempArray[i];
				i++;
			}
			else
			{
				inputArray[k] = tempArray[j];
				j++;
			}
			k++;
			
		}
		while(i<=mid)
		{
			inputArray[k] = tempArray[i];
			k++;
			i++;
		}
		
	}

	// Test function
	/*public static void main(String[] args)
	{
		MergeSort sort =new MergeSort();
		sort.startSort();
	    for(int i=0;i<sort.inputArray.length;i++)
	    {
	    	System.out.print(sort.inputArray[i]);
	    }
		
	}*/

}
