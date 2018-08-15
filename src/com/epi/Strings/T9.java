package com.epi.Strings;

import java.util.*;

public class T9 {
	private static final String[] code = {"0","1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
	
	public static List<String> find(String input)
	{
		char[] res = new char[input.length()];
		List<String> result = new ArrayList<String>();
		helper(input,res,result,0);
		return result;
	}
	
	private static void helper(String input,char[] currentMnemonic,List<String> result, int index)
	{
		if(index==input.length())
		{
			result.add(new String(currentMnemonic));
			return;
		}
		int ind = input.charAt(index)-'0';
		for(int i=0;i<code[ind].length();i++)
		{
			currentMnemonic[index] = (code[input.charAt(index)-'0'].charAt(i));
			helper(input,currentMnemonic,result,index+1);
		}
	}
	
	public static void main(String[] args)
	{
		String in = "23";
		List<String> r = find(in);
		for(String s : r)
		{
			System.out.println(s);
		}
	}

}
