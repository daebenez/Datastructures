package com.ctci.SortSearch;
import java.util.Arrays;
/**
 * Program to Binary search when the size of array is not available.
 * @author daebenez
 * Time Complexity : O(log N) when we do the initial search for upper bound we increase by 2^N everytime.
 */
public class NoSizeBinarySearch {
	
	public int search(int[] input,int target)
	{
		int start = 0;
		int end = 1;
		
		while(input[end]!=-1)
		{
			if(input[end]==target)
			{
				return end;
			}
			else if(input[end]>target)
			{
				return searchUtil(input,start,end,target);
			}
			else 
			{
				start = end;
				end *= 2;
			}
			
		}
		System.out.println(input[end]);
		while(true)
		{
			int mid = (end-start)/2 + start;
			
			if(input[mid]==target)
			{
				return mid;
			}
			else if(input[mid]>target)
			{
				return searchUtil(input, start, end, target);
			}
			else if(input[mid]==-1)
			{
				end = mid-1;
			}
			else
			{
				start = mid+1;
			}
		}
		
	}

	private int searchUtil(int[] input, int start, int end, int target) {
		int mid = (end-start)/2+start;
		if(start<end)
		{
			if(input[mid]==target)
			{
				return mid;
			}
			else if(input[mid]<target)
			{
				return searchUtil(input, mid+1, end, target);
			}
			else
			{
				return searchUtil(input, start, mid-1, target);
			}
		}
		else
		{
			if(input[mid]==target)
			{
				return mid;
			}
			else
			{
				return -1;
			}
		}
		
	}
	/*
	public static void main(String[] args)
	{
		NoSizeBinarySearch obj = new NoSizeBinarySearch();
		int[] input = new int[100];
		for(int i=0;i<input.length;i++)
		{
			input[i]=-1;
		}
		for(int i=0;i<10;i++)
		{
			input[i]=i+1;
		}
		System.out.println(Arrays.toString(input));
		System.out.println(obj.search(input, 2));
	} */
}
