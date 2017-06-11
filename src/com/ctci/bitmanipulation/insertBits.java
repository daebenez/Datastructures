package com.ctci.bitmanipulation;
/**
 * Q 5.1
 * Program to insert an integer into another using Bit manipulation technique.
 * @author daebenez
 * Time complexity : O(log N) -> iterating through binary representation of an integer takes this time.
 */
public class insertBits {
	
	public void insert(int N,int M,int i,int j)
	{
		//prepare mask for N
		int allOnes = ~0;
		// Shift all ones to left j+1 times to create trailing zeros at the end
		int rightMask = allOnes << (j+1);
		int leftMask = allOnes << (i);
		leftMask = ~leftMask;
		int mask = rightMask | leftMask;
		//set bits from i to j to zero
		int N_cleared = N & mask;
		// trailing zeros for N
		M = M << i;
		int result = N_cleared | M;
		System.out.println(result);
	}
	/*
	public static void main(String[] args)
	{
		insertBits obj = new insertBits();
		obj.insert(512, 19, 2, 6);
	} */

}
