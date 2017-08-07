package com.ctci.SortSearch;
import java.util.Arrays;
/**
 * CTCI Q 10.11
 * Program to sort an array so they form peaks and valleys.
 * Check each element and the element after it, if they are not in the correct order, swap.
 * @author daebenez
 * Time Complexity : O(N)
 */
public class PeaksValleys {
	
	public int[] sort(int[] a)
	{
		boolean x = true;
		// true = peak, false = valley
		for(int i=0;i<a.length-1;i++)
		{
			if(x)
			{
				if(a[i]<a[i+1])
				{
					a[i] = a[i]^a[i+1];
					a[i+1] = a[i]^a[i+1];
					a[i] = a[i]^a[i+1];
				}
				x=false;
			}
			else
			{
				if(a[i]>a[i+1])
				{
					a[i] = a[i]^a[i+1];
					a[i+1] = a[i]^a[i+1];
					a[i] = a[i]^a[i+1];
				}
				x = true;
			}
		}
			
		return a;
	}
	/*
	public static void main(String[] args)
	{
		PeaksValleys obj = new PeaksValleys();
		int[] input = {5,3,1,2,3};
		int[] res = obj.sort(input);
		System.out.println(Arrays.toString(res));
	}*/
}
