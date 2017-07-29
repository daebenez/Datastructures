package com.ctci.DynamicProgramming;

import java.util.HashSet;

/**
 * CTCI Q 8.9
 * Program to calculate all possible combinations of parenthesis.
 * @author daebenez
 * 
 */
public class ParenthesisCombination {
	
	public HashSet<String> findCombinations(int open,int close,String combos,HashSet<String> ans)
	{
		if(open==0 && close==0)
		{
			ans.add(combos);
			return ans;
		}
		else
		{
			if(open>0)
			{
				combos+="{";
				findCombinations(open-1, close+1, combos,ans);
			}
			if(close>0)
			{
				combos+="}";
				findCombinations(open, close-1, combos,ans);
			}
			return ans;
		}
	}
	
	
	public static void main(String[] args)
	{
		ParenthesisCombination obj = new ParenthesisCombination();
		HashSet<String> answers = new HashSet<String>();
		HashSet<String> res=obj.findCombinations(3, 0,"",answers);
		for(String s: res)
		{
			System.out.println(s);
		}
		
		
	}
	

}
