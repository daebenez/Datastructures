package com.ctci.ArraysStrings;
/**
 * @author daebenez
 * Program to find if 2 strings differ by a single edit operation.
 * Edit operation can be either Insert, Delete or Replace.
 * Find if the string lengths are similar in which case it could be a replace operation
 * or if they differ by one in which case they could be an insert or delete operation.
 * Linear scan through the string to find if the difference in characters is at most one.
 * Time complexity : O(n) -> linear scan through the string.
 * Space Complexity : O(1)
 *
 */
public class StringEdit {
	
	public boolean findEdit(String one,String two)
	{
		
		int diff =0;
		int indexOne = 0, indexTwo = 0;
		// If lengths are equal check for replace. 
		if(one.length() == two.length())
		{
			for(int i=0;i<one.length();i++)
			{
				//track how many characters differ between the 2.
				if(one.charAt(i)!=two.charAt(i))
				{
					diff++;
				}
			}
			// check if difference is more than 1.
			if(diff < 2)
			{
				return true;
			}
		}
		// check if difference in lengths of 2 strings is just 1. Then its either insert or delete.
		else if((one.length() - two.length() == 1) || (two.length() - one.length() == 1))
		{
			// make one the longer string and two the shorter string if its not already so.
			if(two.length() - one.length() == 1)
			{
				String temp = one;
				one = two;
				two = temp;
			}
			while((indexOne < one.length()) && (indexTwo < two.length()))
			{
				// if chars are equal increement pointer.
				if(one.charAt(indexOne) == two.charAt(indexTwo))
				{
					indexOne++;
					indexTwo++;
				}
				// else increment only the pointer in the longer string.
				else
				{
					diff++;
					indexOne++;
				}
			}
			if(diff < 2)
			{
				return true;
			}
		}
		// the number of edits exceed one.Do nothing and let it retuen false.
		else
		{
			
		}
		return false;
	}
	/*
	public static void main(String[] args)
	{
		StringEdit obj = new StringEdit();
		System.out.println(obj.findEdit("pales", "pale"));
		System.out.println(obj.findEdit("pale", "bale"));
		System.out.println(obj.findEdit("pale", "ple"));
		System.out.println(obj.findEdit("pale", "bake"));
		System.out.println(obj.findEdit("pale", "palesy"));
	} */
}
