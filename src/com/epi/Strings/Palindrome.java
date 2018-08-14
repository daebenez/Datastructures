package com.epi.Strings;

public class Palindrome {
	
	public static boolean findPalindrome(String input)
	{
		for(int i=0,j=input.length()-1;i<j;i++,j--)
		{
			if(input.charAt(i)!=input.charAt(j)) return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println(findPalindrome("malayilam"));;
	}
	
}
