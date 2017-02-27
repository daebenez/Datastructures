package com.ctci.Arrays&Strings
/**
 * @author daebenez
 * Find if every character in the string is unique, without using any other datastructure.
 * Iterate through the string and set each bit corresponding to a letter in the alphabet
 * to 1, if the bit is already set to 1 then there is a repetition.
 * Time complexity -> O(n) Algorithm iterates through the string once.
 * Space complexity ->  O(1) since we only use an extra integer.
 */

public class Unique {

	public boolean checkUnique(String input)
	{
		// Each bit in this integer corresponds to a letter of the alphabet.
		int checkpos = 0;
		if(input.equals(null) || input.equals(""))
		{
			return false;
		}
		else
		{
			/* 
			 * Iterate through each character in the string. 
			 * if the bit in the position is 1 there are duplicates
			 * else set the bit.
			 */
			for(int i=0;i<input.length();i++)
			{
				// letter - a would subtract ASCII value of the letter and a.
				int val = input.charAt(i) - 'a';
				// Use bit mask to check if the bit at the position is set.
				if(((1 << val) & checkpos) != 0)
				{
					return false;
				}
				else
				{
					// If the bit is not set, set it using the OR operator.
					checkpos = checkpos | (1 << val);
				}
			}
		}
		return true;
	}
	/*
	public static void main(String[] args)
	{
		Unique m = new Unique();
		System.out.println(m.checkUnique(""));
	}
	*/
}

