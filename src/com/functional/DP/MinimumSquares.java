package com.functional.DP;
/**
 * Program to calculate the minimum number of squares required to sum to a given number.
 * @author daebenez
 */
public class MinimumSquares {
	
	public int findMin(int input)
	{
		int sqrt = (int)Math.sqrt(input);
		int[][] solution = new int[sqrt+1][input+1];
		
		for(int i=1;i<input+1;i++)
		{
			solution[1][i] = i;
		}
		
		for(int i=0;i<=sqrt;i++)
		{
			solution[i][0] = 0;
		}
		
		for(int i=2;i<=sqrt;i++)
		{
			for(int j=0;j<input+1;j++)
			{
				int sqr = i*i;
				if(j==sqr)
				{
					solution[i][j] = 1;
				}
				else if(j<sqr)
				{
					solution[i][j] = solution[i-1][j];
				}
				else
				{
					if((solution[i][j-sqr]+1) < solution[i-1][j])
					{
						solution[i][j] = (solution[i][j-sqr]+1);
					}
					else
					{
						solution[i][j] = solution[i-1][j];
					}
				}
			}
		}
		
		return solution[sqrt][input];
	}
	/*
	public static void main(String[] args)
	{
		MinimumSquares obj = new MinimumSquares();
		System.out.println(obj.findMin(9));
	}	*/
}
