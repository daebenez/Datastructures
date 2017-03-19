package com.datastructure.sortingalgorithms;
import java.util.*;
/**
 * @author daebenez
 * Implementation of couting sort in java.
 * Create a k indexed array to store count of each input item.
 * where k is the maximum number in the range. This program assumes k to be 9.
 * create a sum count array. For each element in the original array, find its
 * position in the sum count array and insert it into the final array.
 * Decrement position value from sumcount array by 1.
 * Time complexity : Average, Best, Worst case -> O(n+k)
 * Space complexity : O(k)
 */
 
 class CountingSort{
	 
	 public int[] sort(int[] input)
	 {
		int[] result = new int[11];
		int[] index = new int[11];
		// create counts of each item from input in the index array.
		for(int i=0;i<input.length;i++)
		{
			int temp = input[i];
			index[temp] = index[temp]+1;
		}
		// Create sumcount array by adding value at each position by previous value.
		for(int j=2;j<index.length;j++)
		{
			index[j] = index[j]+index[j-1];
		}
		for(int k=0;k<input.length;k++)
		{
			int tempTwo = input[k];
			int finalIndex = index[tempTwo];
			result[finalIndex] = tempTwo;
			index[tempTwo] = index[tempTwo] - 1;
		}
		return result;
	 }
	 /*
	 public static void main(String[] args)
	 {
		CountingSort cs = new CountingSort();
		int[] input = {1,4,1,2,7,5,2};
		int[] r = cs.sort(input);
		System.out.println(Arrays.toString(r));
	 }*/
 
 }