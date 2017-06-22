package com.functional.DP;

import java.util.Arrays;

/**
 * Program to calculate fibonacci using Dynamic programming technique.
 * @author daebenez
 */
public class Fibonacci {
	
	private int[] cache = new int[1000]; 
	
	public int findFib(int fibNo)
	{
		if(fibNo==0)
		{
			cache[0]=0;
			return 0;
		}
		if(fibNo==1)
		{
			cache[1]=1;
			return 1;
		}
		
		if(cache[fibNo]!=0)
		{
			return cache[fibNo];
		}
		
		cache[fibNo] = findFib(fibNo-1)+findFib(fibNo-2);
		return cache[fibNo];
	}
	/*
	public static void main(String[] args)
	{
		Fibonacci obj = new Fibonacci();
		System.out.println(obj.findFib(40));
	} */

}
