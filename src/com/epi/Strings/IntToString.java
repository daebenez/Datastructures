package com.epi.Strings;

public class IntToString {
	
	public static String intToString(int n)
	{
		StringBuilder result = new StringBuilder();
		boolean sign = (n<0)? true:false;
		if(sign) n = n*(-1);
		while(n>0)
		{
			//watch out for conversion issues
			result.append((char)('0'+n%10));
			n/=10;
		}
		if(sign)
		{
			result.append("-");
		}
		result.reverse();
		return result.toString();
	}
	
	public static int atoi(String input)
	{
		int result = 0;
		for(int i=(input.charAt(0)=='-')? 1:0;i<input.length();i++)
		{
			// The difference between ascii values is the number
			int digit = input.charAt(i) - '0';
			result = (result*10)+digit; 
		}
		result = (input.charAt(0)=='-')? result*-1 : result;
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(intToString(-1234));
		System.out.println(atoi("-1234"));
	}

}
