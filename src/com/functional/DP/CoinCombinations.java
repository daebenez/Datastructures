package com.functional.DP;
/**
 * Program to calculate the number of ways an amount can be reached with a change of coins.
 * @author daebenez
 */
public class CoinCombinations {
	
	public int combinations(int[] coins,int amount)
	{
		int[][] matrix = new int[coins.length+1][amount+1];
		
		for(int i=0;i<amount+1;i++)
		{
			matrix[0][i] = 0;
		}
		
		for(int i=0;i<amount+1;i++)
		{
			matrix[1][i] = 1;
		}
		
		for(int i=0;i<coins.length+1;i++)
		{
			matrix[i][0] = 1;
		}
		
		for(int i=2;i<coins.length+1;i++)
		{
			for(int j=1;j<amount+1;j++)
			{
				if(i==j)
				{
					matrix[i][j] = j;
				}
				else if(i>j)
				{
					matrix[i][j] = matrix[i-1][j];
				}
				else
				{
					matrix[i][j] = matrix[i][j-i] + matrix[i-1][j];
				}
				
			}
		}
		
		return matrix[coins.length][amount];
	}
	/*
	public static void main(String[] args)
	{
		CoinCombinations obj = new CoinCombinations();
		int[] coins = {1,2,3};
		System.out.println(obj.combinations(coins, 5));
	} */
}
