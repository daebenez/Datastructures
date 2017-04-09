package com.ctci.ArraysStrings;
/**
 * @author daebenez
 * Program to rotate a matrix 90 degrees.
 * Take transpose and then switch the row indexes backwards.
 * Time complexity : O(n^2) -> because weiterate through every element in the matrix atleast once.
 * Space Complexity : O(n) -> Extra arrays we use for storing transpose and the result.
 */
import java.util.Arrays;

public class Matrix90 {
	
	public int[][] rotateMatrix(int[][] input)
	{
		int[][] transpose = new int[input.length][input.length];
		int[][] result = new int[input.length][input.length];
		
		//Transpose of the matrix. switch row and column indices.
		for(int i=0;i<input.length;i++)
		{
			for(int j=0;j<input.length;j++)
			{
				transpose[i][j] = input[j][i];
			}
		}
		// Rotate 90 degrees by switching the row indices.
		for(int x=0;x<input.length;x++)
		{
			for(int y=0;y<input.length;y++)
			{
				result[x][y] = transpose[(input.length-1)-x][y];
			}
		}
		return result;
	}
	/*
	public static void main(String[] args)
	{
		Matrix90 obj = new Matrix90();
		int[][] input = {{100,101,102},
						 {110,111,112},
						 {120,121,122}};
		int[][] result = obj.rotateMatrix(input);
		System.out.println(Arrays.deepToString(result));
	} */
}
