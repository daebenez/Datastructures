package com.datastructure.sortingalgorithms;

/**
 * @author daebenez
 * Implementation of insertion sort in Java
 * Time complexity : Worst & Average case -> Big-Oh n squared. Best case -> Big-Oh n
 * Space complexity : Big-Oh 1 (in place sorting)
 */

public class InsertionSort {
	
	public void sort(int[] input)
	{
		/* All items behind i in the array are maintained in sorted order. As i progresses through to the end
		 * j is used to iterate backwards and make sure all items are in sorted order
		 */
		for(int i=0;i<input.length;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(input[j]<input[j-1])
				{
					input = swap(j,input);
				}
			}
		}
		for(int p=0;p<input.length;p++)
			System.out.print(input[p]);
	}

	// swap 2 integers using the xor operator in place. 
	private int[] swap(int j, int[] input) {
		input[j] = input[j] ^ input[j-1];
		input[j-1] = input[j] ^ input[j-1]; 
		input[j] = input[j] ^ input[j-1];
		return input;
	}
	/*
	public static void main(String[] args)
	{
		InsertionSort ob = new InsertionSort();
		int[] input = {6,5,4,3,2,1};
		ob.sort(input);
	}
	*/
}

