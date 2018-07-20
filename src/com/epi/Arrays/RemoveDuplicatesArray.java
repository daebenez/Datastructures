package com.epi.Arrays;
/**
 * Program to remove duplicates from a sorted array.
 * Use 2 pointers. Swap when unequal, nothing otherwise.
 * Time complexity : O(N). Space complexity : O(1)
 * @author daebenez
 *
 */
public class RemoveDuplicatesArray {
	public static int remove(int[] input)
	{
		int writeIndex = 1;
		for(int i=1;i<input.length;i++)
		{
			if(input[writeIndex-1]!=input[i])
			{
				input[writeIndex] = input[i];
				writeIndex++;
			}
		}
		return writeIndex;
	}
	
	public static void main(String[] args)
	{
		int[] in = {2,3,5,5,7,11,11,11,13};
		System.out.println(remove(in));
	}

}
