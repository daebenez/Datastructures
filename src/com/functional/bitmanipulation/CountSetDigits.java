/**
 * @author daebenez
 * Brian Kernighan Algorithm to find count of set digits for a binary representation of an integer.
 */

package com.ds.simple;
class CountSetDigits {

	public int countOnes(int n)
	{
		int count =0; 
		while(n!=0)
		{
		  n = n & (n-1);
		  count++;
		}
		return count;
	}

	public static void main(String[] args)
	{
		CountSetDigits countObj = new CountSetDigits();
		System.out.println(countObj.countOnes(77));
	}
}
