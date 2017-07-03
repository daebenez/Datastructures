package com.functional.DP;
import java.util.Arrays;
/**
 * Program to calculate combinations of steps of 1,2 and 3 that could be used to reach n steps
 * Dynamic Programming memoization technique is used.
 * Tribonacci sequence gives the number of combinations.
 * @author daebenez
 * Time Cmplexity : O(N) -> since overlapping sub problems are stored and reused.
 */
public class StepsProblem {
	
	int[] cache = new int[100];
	
	public StepsProblem()
	{
		for(int i=0;i<100;i++)
		{
			cache[i]=Integer.MIN_VALUE;
		}
	}
	
	public int findCombinations(int maxSteps)
	{
		if(maxSteps==0)
		{
			cache[0]=0;
			return cache[0];
		}
		if(maxSteps==1 || maxSteps==2)
		{
			cache[maxSteps]=1;
			return cache[maxSteps];
		}
		
		if(cache[maxSteps]!=Integer.MIN_VALUE)
		{
			return cache[maxSteps];
		}
		else
		{
			cache[maxSteps] =  findCombinations(maxSteps-1)+findCombinations(maxSteps-2)+findCombinations(maxSteps-3);
			return cache[maxSteps];
		}
	}
	/*
	public static void main(String[] args)
	{
		StepsProblem obj = new StepsProblem();
		System.out.println(obj.findCombinations(9));
		System.out.println(Arrays.toString(obj.cache));
	} */

}
