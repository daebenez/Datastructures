package com.functional.recursion;

public class RodCutting {
	
	public int findMax(int[] value,int length)
	{
		if(length<=0)
		{
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<length;i++)
		{
			max = Math.max(max, value[i]+findMax(value,length-(i+1)));
		}
		
		return max;
	}
	
	public static void main(String[] args)
	{
		int[] value = {1,5,8,9,10,17};
		RodCutting obj = new RodCutting();
		
		System.out.println(obj.findMax(value, 4));
	}

}
