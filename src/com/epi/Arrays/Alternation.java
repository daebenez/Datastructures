package com.epi.Arrays;
import java.util.Arrays;
/**
 * Program to alternate items in an array such that a[0]<a[1]>a[2]...
 * @author daebenez
 * Compare and swap locally such that if number is even it should be lower than neighbours
 * if odd should be greater, if not swap.
 * Time :O(N), Space: O(1)
 *
 */
public class Alternation {
	
	public static int[] alternate(int[] input)
	{
		for(int i=1;i<input.length;i++)
		{
			if((i%2==0 && input[i]>input[i-1]) || (i%2==1 && input[i]<input[i-1]))
			{
				input[i-1] = input[i-1]^input[i];
				input[i] = input[i-1]^input[i];
				input[i-1] = input[i-1]^input[i];
			}
		}
		return input;
	}
	
	public static void main(String[] args)
	{
		int[] in = {3,1,10,11,7,2};
		System.out.println(Arrays.toString(alternate(in)));
	}

}
