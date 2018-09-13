package com.epi.Recursion;
import java.util.*;
public class Permutation {
	
	static List<String> result = new ArrayList<>();
	public static void permutate(String input,int[] count, StringBuilder curr,int n)
	{
		if(curr.length()==n)
		{
			result.add(curr.toString());
			return;
		}
		for(int i=0;i<input.length();i++)
		{
			if(count[i]==0) continue;
			curr.append(input.charAt(i));
			count[i] = count[i]-1;
			permutate(input, count, curr,n);
			curr.deleteCharAt(curr.length() - 1); 
			count[i] = count[i] + 1;
		}
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1,1,1};
		permutate("ABC",arr,new StringBuilder(),3);
		System.out.println(result.size());
		for(String h : result)
		{
			System.out.println(h);
		}
	}

}
