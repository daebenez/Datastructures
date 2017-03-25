package com.ctci.ArraysStrings;
/**
 * @author daebenez
 * Find and remove duplicate characters from a string.
 * Iterate through the string setting a value in the character array to 't' for every
 * character encountered.If the value is already set, the encountered character is duplicate.
 * Use the character's position as index for the array (for example a=0, z=25)
 * Time complexity ->  O(n) since we iterate through the string once and replaceAll() takes linear time.
 * Space Complexity -> O(n) since we use a character array.
 */

public class RemoveDuplicates {
	
	public void duplicates(StringBuilder input)
	{
	  // Char array to be tracked for duplicates
	  char[] store = new char[27];
	  for(int i=0;i<input.length();i++)
	  {
		  int index = Character.toLowerCase(input.charAt(i)) - 'a';
		  // check if value at an array index is empty.
		  if(store[index] == '\u0000')
		  {
			  store[index] = 't';
		  }
		  // If duplicate remove character
		  else if(store[index] == 't')
		  {
			   input.setCharAt(i, ' ');  
		  }
	  }
	  // remove spaces.
	  System.out.println(input.toString().replaceAll(" ", ""));
	}
	
	/*
	public static void main(String[] args)
	{
		RemoveDuplicates rd = new RemoveDuplicates();
		StringBuilder in = new StringBuilder("MyTrrrripoookjhtr");
		rd.duplicates(in);
	}
	*/
}

