package com.functional.Backtracking;
import java.util.Arrays;
/**
 * Program to find a word in a character grid using backtracking.
 * @author daebenez
 */
public class SearchAWordInMatrix {
	
	public void searchWord(char[][] grid,int i,int j,String word,int index,boolean[][] solutionMatrix)
	{
		//base case if end of word is reached
		if(index==word.length())
		{
			for(int ii=0;ii<5;ii++)
			{
				System.out.println();
				for(int jj=0;jj<5;jj++)
				{
					System.out.print(solutionMatrix[ii][jj]+",");
				}
			}
			System.out.println("Success");
			return;
		}
		//If we have not found the first letter of the word yet
		int[] indexs = new int[16];
		if(index==0)
		{
			char letter = word.charAt(0);
			indexs = findFirstChar(grid,i,j,letter);
		}
		//If we are finding subsequents letters from the word.
		if(index>0 && index<word.length())
		{
			indexs = checkAdjacentSquares(grid,i,j,word,index);
		}
		//Recursive calls
		for(int q=0;q<16;q=q+2)
		{
			if(indexs[q]!=Integer.MAX_VALUE)
			{
				solutionMatrix[indexs[q]][indexs[q+1]]=true;
				searchWord(grid, indexs[q], indexs[q+1], word, index+1, solutionMatrix);
			}
		}
	}

	/**
	 * Method that checks if the next char is in any of the adjacent squares.
	 * @param grid
	 * @param i
	 * @param j
	 * @param word
	 * @param index
	 * @return
	 */
	private int[] checkAdjacentSquares(char[][] grid, int i, int j, String word, int index) {
		
		int[] nextindexes = new int[16];
		//if the square to the left has the next character
		if(i>0 && grid[i-1][j]==word.charAt(index))
		{
			nextindexes[0]=i-1;
			nextindexes[1]=j;
		}
		else
		{
			nextindexes[0]=Integer.MAX_VALUE;
			nextindexes[1]=Integer.MAX_VALUE;
		}
		//If the square to the right has the next character
		if(i<4 && grid[i+1][j]==word.charAt(index))
		{
			nextindexes[2]=i+1;
			nextindexes[3]=j;
			
		}
		else
		{
			nextindexes[2]=Integer.MAX_VALUE;
			nextindexes[3]=Integer.MAX_VALUE;
		}
		//If the square to the top has the next character
		if(j> 0 && grid[i][j-1]==word.charAt(index))
		{
			nextindexes[4]=i;
			nextindexes[5]=j-1;
		}
		else
		{
			nextindexes[4]=Integer.MAX_VALUE;
			nextindexes[5]=Integer.MAX_VALUE;
		}
		//If the square to the bottom has the next character
		if(j<4 && grid[i][j+1]==word.charAt(index))
		{
			nextindexes[6]=i;
			nextindexes[7]=j+1;
		}
		else
		{
			nextindexes[6]=Integer.MAX_VALUE;
			nextindexes[7]=Integer.MAX_VALUE;
		}
		//If the square is bottom right
		if(i<4 && j<4 && grid[i+1][j+1]==word.charAt(index))
		{
			nextindexes[8]=i+1;
			nextindexes[9]=j+1;
		}
		else
		{
			nextindexes[8]=Integer.MAX_VALUE;
			nextindexes[9]=Integer.MAX_VALUE;
		}
		//If the square is up left
		if(i>0 && j>0 && grid[i-1][j-1]==word.charAt(index))
		{
			nextindexes[10]=i-1;
			nextindexes[11]=j-1;
		}
		else
		{
			nextindexes[10]=Integer.MAX_VALUE;
			nextindexes[11]=Integer.MAX_VALUE;
		}
		//If the square is top right
		if(i<4 && j>0 && grid[i+1][j-1]==word.charAt(index))
		{
			nextindexes[12]=i+1;
			nextindexes[13]=j-1;
		}
		else
		{
			nextindexes[12]=Integer.MAX_VALUE;
			nextindexes[13]=Integer.MAX_VALUE;
		}
		//If the square is bottom left
		if(i>0 && j<4 && grid[i-1][j+1]==word.charAt(index))
		{
			nextindexes[14]=i-1;
			nextindexes[15]=j+1;
		}
		else
		{
			nextindexes[14]=Integer.MAX_VALUE;
			nextindexes[15]=Integer.MAX_VALUE;
		}
		return nextindexes;
	}
	/**
	 * Given a x,y co ordinate in 2D matrix find the next co-ordinate where the letter occurs.
	 * @param grid
	 * @param i - initial x 
	 * @param j - initial y
	 * @param letter - letter being searched
	 * @return next co-ordinate where letter occurs or if not found return i,j
	 */
	private int[] findFirstChar(char[][] grid, int i, int j, char letter) {
		int[] indexs = new int[16];
		int xIndex = 0;
		for(int ii=0;ii<16;ii++)
		{
			indexs[ii] = Integer.MAX_VALUE;
		}
		
		int q = i;
		int w = j;
		while(q!=5)
		{
			while(w!=5)
			{
				if(grid[q][w]==letter)
				{
					indexs[xIndex]=q;
					indexs[xIndex+1]=w;
					xIndex = xIndex+2;
				}
				w++;
			}
			q++;
			w=0;
		}
		return indexs;
	}
	/*
	public static void main(String[] args)
	{
		SearchAWordInMatrix obj = new SearchAWordInMatrix();
		char[][] grid = {
				     {'t','a','h','o','a'},
				     {'z','h','w','r','b'},
				     {'x','n','o','n','r'},
				     {'c','z','i','r','i'},
				     {'d','x','o','n','n'},
		};
		boolean[][] solutionMatrix = new boolean[5][5];
		obj.searchWord(grid, 0, 0, "horizon", 0, solutionMatrix);
	} */
}
