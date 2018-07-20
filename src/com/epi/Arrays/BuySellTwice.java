package com.epi.Arrays;
import java.util.*;
/**
 * Program to buy and sell stock twice for maximum profit
 * Track min price and maxProfit from left to right and store.
 * Track maxPrice and maxProfit from right to left, add to previous profit (i-1)
 * to find maxProfit
 * @author daebenez
 * Time : O(N) Space: O(1)
 */
public class BuySellTwice {
	
	public static int maxProfit(int[] input)
	{
		ArrayList<Integer> firstBuy = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		for(int i=0;i<input.length;i++)
		{
			min = Math.min(input[i], min);
			maxProfit = Math.max(input[i]-min, maxProfit);
			firstBuy.add(maxProfit);
		}
		
		int max = Integer.MIN_VALUE;
		maxProfit = 0;
		for(int i=input.length-1;i>0;i--)
		{
			max = Math.max(input[i], max);
			maxProfit = Math.max((max-input[i])+firstBuy.get(i-1), maxProfit);
		}
		
		return maxProfit;
	}
	
	public static void main(String[] args)
	{
		int[] input = {12,11,13,9,12,8,14,13,15};
		System.out.println(maxProfit(input));
		
	}

}
