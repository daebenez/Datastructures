package com.functional.recursion;
/*
 * @author daebenez
 * Program to find a to the power n using recursion.
 * Divide n by 2 which effectively divides the problem by 2 everytime.
 * save the calculated value so it can be retrieved when necessary.
 * Time complexity : O(log n) 
 * space complexity : O(1)
 */
class Power{
	
	public int powerOf(int a,int n)
	{
		if(n==0)
		{
			return 1;
		}
		// save the value so it doesn't have to be recalculated.
		int x = powerOf(a,n/2);
		// check if n is even or odd.
		if((n&1)==0)
		{
			return x*x;
		}
		else
		{
			return a*x*x;
		}
	}
	/*
	public static void main(String[] args)
	{
		Power p = new Power();
		System.out.println(p.powerOf(2,4));
		System.out.println(p.powerOf(3,7));
	}*/
}