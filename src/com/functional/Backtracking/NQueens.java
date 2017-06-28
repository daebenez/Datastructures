package com.functional.Backtracking;
/**
 * Program to solve the N Queens problem.
 * Time Complexity : O(N*M) N is the number of blank squares, M is either true or false (Queen present or not)
 * Gets the correct answer (first line) but seems to print garbage after. 
 */
import java.util.Arrays;
public class NQueens {
	
	public void placeQueens(boolean[][] grid,int x,int y,int queenCount,StringBuilder position)
	{
		//base case
		if(queenCount==0)
		{
			System.out.println(position);
			return; 
		}
		
		//If last square is reached and there are queens remaining
		if(x==3 && y==3 && queenCount>0)
		{
			
			//check if the last queen can be placed in the last square
			if(queenCount==1 && isValidLocation(grid,x,y) && grid[x][y]==true)
			{
				queenCount = queenCount - 1;
				position.append(x+","+y);
				return; 
			}
			else
			{
				return;
			}
		}
		
		//If queen is placed in an invalid location.
		
		if(grid[x][y]==true && !isValidLocation(grid, x, y))
		{
			grid[x][y]=false;
			return;
		}
		
		//If queen is placed in a valid location
		if(grid[x][y]==true && isValidLocation(grid, x, y))
		{
			position.append(x+","+y+"|");
			queenCount = queenCount - 1;
		}
		
		int[] indexs = findNext(grid,x,y);
			
		x = indexs[0];
		y = indexs[1];
		//If queen was present in the next square
		grid[x][y] = true;
		placeQueens(grid, x, y, queenCount, position);
		//If queen was not present in the next square
		x = indexs[0];
		y = indexs[1];
		grid[x][y] = false;
		placeQueens(grid, x, y, queenCount, position);
	}
	
	private int[] findNext(boolean[][] grid, int i, int j) {
		int[] indexs = new int[2];
		indexs[0]=i;
		indexs[1]=j;
		
		if(i<=3 && j==3)
		{
		  i++;
		  j=0;
		}
		else if(i<=3 && j<=3)
		{
		  j++;
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

	private boolean isValidLocation(boolean[][] grid, int x, int y) {
		int count = 0;
		
		for(int i=0;i<4;i++)
		{
			
			if(grid[i][y]==true)
			{
				count++;
			}
		}
		//if there are other queens in the same row return false
		if(count>1)
		{
			return false;
		}
		
		count = 0;
		for(int i=0;i<4;i++)
		{
			
			if(grid[x][i]==true)
			{
				count++;
			}
		}
		//if there are other queens in the same column return false
		if(count>1)
		{
			return false;
		}
		count = 0;
		int xl = x;
		int yl = y;
		
		while(xl<4 && yl<4)
		{
			
			if(grid[xl][yl])
			{
				count++;
			}
			xl++;
			yl++;
		}
		// forward leading diagonal
		if(count>1)
		{
			return false;
		}
		
		count = 0;
		xl = x;
		yl = y;
		while(xl>=0 && yl>=0)
		{
			if(grid[xl][yl])
			{
				count++;
			}
			xl--;
			yl--;
		}
		//Backward leading diagonal
		if(count>1)
		{
			return false;
		}
		
		//forward other diagonal
		count = 0;
		xl = x;
		yl = y;
		
		while(xl>=0 && yl<4)
		{
			if(grid[xl][yl])
			{
				count++;
			}
			xl = xl - 1;
			yl++;
		}
		
		if(count > 1)
		{
			return false;
		}
		
		//Backward other diagonal
		count = 0;
		xl = x;
		yl = y;
		
		while(xl<4 && yl>=0)
		{
			if(grid[xl][yl])
			{
				count++;
			}
			xl++;
			yl = yl - 1;
		}
		
		if(count > 1)
		{
			return false;
		}
		
		return true;
	}
	/*
	public static void main(String[] args)
	{
		NQueens obj = new NQueens();
		boolean[][] grid = {
				{false,false,false,false},
				{false,false,false,false},
				{false,false,false,false},
				{false,false,false,false},
				
};
		int[] a = obj.findNext(grid, 3, 3);
		System.out.println(Arrays.toString(a));
		StringBuilder some = new StringBuilder();
		boolean[][] grid = {
							{false,false,false,false},
							{false,false,false,false},
							{false,false,false,false},
							{false,false,false,false},
							
		};
		obj.placeQueens(grid, 0, 0, 4,some);
		boolean[][] gridTwo = {
				{false,false,false,false},
				{false,false,false,false},
				{false,false,false,false},
				{false,false,false,false},
				
};
		gridTwo[0][0] = true;
		StringBuilder someTwo = new StringBuilder();
		obj.placeQueens(gridTwo, 0, 0, 3,someTwo); 
	} */
}
