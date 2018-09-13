package com.epi.Search;

public class FirstOccurance {
	
	public static int find(int[] input, int target)
	{
		int low =0, high = input.length-1, mid=0;
		int firstOccurance = Integer.MAX_VALUE;
		while(low<=high)
		{
			mid = low + high-low/2;
			if(input[mid]==target)
			{
				firstOccurance = mid;
				high = mid-1;
			}
			else if(input[mid]<target)
			{
				low = mid+1;
			}
			else 
			{
				high = mid-1;
			}
		}
		
		return (firstOccurance==Integer.MAX_VALUE)?-1: firstOccurance;
	}

}
