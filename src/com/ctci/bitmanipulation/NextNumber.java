package com.ctci.bitmanipulation;
/**
 * Q 5.4
 * Program to find next greatest number using bit manipulation.
 * @author daebenez
 * Time Complexity :
 */
public class NextNumber {
	
	public void getNext(int n)
	{
		int zeroSequence = 0;
		int oneSequence = 0;
		int q = 0;
		int count = 0;
		int tempN = n;
		// find where the sequences of zeros end
		while((tempN & 1) == 0 && tempN != 0)
		{
			count++;
			tempN = tempN>>1;
		}
		zeroSequence = count;
		// find where the sequences of ones end
		while((tempN & 1) != 0 && tempN != 0)
		{
			count++;
			tempN = tempN>>1;
		}
		oneSequence = count-1;
		// set q as the number just after the end of 1 sequence
		q = oneSequence+1;
		//flip q bit to 1
		int mask = 1 << oneSequence+1;
		n = n | mask;
		//clear all bits after q
		int allOnes = ~0;
		allOnes = allOnes << q;
		n = n & allOnes;
		//set 1s 
		int maskTwo = ~0;
		maskTwo = maskTwo << oneSequence-2;
		maskTwo = ~maskTwo;
		n = n | maskTwo; 
		System.out.println(n);
	}
	/*
	public static void main(String[] args)
	{
		NextNumber obj = new NextNumber();
		obj.getNext(13948);
	} */

}
