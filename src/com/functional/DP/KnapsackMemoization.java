package com.functional.DP;
/**
 * Program to solve Knapsack using memoization.
 * @author daebenez
 * Time complexity : O(nW)
 *
 */
public class KnapsackMemoization {
	
	public int findItems(int[] weight,int[] value,int index,int currWeight,int[][] cache)
	{
		if(cache[index][currWeight] != 0)
		{
			return cache[index][currWeight];
		}
		if(currWeight==0 || index==weight.length)
		{
			return 0;
		}
		
		if(weight[index] > currWeight)
		{
			return findItems(weight, value, index+1, currWeight,cache);
		}
		
		int leftMax = value[index] + findItems(weight, value, index+1,currWeight-weight[index],cache);
		int rightMax = findItems(weight, value, index+1, currWeight,cache);
		int sol = Math.max(leftMax, rightMax);
		cache[index][currWeight] = sol;
		return sol;
	}
	
	
	public static void main(String[] args)
	{
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    KnapsackMemoization obj = new KnapsackMemoization();
		int[][] cache = new int[100][100];
		System.out.println(obj.findItems(wt, val, 0, W, cache));
	}
}



