package com.ctci.DynamicProgramming;
/**
 * Program to find if an array has a magic index.
 * @author daebenez
 */
public class MagicIndex {
	
	public void findMagic(int[] input,int start,int end)
	{
		int mid = start + (end - start)/2;
		if(end<start)
		{
			System.out.println("Element not found");
		}
		//check mid
		if(mid==input[mid])
		{
			System.out.println(mid);
		}
		else if(mid>input[mid])
		{
			findMagic(input, mid+1, end);
		}
		else
		{
			findMagic(input, start, mid-1);
		}
	}
	/*
	public static void main(String[] args)
	{
		int[] input = {-5,-3,-1,2,3,4,6,78}; 
		MagicIndex obj = new MagicIndex();
		obj.findMagic(input, 0, 7);
	} */
}
