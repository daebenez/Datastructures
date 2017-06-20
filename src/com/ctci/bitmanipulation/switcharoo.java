package com.ctci.bitmanipulation;
/**
 * Q 5.7
 * Program to switch even and odd positioned bits in an integer.
 * @author daebenez
 * Time Complexity : O(1)
 */
public class switcharoo {
	
	public int switchBits(int x)
	{
		// binary literal
		int oddMask = 0b10101010_10101010_10101010_10101010;
		int evenMask = 0b01010101_01010101_01010101_01010101;
		int odd = x &  oddMask;
		int even = x & evenMask;
		odd = odd >> 1;
		even = even << 1;
		return odd|even;
	}
	/*
	public static void main(String[] args)
	{
		switcharoo obj = new switcharoo();
		System.out.println(obj.switchBits(42));
	} */
}
