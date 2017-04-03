package com.ctci.ArraysStrings;
/**
 * @author daebenez
 * Find if a string is a permutation of the other.
 * Count the occurrence of each letter in both strings and return true if they are equal.
 * Time complexity : O(n) because of linear iteration through each string.
 * Space Complexity : O(n) because of the use of the extra arrays.
 * 
 */
import java.util.Arrays;

public class Permutation {
	
	public boolean permutation(String one,String two)
	{
		//use 2 arrays to track count of each letter
		int[] firstCount = new int[26];
		int[] secondCount = new int[26];
		// Handle case by changing both to lowercase.
		one = one.toLowerCase();
		two = two.toLowerCase();
		
		for(int i=0;i<one.length();i++)
		{
		  // Check if each character is a valid letter. space is not a valid letter.
		  if(!Character.isLetter(one.charAt(i)))
		  {
			  System.out.println("All inputs should be a character from the English alphabet");
			  return false;
		  }
		  // find the position of the letter and use it as array index.
		  int index = one.charAt(i) - 'a';
		  firstCount[index] += 1;
		}
		
		for(int j=0;j<one.length();j++)
		{
		  if(!Character.isLetter(two.charAt(j)))
		  {
			System.out.println("All inputs should be a character from the English alphabet");
			return false;
		  }
			
		  int indexTwo = two.charAt(j) - 'a';
		  secondCount[indexTwo] += 1;
		}
		if(Arrays.equals(firstCount, secondCount))
		{
			return true;
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		Permutation p = new Permutation();
		System.out.println(p.permutation("dog  ", "god"));
		System.out.println(p.permutation("Listen", "Silent"));
		System.out.println(p.permutation("tringle", "integral"));
	}

}
