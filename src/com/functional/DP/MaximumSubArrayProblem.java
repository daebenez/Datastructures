package com.functional.DP;
/**
 * Given an array find the maximum sum that can be obtained from adding conigious elements.
 * Kadane's algorithm.
 * @author daebenez
 */
public class MaximumSubArrayProblem {
	
	public int findArray(int[] input)
	{
		int runningSum = 0;
		int maxSum = 0;
		for(int i=0;i<input.length;i++)
		{
			if(input[i]>runningSum+input[i])
			{
				runningSum = input[i];
			}
			else
			{
				runningSum += input[i];
			}
			
			if(input[i]>runningSum)
			{
				if(input[i]>maxSum)
				{
					maxSum = input[i];
				}
			}
			else
			{
				if(runningSum>maxSum)
				{
					maxSum = runningSum;
				}
			}
		}
		return maxSum;
	}
	/*
	public static void main(String[] args)
	{
		int[] res = {-2,1,-3,4,-1,2,1,-5,4};
		MaximumSubArrayProblem obj = new MaximumSubArrayProblem();
		System.out.println(obj.findArray(res));
	}*/

}
