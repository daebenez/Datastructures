package com.functional.Backtracking;
/**
 * Program to find a path out of the maze using backtracking.
 * @author daebenez
 * Time Complexity -> O(N*M) where N is the number of open squares we can move to and
 * M is the number of legal moves for each square.
 */
public class Maze {
	
	public void findPath(int[][] maze, int xstart,int ystart,StringBuilder path)
	{
		//If destination is reached
		if(xstart == 2 && ystart == 2)
		{
			path.append(xstart+","+ystart);
			System.out.print("Succesful path to destination->");
			System.out.println(path);
			return;
		}
		
		// Find legal moves from current square
		StringBuilder legalMoves = findLegalMoves(maze,xstart,ystart);
		//If there are no legals moves,this is a dead end.
		if(legalMoves.length()==0)
		{
			return;
		}
		// Move down
		if(legalMoves.indexOf("D")!=-1)
		{
			path.append(xstart+","+ystart+"|");
			findPath(maze,xstart, ystart+1,path);
		}
		//Move right
		if(legalMoves.indexOf("R")!=-1)
		{
			path.append(xstart+","+ystart+"|");
			findPath(maze,xstart+1, ystart, path);
		}
		//Moving Up or left will cause the program to loop infinitely  
	}
	
	/**
	 * Method to find all legal moves possible from a square.
	 * @param maze
	 * @param xstart
	 * @param ystart
	 * @return
	 */
	private StringBuilder findLegalMoves(int[][] maze,int xstart, int ystart) {
		StringBuilder result = new StringBuilder();
		
		if(xstart>=0 && xstart<=2 && (ystart+1)>=0 && (ystart+1)<=2 && maze[xstart][ystart+1]==1)
		{
			result.append("D");
		}
		
		if((xstart+1)>=0 && (xstart+1)<=2 && ystart>=0 && ystart<=2 && maze[xstart+1][ystart]==1)
		{
			result.append("R");
		}
		
		if((xstart-1)>=0 && (xstart-1)<=2 && ystart>=0 && ystart<=2 && maze[xstart-1][ystart]==1)
		{
			result.append("L");
		}
		
		if(xstart>=0 && xstart<=2 && (ystart-1)>=0 && (ystart-1)<=2 && maze[xstart][ystart-1]==1)
		{
			result.append("U");
		}		
		
		return result;
	}

	/*
	public static void main(String[] args)
	{
		int[][] maze = {{1,1,1},
						{0,1,0},
						{0,1,1},
		};
		
		Maze obj = new Maze();
		StringBuilder path = new StringBuilder();
		obj.findPath(maze, 0, 0, path);
	} */

}
