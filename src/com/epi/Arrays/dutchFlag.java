package com.epi.Arrays;
/**
 *  Dutch National Flag problem (Lazy Sorting)
 *  Program to sort arrays around a median (Lazy sort).
 *  Items less than median are sent to the left (left pointer). Items greater to the right (right pointer)
 *  And nothing is done for items that are equal
 *  Time complexity : O(N), Space Complexity : O(1)
 */
import java.util.Arrays;
public class dutchFlag {
	
	public static void sortNumbers(int[] input,int pivot)
	{
		int small = 0, unclassified = 0, large=input.length-1;
		while(unclassified<large)
		{
			if(input[unclassified]<pivot)
			{
				int temp = input[small];
				input[small] = input[unclassified];
				input[unclassified] = temp;
				small++;
				unclassified++;
			}
			else if(input[unclassified]==pivot)
			{
				unclassified++;
			}
			else
			{
				int temp = input[large];
				input[large] = input[unclassified];
				input[unclassified] = temp;
				large--;
			}
		}
		System.out.println(Arrays.toString(input));
	}
	
	public static void main(String[] args)
	{
		int[] input = {2,1,3,1,2,1,1,3,2};
		sortNumbers(input, 2);
	}

}
