package com.ctci.DynamicProgramming;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
/**
 * Program to calculate print all string permutations with or wthout duplicates
 * CTCI Q 8.7 Q 8.8
 * @author daebenez
 * Number of combinations = n! / m! where m is the number of times a char is repeated
 */

public class Combinations {
	
	public void permutation(char[] input)
	{
		// Use a treemap to get each character with its count in sorted order
		TreeMap<Character,Integer> count = new TreeMap<Character,Integer>();
		for(char c:input)
		{
			count.compute(c, (key,val)->{
				if(val==null)
				{
					return 1;
				}
				else
				{
					return val+1;
				}
			});
		}
		//transfer the charcters and counts to array.
		char[] letters = new char[count.size()];
		int[] times = new int[count.size()];
		int z = 0;
		for(Map.Entry<Character,Integer> entry:count.entrySet())
		{
			letters[z] = entry.getKey();
			times[z] = entry.getValue();
			z++;
		}
		char[] result = new char[input.length];
		permUtil(letters, times,result,input.length,0);
	}
	
	public void permUtil(char[] letters,int[] times,char[] result,int maxSize,int lvl)
	{
		if(lvl==maxSize)
		{
			System.out.println(result);
			
			return;
		}
		
		for(int i=0;i<letters.length;i++)
		{
			if(times[i]==0)
			{
				continue;
			}
			result[lvl]=letters[i];
			times[i]--;
			permUtil(letters, times, result, maxSize,lvl+1);
			times[i]++;
		}
	}
	
	public static void main(String[] args)
	{
		Combinations obj = new Combinations();
		char[] input = {'A','B','A','C'};
		obj.permutation(input);
	}
}
