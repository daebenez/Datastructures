package com.functional.recursion;
/*
 * @author daebenez
 * Program to find GCD of a number using recursion
 * Euclidean formula - If the reminder of the higher number divided by the lower number is 0
 * the lower number is the GCD. If not recurively divide the lower number by the remainder.
 * Time complexity : O(log n) --> https://www.youtube.com/watch?v=7HCd074v8g8	 
 */
public class GCD {
	
	public static void main(String[] args)
	{
		findGCD(108,30);
	}
	
	public static void findGCD(int numOne, int numTwo)
	{
		if(numOne % numTwo == 0)
		{
			System.out.println("GCD is : "+ numTwo);
		}
		else
		{
			int remainder = numOne % numTwo;
			findGCD(numTwo, remainder);
		}
		
	}

}
