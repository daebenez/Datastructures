package com.functional.DP;
/**
 * Program to find fibonacci number using bottom up approach.
 * @author daebenez
 */
public class Fibonacci_BottomUp {
	
	public int findFib(int input)
	{
		if(input==0)
		{
			return 0;
		}
		if(input==1)
		{
			return 1;
		}
		
		int a=0;
		int b=1;
		int fib;
		for(int i=2;i<input;i++)
		{
			fib = a+b;
			a = b;
			b = fib;
		}
		
		return a+b;
	}
	
	public static void main(String[] args)
	{
		Fibonacci_BottomUp obj = new Fibonacci_BottomUp();
		System.out.println(obj.findFib(10));
	}

}
