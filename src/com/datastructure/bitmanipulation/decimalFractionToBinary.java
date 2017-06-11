package com.datastructure.bitmanipulation;
/**
 * Q 5.2
 * Program to convert decimal fraction to binary. Input is between 1 and 0
 * @author daebenez
 * Time Complexity : O(N) -> Multiplied atmost 32 times. 
 */
public class decimalFractionToBinary {
	private String binary = ".";
	public void convertToBinary(float number,int count)
	{
		if(count > 31)
		{
			return; 
		}
		count++;
		float res = number * 2;
		if(res >= 1)
		{
			binary += "1";
			if(res-1 != 0)
			{
				convertToBinary(res-1, count);
			}
			else
			{
				return;
			}
		}
		else
		{
			binary += "0";
			
			if(res != 0)
			{
				convertToBinary(res, count);
			}
			else
			{
				return;
			}
		}
	}
	/*
	public static void main(String[] args)
	{
		decimalFractionToBinary obj = new decimalFractionToBinary();
		obj.convertToBinary(.7f, 0);
		System.out.println(obj.binary);
	} */
}
