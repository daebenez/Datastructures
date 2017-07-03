package com.functional.DP;
/**
 * Program to calculate longest increasng subsequence given an array.
 * Use dynamic programming Top Down (iterative) approach.
 * @author daebenez
 * Time complexity : O(N*N)
 * Space Complexity : O(N)
 * Refer -> https://www.youtube.com/watch?v=CE2b_-XfVDk
 */
public class LongestIncreasingSubsequence {
	
	public int findSequence(int[] input,int size)
	{
		int[] array = new int[size];
		for(int z=0;z<size;z++)
		{
			array[z]=1;
		}
		
		for(int i=1;i<size;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(input[j]<input[i])
				{
					if((array[j]+1) > array[i])
					{
						array[i]= array[j]+1;
					}
				}
			}
		}
		int max = 0;
		for(int z=0;z<size;z++)
		{
			if(array[z]>max)
			{
				max = array[z];
			}
		}
		return max;
	}
	/*
	public static void main(String[] args)
	{
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int[] input = {0,20,40,60,70,50,30,10};
		System.out.print("Longest Subsequence is :");
		System.out.println(obj.findSequence(input, input.length));
	} */
}
