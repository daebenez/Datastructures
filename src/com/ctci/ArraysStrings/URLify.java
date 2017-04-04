package com.ctci.ArraysStrings;
/**
 * @author daebenez
 * Program to insert %20 everytime a empty space is encountered in a string.
 * we assume input to be a character array with space at the back and the number of characters in input string.
 * Time : O(n) -> we iterate through the character array in linear fashion twice separately.
 * Space : O(1) -> since we do this in place.
 */
import java.util.Arrays;

public class URLify {
	
	public char[] convertToURL(char[] input,int size)
	{
		int count =0;
		int tracker = 0;
		// linear scan to count the number of spaces in first pass.
		for(int i=0;i<size;i++)
		{
			if(input[i]==' ')
			{
				count++;
			}
		}
		// pointer to track the current position when we fill from last in the array.
		tracker = size+(count * 2);
		// linear scan and fill every empty space with a %20.
		for(int j=size;j>-1;j--)
		{
			//if char encountered is a space replace with %20 otherwise move it to the right pos.
			if(input[j]==' ')
			{
				input[tracker] = '0';
				tracker = tracker - 1;
				input[tracker] = '2';
				tracker = tracker - 1;
				input[tracker] = '%';
				tracker = tracker - 1;
			}else
			{
				input[tracker] = input[j];
				tracker = tracker - 1;
			}
		}
		return input;
	}
	/*
	public static void main(String[] args)
	{
		URLify obj = new URLify();
		char[] input={'m','r',' ','j','o','h','n',' ','s','m','i','t','h','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000'};
		char[] result = obj.convertToURL(input, 13);
		System.out.println(Arrays.toString(result));
	} */

}
