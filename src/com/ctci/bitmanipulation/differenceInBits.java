package com.ctci.bitmanipulation;
/**
 * Q 5.6
 * Program to calculate the number of bits that need to be flipped for int x to be turned to int y.
 * @author daebenez
 * Time Complexity : O(log N) -> It takes log N bits to represent an N bit number and we iterate through diff once.
 * Space complexity : O(1)
 */
public class differenceInBits {
	
	public int difference(int x,int y)
	{
		int count = 0;
		int diff = x ^ y;

		while(diff!=0)
		{
			if((diff&1)!=0)
			{
				count++;
			}
			diff = diff >> 1;
		}
		return count;
	}
	/*
	public static void main(String[] args)
	{
		differenceInBits obj = new differenceInBits();
		System.out.println(obj.difference(4, 7));
	} */
}
