package com.ctci.DynamicProgramming;
/**
 * CTCI Q 8.4
 * Program to calculate powerset using recursion.
 * @author daebenez
 * Time Complexity : O(2^N) Uses backtracking and explores all possible combination.
 * Space Complexity : O(N)
 * for n numbers there are 2^n possible combinations.
 */
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Powerset {
	
	public void powerSet(char[] input,int[] count,int pos,char[] output,int len)
	{
		//print out combinations
		print(output,len);
		//pos is initially zero
		for(int i=pos;i<input.length;i++)
		{
			//if count of letter is zero skip
			if(count[i]==0)
			{
				continue;
			}
			output[len] = input[i];
			//decrement count after use
			count[i]--;
			//recursive call to powerset
			powerSet(input,count,i,output,len+1);
			count[i]++;
		}
	}
	
	private void print(char[] buffer, int lvl) {
		for(int i=0;i<lvl;i++)
		{
			System.out.print(buffer[i]+",");
		}
		System.out.println("--");
		
	}

	/*
	public static void main(String[] args)
	{
		char[] input = {'A','A','B','C','D'};
		int wordLength = input.length;
		
		TreeMap<Character,Integer> list = new TreeMap<Character,Integer>();
		
		for(char c: input)
		{
			list.compute(c, (key,val)-> {
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
		char[] alphabets = new char[list.size()];
		int[] count = new int[list.size()];
		int j = 0;
		for(Map.Entry<Character,Integer> entry : list.entrySet())
		{
			alphabets[j] = entry.getKey();
			count[j] = entry.getValue();
			j++;
		}
		char[] buffer = new char[wordLength];
		Powerset obj = new Powerset();
		obj.powerSet(alphabets, count,0, buffer,0);
	} */

}
