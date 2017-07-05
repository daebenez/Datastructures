package com.functional.DP;
/**
 * Given a 2D boolean matrix, find the maximum square formed by cells set to trues. 
 * Dynamic bottom up programming.
 * @author daebenez
 */
public class maxSubMatrix {
	
	public int findMaxSubMatrix(boolean[][] input)
	{
		int[][] solutionMatrix = new int[input.length][input[0].length];
		//fill in the first column
		for(int z=0;z<input[0].length;z++)
		{
			if(input[0][z]==true)
			{
				solutionMatrix[0][z]=1;
			}
			else
			{
				solutionMatrix[0][z]=0;
			}
		}
		//fill in the first row
		for(int x=1;x<input.length;x++)
		{
			if(input[x][0]==true)
			{
				solutionMatrix[x][0]=1;
			}
			else
			{
				solutionMatrix[x][0]=0;
			}
		}
		// fill in the rest using the formula -> find least among top, left and topleft and add one.
		for(int i=1;i<input.length;i++)
		{
			for(int j=1;j<input[0].length;j++)
			{
				
				if(input[i][j]==true)
				{
					
					int top1 = solutionMatrix[i-1][j];
					int left1 = solutionMatrix[i][j-1];
					int topLeft = solutionMatrix[i-1][j-1];
					
					
					
					if(top1 < left1)
					{
						if(top1 <= topLeft)
						{
							solutionMatrix[i][j] = solutionMatrix[i-1][j]+1;
						}
					}else
					{
						if(left1 < topLeft)
						{
							solutionMatrix[i][j] = solutionMatrix[i][j-1]+1;
						}
						else
						{
							solutionMatrix[i][j] = solutionMatrix[i-1][j-1]+1;
						}
					}
				}
				else
				{
					
					solutionMatrix[i][j]=0;
				}
			}
		}
		//find the maximum number in the solution matrix which is the size of the square.
		int max = 0;
		for(int ii=0;ii<solutionMatrix.length;ii++)
		{
			for(int jj=0;jj<solutionMatrix[0].length;jj++)
			{
				if(max<solutionMatrix[ii][jj])
				{
					max = solutionMatrix[ii][jj];
				}
			}
		}
		return max;
	}
	/*
	public static void main(String[] args)
	{
		 boolean[][] ip = { 
				{false,false,false,false,true},
				{true,false,true,false,true},
				{false,true,true,true,true},
				{true,true,true,true,true},
				{false,true,true,true,true},
				{true,true,true,true,true},
		};
		
		maxSubMatrix obj = new maxSubMatrix();
		System.out.println(obj.findMaxSubMatrix(ip));
	} */
	
}
