package com.epi.Arrays;

public class RotateMatrix {
	
	public static void rotate(int[][] matrix)
	{
		int N = matrix.length;
		for(int i=0;i<N/2;i++)
		{
			int temp = 0;
			for(int j=i;j<N-1-i;j++)
			{
				temp = matrix[i][j];
				matrix[i][j] = matrix[N-1-j][i];
				matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
				matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
				matrix[j][N-1-i] = temp;
			}
		}
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(matrix[i][j]+",");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		int input[][]={{1,2,3},{4,5,6},{7,8,9}};
		rotate(input);
	}

}
