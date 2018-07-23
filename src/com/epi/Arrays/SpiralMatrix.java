package com.epi.Arrays;
import java.util.*;
/**
 * Program to  trace spiral matrix in a 2D array.
 * Time: O(N), Space: O(1)
 * @author daebenez
 *
 */
public class SpiralMatrix {
	
	public static void spiral(int[][] matrix)
	{
		int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length-1;
		ArrayList<Integer> lst = new ArrayList<Integer>();
		
		while(top<=bottom && left<=right)
		{
			for(int j=left;j<=right;j++)
			{
				lst.add(matrix[top][j]);
			}
			top++;
			
			for(int i=top;i<=bottom;i++)
			{
				lst.add(matrix[i][right]);
			}
			right--;
			
			for(int j=right;j>=left;j--)
			{
				lst.add(matrix[bottom][j]);
			}
			bottom--;
			
			for(int i=bottom;i>=top;i--)
			{
				lst.add(matrix[i][left]);
			}
			left++;
		}
		
		for(int i=0;i<lst.size();i++)
		{
			System.out.println(lst.get(i));
		}
		
	}
	
	public static void main(String[] args)
	{
		int input[][]={{50,60,55},{62,65,70},{72,66,77}, {80,81,82}};
		spiral(input);
	}

}
