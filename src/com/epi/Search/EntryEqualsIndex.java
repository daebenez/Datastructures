package com.epi.Search;

public class EntryEqualsIndex {
	
	public static int find(int[] input)
	{
		int low = 0, high = input.length-1;
		while(low<=high)
		{
			int mid = low + (high-low)/2;
			if(input[mid]==mid)
			{
				return mid;
			}
			else if(input[mid]>mid)
			{
				high = mid-1;
			}
			else
			{
				low = mid+1;
			}
		}
		return -1;
	}

}
