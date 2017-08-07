package com.ctci.SortSearch;
import java.util.BitSet;
/**
 * Program to find duplicates using Bit Vector.
 * May or may not be able to use the bitSet class.
 * @author daebenez
 * Time Complexity : O(N)
 */
public class FindDuplicates {
	
	public StringBuffer duplicates(int[] input)
	{
		StringBuffer res = new StringBuffer();
		BitSet tracker = new BitSet();
		for(int i=0;i<input.length;i++)
		{
			if(tracker.get(input[i])==true)
			{
				res.append(input[i]+",");
			}
			else
			{
				tracker.set(input[i]);
			}
		}
		return res;
	}
	/*
	public static void main(String[] args)
	{
		FindDuplicates obj = new FindDuplicates();
		int[] input = {1,13,4,5,6,7,4,13};
		System.out.println(obj.duplicates(input));
	} */
}
