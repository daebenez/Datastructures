package com.epi.Arrays;

public class PascalsTriangle {
	
	public static void pascal(int n)
	{
		int[][] matrix = new int[n+2][n+2];
		matrix[1][0] = 1; 
		for(int i=2;i<=n;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(j==0)
				{
					matrix[i][j] = matrix[i-1][j];
				}
				else
				{
					matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j];
				}
			}
		}
		
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=n;j++)
			{
				System.out.print(matrix[i][j]+",");
			}
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		pascal(5);
	}

}
