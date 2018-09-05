package com.epi.Heap;

import java.util.*;

public class IncreasingDecreasing {
	
	public static List<List<Integer>> generate(List<Integer> input)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		boolean increasing = true;
		int i = 0;
		int startIndex = 0;
		while(input.get(i)<input.size())
		{
			if((increasing && input.get(i-1)<input.get(i)) || (!increasing && input.get(i-1)>input.get(i)))
			{
				List<Integer> sb = input.subList(startIndex,i);
				startIndex = i;
				if(!increasing)
				{
					Collections.reverse(sb);
				}
				result.add(sb);
				increasing = (increasing)? false: true; 
			}
			i++;
		}
		return result;
	}
}
