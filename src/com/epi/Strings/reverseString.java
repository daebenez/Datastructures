package com.epi.Strings;

public class reverseString {
	
	public static char[] reverse(char[] words)
	{
		words = helper(words,0,words.length-1);
		int start = 0, end = 0;
		while(start<words.length)
		{
			while(start<end || start<words.length && words[start]==' ')
			{
				start++;
			}
			while(end<start || end<words.length && words[end]!=' ')
			{
				end++;
			}
			words = helper(words,start,end-1);
		}
		return words;
		
	}
	
	public static char[] helper(char[] words,int start,int end)
	{
		while(start<end)
		{
			char tmp = words[start];
			words[start] = words[end];
			words[end] = tmp;
			start++;
			end--;
		}
		return words;
	}
	
	
	public static void main(String[] args)
	{
		char[] in = {'B','o','b',' ','l','i','k','e','s',' ','p','i','z','z','a'};
		System.out.println(reverse(in));
	}

}
