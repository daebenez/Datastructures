package com.functional.recursion;
import java.time.Duration;
import java.time.Instant;
/**
 * Program to solve knapsack problem using recursion.
 * @author daebenez
 * Time complexity : O(2^N)
 *
 */

public class KnapsackRecursion {
	
	public int findItems(int[] weight,int[] value,int index,int currWeight)
	{
		if(currWeight==0 || index==weight.length)
		{
			return 0;
		}
		
		if(weight[index] > currWeight)
		{
			return findItems(weight, value, index+1, currWeight);
		}
		
		int leftMax = value[index] + findItems(weight, value, index+1,currWeight-weight[index]);
		int rightMax = findItems(weight, value, index+1, currWeight);
		return Math.max(leftMax, rightMax);
	}
	
	
	public static void main(String[] args)
	{
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
		KnapsackRecursion obj = new KnapsackRecursion();
		System.out.println(obj.findItems(wt, val, 0, W));
		
	}

}
