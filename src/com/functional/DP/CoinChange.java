package com.functional.DP;
/**
 * Program to calculate the minimum number of coins required to get to an amount using DP.
 * @author daebenez
 * Time Complexity : O(N*N)
 * Space Complexity : O(N*N)
 */
public class CoinChange {
	
	public int findMinChange(int amount,int[] coins)
	{
		int[][] changeMatrix = new int[coins.length+1][amount+1];
		//fill the first row
		for(int z=1;z<amount+1;z++)
		{
			changeMatrix[0][z] = changeMatrix[0][z-1] + 1;
		}
		//Fill in the other rows
		for(int i=1;i<coins.length+1;i++)
		{
			for(int j=1;j<amount+1;j++)
			{
				if(i>j)
				{
					changeMatrix[i][j]=changeMatrix[i-1][j];
				}
				else
				{
					int temp = changeMatrix[i][j-i]+1;
					if(changeMatrix[i-1][j]<temp)
					{
						changeMatrix[i][j]=changeMatrix[i-1][j];
					}
					else
					{
						changeMatrix[i][j]=changeMatrix[i][j-i]+1;
					}
				}
				
			}
		}
		//return last element of the matrix which is the solution
		return changeMatrix[coins.length-1][amount-1];
	}
	
	/*
	public static void main(String[] args)
	{
		CoinChange obj = new CoinChange();
		int[] coins = {1,2,3};
		System.out.println(obj.findMinChange(5, coins));
	} */

}
