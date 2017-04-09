package com.ctci.ArraysStrings;
/**
 * @author daebenez
 * Program to check if an item at an index of a matrix is zero and convert the row
 * and column associated with that position to zero.
 * Use 2 arrays for keeping track if a row or column needs to be set to zero and 
 * iterate through the matrix setting the appropriate index in the 2 arrays.
 * Time Complexity : O(n^2) -> because we iterate through each element in the array atleast once.
 * Space Complexity : O(n) -> because we use arrays to track indexes.
 */
import java.util.Arrays;

public class MatrixZero {
	
	public int[][] convertMatrix(int[][] input)
	{
		int rowLength = input.length;
		int colLength = input[0].length;
		int[] row = new int[rowLength];
		int[] col = new int[colLength];
		// Iterate through every element in the matrix, if zero set the corresponding index in the row and column array to 1.
		for(int i=0;i<rowLength;i++)
		{
			for(int j=0;j<colLength;j++)
			{
				if(input[i][j] == 0)
				{
					if(row[i]==0)
					{
						row[i]+=1;
					}
					if(col[j]==0)
					{
						col[j]+=1;
					}
				}
			}
		}
		// Iterate through the input matrix and set the element to zero if either the corresponding element in the row or column array is zero.
		for(int x=0;x<rowLength;x++)
		{
			for(int y=0;y<colLength;y++)
			{
				if((row[x]==1) || (col[y]==1))
				{
					input[x][y] = 0;
				}
			}
		}
		return input;
	}
	/*
	public static void main(String[] args)
	{
		MatrixZero obj = new MatrixZero();
		int[][] input = {{100,101,102},
						 {110,111,0},
						 {120,121,122}};
		int[][] result = obj.convertMatrix(input);
		System.out.println(Arrays.deepToString(result));
	} */
}
