package com.functional.recursion;
/*
 * @author daebenez
 * Program to find GCD of a number using recursion
 * Euclidean formula
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
