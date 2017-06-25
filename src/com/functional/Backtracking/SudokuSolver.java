package com.functional.Backtracking;
/**
 * Program to solve Sudoku using backtracking.
 * Reference -> https://www.youtube.com/watch?v=P9_F7kuHU90
 * Time complexity : O(N*M) where N is the number of possible solution (1 to 4) and m is the number of blanks
 * Answer is printed in the console,zeros represent blanks, while all answer generated for every blank position by this program are correct, 
 * for the given example the indexes for grid[2][0] seem to have been reversed when printing.
 */
import java.util.Arrays;

public class SudokuSolver {
	
	public int[][] solve(int[][] grid,int i,int j)
	{
		// check if current square is valid
		if((grid[i][j]!=0)&&(!isSquareValid(grid,i,j)))
		{
			grid[i][j]=0;
			return grid;
		}
		
		//If last square is reached return.
		if(i==3 && j==3)
		{
			System.out.println("i="+i+",j="+j+",value="+grid[i][j]);
			return grid;
		}
		
		System.out.println("i="+i+",j="+j+",value="+grid[i][j]);
		
		//If current square is valid and is not the last square, move on to the next square
		int[] indexs = findNext(grid,i,j);
		//If there are no next valid squares
		if(indexs[0]==i && indexs[1]==j)
		{
			return grid;
		}
		else
		{
			i = indexs[0];
			j = indexs[1];
		}
		
		for(int k=1;k<5;k++)
		{
			grid[i][j] = k;
			solve(grid, i, j);
		}
		
		return grid;
	}
	
	/**
	 * Method to find next valid blank.
	 * @param grid
	 * @param i current row index
	 * @param j current col index
	 * @return row & col indexes of the next available blank or the same indexes to denote no available blanks.
	 */
	private int[] findNext(int[][] grid, int i, int j) {
		int[] indexs = new int[2];
		indexs[0]=i;
		indexs[1]=j;
		while((i<=3) && (j<=3) && (grid[i][j]!=0))
		{
			if(i<=3 && j==3)
			{
				i++;
				j=0;
			}
			else if(i<=3 && j<=3)
			{
				j++;
			}
		}
		if(i>3)
		{
			return indexs;
		}
		else
		{
			indexs[0]=i;
			indexs[1]=j;
		}
		
		
		return indexs;
	}

	/**
	 * Program to check if the current number is a valid value.
	 * @param grid
	 * @param i
	 * @param j
	 * @return true or false
	 */
	private boolean isSquareValid(int[][] grid, int i, int j) {
		//Is the same number present in the column or row
		if(isUsedInLine(grid,i,j))
		{
			return false;
		}
		//Is it present in the box
		else if(isUsedInBox(grid,i,j))
		{
			return false;
		}
		return true;
	}

	/**
	 * Program to check if current value is used anywhere inside the 2X2 box.
	 * @param grid
	 * @param i
	 * @param j
	 * @return true if the value is present inside its 2X2 box, false if not.
	 */
	private boolean isUsedInBox(int[][] grid, int i, int j) {
		int count = 0;
		int xstart = 0;
		int ystart = 0;
		if(i>=2)
		{
			xstart = 2; 
		}
		if(j>=2)
		{
			ystart = 2;
		}
		
		for(int q=xstart;q<xstart+2;q++)
		{
			
			for(int w=ystart;w<ystart+2;w++)
			{
				
				if(grid[q][w]==grid[i][j])
				{
					count++;
				}
			}
		}
		
		if(count > 1)
		{
			return true;
		}
		
		return false;
	}

	/**
	 * Program to check if the value is repeated along the row or column
	 * @param grid
	 * @param i
	 * @param j
	 * @return true or false.
	 */
	private boolean isUsedInLine(int[][] grid, int i, int j) {
		int count = 0;
		//check horizontal
		for(int q=0;q<4;q++)
		{
			if(grid[i][q]==grid[i][j])
			{
				count++;
			}
		}
		if(count > 1)
		{
			return true;
		}
		int countt = 0;
		//check vertical
		for(int w=0;w<4;w++)
		{
			if(grid[w][j]==grid[i][j])
			{
				countt++;
			}
		}
		if(countt > 1)
		{
			return true;
		}
		return false;
	}

	/*
	public static void main(String[] args)
	{
		SudokuSolver obj = new SudokuSolver();
		int[][] grid = {
				{4,1,2,3},
				{2,0,4,0},
				{3,0,0,4},
				{1,4,3,0},
	};
		int[][] result = obj.solve(grid, 0, 0);
	} */

}
