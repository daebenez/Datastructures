package com.ctci.bitmanipulation;
/**
 * Q 5.3
 * Program to find the longest sequence of 1's in a binary number when only 
 * 1 bit can be flipped to from 0 to 1.
 * Count sequences of 1's, if only 1 zero is encountered transfer the count to prevLength
 * set count to zero and continue, if prevLength is set and we encounter another zero, 
 * check if count + prevLength + 1 is greater than max, if so set max and continue.
 * @author daebenez
 * Time Complexity : O(N) -> we iterate through the bits just once
 * Space Complexity : O(1) -> we use a single string for storage. 
 *
 */
public class LongestSequence {
	
	public void findSequence(int input)
	{
		int ip = input;
		String inputOne = "";
		// store bit sequence in a string
		while(ip!=0)
		{
			if((ip & 1)!=0)
			{
				inputOne += "1";
			}
			else
			{
				inputOne += "0";
			}
			ip = ip >> 1;
		}
		int prevLength = 0;
		int maxLength = 0;
		int count =0;
		
		for(int i=0;i<inputOne.length();i++)
		{
			count = 0;
			// count sequences of 1's
			while((i < inputOne.length()) && inputOne.charAt(i)=='1')
			{
				count++;
				i++;
			}
			// If prevLength has been set, check if prevlength + count is greater than max.
			if(prevLength!=0 && maxLength < (count+prevLength+1))
			{
				maxLength = count+prevLength+1;
				prevLength = 0;
			}
			// If a single zero is encountered set count to prevLength and continue.
			if(((i+1) < inputOne.length()) && (inputOne.charAt(i)=='0') && (inputOne.charAt(i+1)=='1'))
			{
				prevLength = count;
			}
		}
		  System.out.println(maxLength);
	}
	/*
	public static void main(String[] args)
	{
		LongestSequence obj = new LongestSequence();
		obj.findSequence(1775);
	}
	*/
}
