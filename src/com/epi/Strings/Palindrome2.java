package com.epi.Strings;

public class Palindrome2 {
	
	public static boolean isPalindrome(String input)
	{
		int start = 0,end = input.length()-1;
		while(start<end)
		{
			while(!Character.isLetterOrDigit(input.charAt(start)) && start<end)
			{
				start++;
			}
			while(!Character.isLetterOrDigit(input.charAt(end)) && start<end)
			{
				end--;
			}
			
			if(Character.toLowerCase(input.charAt(start))!=Character.toLowerCase(input.charAt(end)))
			{
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		String in = "a man, a plan, a canal, Panama";
		System.out.println(isPalindrome(in));
	}

}
