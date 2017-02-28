package com.ctci.Arrays&Strings
/**
 * @author daebenez
 * Reverse a string inplace.
 * Time complexity -> O(n) Algorithm iterates through the string n/2 times which is still n.
 * Space complexity ->  O(1) since we only use an extra swap integer.
 */

class Reverse {
	/* String is mutable so when it is changed, internally it creates a new String object
	 * leading to space inefficiency.StringBuilder is a mutable object. 
	 */
	public void reverseString(StringBuilder input)
	{
	  if(input.equals(null) || input.equals(""))
	  {
	    System.out.println("Empty or null string");
	  }
	  else {
		int len = input.length();
	    // iterate through the string swapping first and last character and so on.  
	    for(int i=0;i<len/2;i++)
	    {
	      char temp = input.charAt(i);
	      input.setCharAt(i, input.charAt((len-1)-i));
	      input.setCharAt((len-1)-i,temp);
	    }
	 }
	  System.out.println(input);
	}
	/*
	public static void main(String[] args)
	{
	  Reverse rv = new Reverse();
	  StringBuilder o = new StringBuilder("Howdy");
	  rv.reverseString(o);
	}
	*/
}
	   
