package com.ctci.DynamicProgramming;
/**
 * CTCI Q 8.5
 * Program to multiply 2 integers recursively without bit manipulation
 * @author daebenez
 * Time Complexity : O(log N) -> small gets divided into half repetitively.
 */
public class RecursiveMultiplication {
	
	public int multiply(int small,int big)
	{
		if(small<=0)
		{
			return 0;
		}
		if(small==1)
		{
			return big;
		}
		
		if((small%2)==0)
		{
			small = small>>1;
			return multiply(small, big+big);
		}
		else
		{
			small = small>>1;
			return big+multiply(small,big+big);
		}
	}
	/*
	public static void main(String[] args)
	{
		RecursiveMultiplication obj = new RecursiveMultiplication();
		System.out.println(obj.multiply(5, 23));
	}*/
}
