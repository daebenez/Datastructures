package com.epi.Strings;

public class ColumnEncoding {
	
	public static int encodeColumn(final String input)
	{
		int result = 0;
		for(int i=0;i<input.length();i++)
		{
			result = result * 26 + input.charAt(i) - 'A' + 1;
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(encodeColumn("ZZ"));
	}

}
