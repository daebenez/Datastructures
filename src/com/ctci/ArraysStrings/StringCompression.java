package com.ctci.ArraysStrings;
/**
 * @author daebenez
 * Compress a string using Run Length Encoding.
 * Linear scan through the string, compare current character with previous character,
 * If they are the same, increment character count else print character and count.
 * Time Complexity : O(n), we can through the string once.
 * Space Complexity : O(n).we use stringbuilder.
 */
public class StringCompression {
	
	public StringBuilder stringCompression(String input)
	{
		char currentChar = input.charAt(0);
		int charCount = 1;
		StringBuilder result = new StringBuilder();
		//Linear scan the string.
		for(int i=1;i<input.length();i++)
		{
			// If current character is the same as previous increment count.
			if(input.charAt(i) == input.charAt(i-1))
			{
				charCount++;
			}
			else
			{
				//append character and its count to result
				result.append(currentChar);
				result.append(charCount);
				currentChar = input.charAt(i);
				charCount = 1;
			}
		}
		// append last character and its count to result as it is never tracked.
		result.append(currentChar);
		result.append(charCount);
		return result;
	}
	/*
	public static void main(String[] args)
	{
		StringCompression obj = new StringCompression();
		System.out.println(obj.stringCompression("abc"));
		System.out.println(obj.stringCompression("aaabcccccc"));
		System.out.println(obj.stringCompression("aabc"));
		System.out.println(obj.stringCompression("abccc"));
		System.out.println(obj.stringCompression("abbbc"));
	} */
}
