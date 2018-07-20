package com.epi.Arrays;
/**
 * Program to buy and sell stock once
 * @author david
 * Track min price and current maxProfit
 * Time : O(N), Space : O(1)
 */
public class BuySellStock {
	public static int stock(int[] input)
	{
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for(int i : input)
		{
			min = Math.min(min, i);
			maxProfit = Math.max(i-min,maxProfit); 
		}
		return maxProfit;
	}
	
	public static void main(String[] args)
	{
		int[] input = {310,315,275,295,260,270,290,230,255,250};
		System.out.println(stock(input));
	}

}
