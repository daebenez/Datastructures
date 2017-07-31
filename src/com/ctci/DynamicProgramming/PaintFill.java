package com.ctci.DynamicProgramming;
/**
 * Program to mimick paint fill using a 2D array.
 * Colors represented by 0,128,256
 * @author daebenez
 * Time Complexity : O(N) -> because each point that is of a certain color is visited once, similar to DFS in graph traversal.
 */
public class PaintFill {
	
	
	
	public int[][] paintFill(int[][] screen,int x,int y,int destinationColor)
	{
		int source = screen[x][y];
		int screenlength = screen.length-1;
		int[][] res = paintFillUtil(screen, x, y, screenlength, source, destinationColor);
		return res;
	}
	
	private int[][] paintFillUtil(int[][] screen,int x,int y,int screenlength,int source,int destination)
	{
		if((x<0) || (y<0) || (x>screenlength) || (y>screenlength))
		{
			return screen;
		}
		else if((screen[x][y]!=source))
		{
			return screen;
		}
		else
		{
			screen[x][y] = 256;
			paintFillUtil(screen, x-1, y-1, screenlength, source, destination);
			paintFillUtil(screen, x-1, y, screenlength, source, destination);
			paintFillUtil(screen, x-1, y+1, screenlength, source, destination);
			paintFillUtil(screen, x, y-1, screenlength, source, destination);
			paintFillUtil(screen, x, y+1, screenlength, source, destination);
			paintFillUtil(screen, x+1, y-1, screenlength, source, destination);
			paintFillUtil(screen, x+1, y, screenlength, source, destination);
			paintFillUtil(screen, x+1, y+1, screenlength, source, destination);
			
		}
		
		return screen;
	}
	
	public static void main(String[] args)
	{
		PaintFill obj = new PaintFill();
		int[][] screen = { {0,0,0,0},
						   {128,128,128,128},
						   {0,128,128,128},
						   {0,128,128,128}
		};
		
		
		int[][] result = obj.paintFill(screen, 2, 2, 256);
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(screen[i][j]+",");
			}
			System.out.println();
		}
	}

}
