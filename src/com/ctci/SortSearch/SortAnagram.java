package com.ctci.SortSearch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * CTCI Q 8.2
 * Program to sort an array of strings in such a way that anagrams are arranged together. 
 * @author daebenez
 * Time Complexity : M * N * log(N) -> Array.sort uses quick sort and costs NlogN time and we sort M strings from the array.
 * Space Complexity : O(N)
 */
public class SortAnagram {
	
	public String[] sort(String[] input)
	{
		HashMap<String,ArrayList<String>> list = new HashMap<String,ArrayList<String>>();
		for(String s:input)
		{
			char[] word = s.toCharArray();
			Arrays.sort(word);
			String sorted = new String(word);
			if(!list.containsKey(sorted))
			{
				ArrayList<String> newList = new ArrayList<String>();
				newList.add(s);
				list.put(sorted,newList);
			}
			else
			{
				ArrayList<String> oldList = list.get(sorted);
				oldList.add(s);
				list.put(sorted,oldList);
			}
		}
		
		int index = 0;
		String[] result = new String[input.length];
		for(Map.Entry<String, ArrayList<String>> entry : list.entrySet())
		{
			for(String r : entry.getValue())
			{
				result[index] = r;
				index++;
			}
		}
		return result;
	}
	
	/*
	public static void main(String[] args)
	{
		String[] input = {"cat","dog","tac","god","whatever"};
		SortAnagram obj = new SortAnagram();
		String[] res = obj.sort(input);
		System.out.println(Arrays.toString(res));
	} */

}
