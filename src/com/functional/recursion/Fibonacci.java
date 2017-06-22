package com.functional.recursion;
/**
 * Program to calculate fibonacci solution.
 * @author daebenez
 */
public class Fibonacci {
	
	public int findFib(int fibNo)
	{
		if(fibNo==0)
		{
			return 0;
		}
		if(fibNo==1)
		{
			return 1;
		}
		
		return findFib(fibNo-1)+findFib(fibNo-2);
	}
	/*
	public static void main(String[] args)
	{
		Fibonacci obj = new Fibonacci();
		System.out.println(obj.findFib(40));
	} */

}
