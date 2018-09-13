package com.epi.Arrays;

public class LookSeeNumbers {
	
	public static String numbers(int n)
	{
		String[] result = new String[n];
		result[0] = "1";
		for(int i=0;i<n-1;i++)
		{
			result[i+1] = helper(result[i]);
		}
		return result[n-1];
	}
	
	private static String helper(String prev)
	{
		StringBuilder result = new StringBuilder();
		for(int i=0;i<prev.length();i++)
		{
			int count= 1;
			while(i+1<prev.length() && prev.charAt(i)==prev.charAt(i+1))
			{
				count++;
				i++;
			}
			result.append(count);
			result.append(prev.charAt(i));
		}
		return result.toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(numbers(8));
	}

}
