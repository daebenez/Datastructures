package com.ctci.SortSearch;
/**
 * CTCI Q 8.5
 * Program to do binary search several items are empty strings. 
 * If a mid chosen has an empty string. Use 2 pivots to find the nearest non empty string.set mid to the appropriate pivot
 * @author daebenez
 * Time Complexity : O(N) worst case, if every string in the array is empty.
 */
public class sparseBinarySearch {
	public int search(String[] input,int start,int end,String target)
	{
		int mid = (end-start)/2 + start;
		if(start<end)
		{
			if(input[mid].equals(target))
			{
				return mid;
			}
			else if(input[mid].equals(""))
			{
				int pivot1 = mid;
				int pivot2 = mid;
				int pivot = mid;
				while(input[pivot1].equals("") && input[pivot2].equals(""))
				{
					pivot1--;
					pivot2++;
				}
				
				if(input[pivot1]!="")
				{
					pivot = pivot1;
				}
				else
				{
					pivot = pivot2;
				}
				
				if(input[pivot]!="")
				{
					
					if(input[pivot].equals(target))
					{
						mid = pivot;
					}
					else if(input[pivot].charAt(0)>target.charAt(0))
					{
						mid = search(input, start, pivot-1, target);
					}
					else
					{
						mid = search(input, pivot+1, end, target);
					}	
				}
			}
			return mid;
		}
		else
		{
			if(input[mid].equals(target))
			{
				return mid;
			}
			else
			{
				System.out.println(mid);
				return -1;
			}
		}
	}
	/*
	public static void main(String[] args)
	{
		sparseBinarySearch obj = new sparseBinarySearch();
		String[] input = {"at","","","","ball","","","car","","","dad","",""};
		System.out.println(obj.search(input, 0, input.length, "dad"));
	} */
}
