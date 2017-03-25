/**
 * @author daebenez
 * Brian Kernighan Algorithm to find count of set digits in a binary representation of an integer.
 * When n is & with (n-1) rightmost set bit is cleared and counted, this way we count all set bits in n
 * Time complexity is O(log n) | because worst case n may have all its bit set to 1 in which case this
 * this algorithm sets every bit to 0 before counting it.
 * For example see here : http://stackoverflow.com/questions/12383002/please-explain-the-logic-behind-kernighans-bit-counting-algorithm
 */

package com.functional.bitmanipulation;
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
