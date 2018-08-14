package com.epi.Strings;

public class ReplaceAB {
	
	public static char[] replace(char[] input)
	{
		int write = 1;
		for(int i=1;i<input.length;i++)
		{
			if(input[i]!='b')
			{
				input[write] = input[i];
				write++;
			}
		}
		int write2 = input.length-1;
		for(int i=(write-1);i>=0;i--)
		{
			if(input[i]=='a')
			{
				input[write2] = 'd';
				input[write2-1] = 'd';
				write2--;
				write2--;
			}
			else
			{
				input[write2] = input[i];
				write2--;
			}
		}
		
		return input;
	}
	
	public static void main(String[] args)
	{
		char[] in = {'a','c','d','b','b','c','a'};
		System.out.println(replace(in));
		char[] in2 = {'a','b','a','c','b'};
		System.out.println(replace(in2));
	}

}
