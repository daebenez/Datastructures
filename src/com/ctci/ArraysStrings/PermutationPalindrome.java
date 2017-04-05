package com.ctci.ArraysStrings;
/**
 * @author daebenez.
 * Program to check if a string is a permutation of a palindrome.
 * Count the occurrence of each letter, each letter should occur twice if the number of 
 * letters in the input are even ex : tacoocat or atmost one letter can occur once ex : tacocat
 * Time Complexity : O(n) -> we iterate through each character of a string once
 * Space Complexity : O(1) -> we use a couple of bit vextors (integers) for keeping track of counts.
 *
 */
public class PermutationPalindrome {
	
	public boolean isPermpal(String input)
	{
		int countOnes = 0;
		int countOfLetters = 0;
		// convert string to lowercase and eliminate space.
		input.toLowerCase();
		input.replaceAll("\\s", "");
		// for each letter find its relative index (b=1) and flip the bit in that position.
		for(int i=0;i<input.length();i++)
		{
			int index = input.charAt(i) - 'a';
			//if the bit at that position is 0 flip it to 1 else to 0.
			if((countOfLetters & (1 << index)) == 0)
			{
				countOfLetters = countOfLetters | (1 << index);
			}
			else
			{
				countOfLetters = countOfLetters ^ (1 << index);
			}
			
		}
		// If the number of 1's in the binary is greater than 1 then there are atleast 2 letters that occur odd number of times.
		while(countOfLetters > 0)
		{
			if((countOfLetters & 1) == 1)
			{
				countOnes += 1;
			}
			countOfLetters = countOfLetters >> 1;
		}
	
		if(countOnes > 1)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	/*
	public static void main(String[] args)
	{
		PermutationPalindrome ob = new PermutationPalindrome();
		System.out.println(ob.isPermpal("peeP"));
		System.out.println(ob.isPermpal("pope"));
		System.out.println(ob.isPermpal("tact Coa"));
	} */

}
