package com.epi.Arrays;

import java.util.Arrays;

/**
 * Count prime upto n. Sieve method.
 * Time: O(log log n). Space: O(N)
 * @author daebenez
 *
 */
public class Primes {
	public static int countPrimes(int n)
	{
		boolean[] sieve = new boolean[n+1];
		for(int i=2;i<=n;i++)
		{
			sieve[i] = true; 
		}
		for(int i=2;i<=n;i++)
		{
			for(int j=2;j*i<=n;j++)
			{
				int index = i*j;
				System.out.println(index+""+i+""+j);
				sieve[index] = false;
			}
		}
		System.out.println(Arrays.toString(sieve));
		int count =0;
		for(int i=0;i<=n;i++)
		{
			if(sieve[i]==true) count++;
		}
		
		return count;
	}
	
	public static void main(String[] args)
	{
		Primes obj = new Primes();
		System.out.println(obj.countPrimes(9));
	}

}
