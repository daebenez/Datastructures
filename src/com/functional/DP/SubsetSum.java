package com.functional.DP;
/**
 * Program to find if a subset sums to a given total. 
 * Dynamic bottom up programming
 * @author daebenez 
 */
public class SubsetSum {
	
	public boolean subsetSum(int[] input,int sum)
	{
		boolean[][] solutionMatrix = new boolean[input.length][sum+1];
		//fill first columns with trues
		for(int ii=0;ii<input.length;ii++)
		{
			solutionMatrix[ii][0] = true;
		}
		//fill first row with appropriate results
		for(int jj=0;jj<=sum;jj++)
		{
			if(jj==input[0])
			{
				solutionMatrix[0][jj] =  true;
			}
		}
		
		//fill the table using the formula if the cell at the top or the 1 array[i] places to the left is true set this to true.
		for(int i=1;i<input.length;i++)
		{
			for(int j=1;j<=sum;j++)
			{
				if(input[i]>j)
				{
					solutionMatrix[i][j]=solutionMatrix[i-1][j];
				}
				else if(input[i]==j)
				{
					solutionMatrix[i][j]=true;
				}
				else if(solutionMatrix[i-1][j]==true)
				{
					solutionMatrix[i][j]=true;
				}
				else
				{
					if(solutionMatrix[i-1][j-input[i]]==true)
					{
						solutionMatrix[i][j]=true;
					}
				}
			}
		}
		return solutionMatrix[input.length-1][sum];
	}
	/*
	public static void main(String[] args)
	{
		int[] input = {2,3,4,5,12,34};
		SubsetSum obj = new SubsetSum();
		System.out.println(obj.subsetSum(input, 9));
	} */

}
