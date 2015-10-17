package com.datastructure.sortingalgorithms;

/**
 * @author daebenez
 * Implementation of bubble sort in Java
 * Time complexity : Worst & Average case -> Big-Oh n squared. Best case -> Big-Oh n
 * Space complexity : Big-Oh 1 (in place sorting)
 */

public class BubbleSort {
	
	public static int[]  bubbleSort(int[] inputArray)
	{
		for(int i=0;i<inputArray.length;i++)
		{
			for(int j=0;j<inputArray.length-1;j++)
			{
				if (inputArray[j]>inputArray[j+1])
				{
					swap(inputArray,j,j+1);
				}
			}
		}
		return inputArray;
	}
	
	
	/**
	 * 
	 * Method to swap elements given an array and 2 positions
	 * @param array
	 * @param index1
	 * @param index2
	 * @return array
	 */
	
	private static int[] swap(int[] array, int index1, int index2)
	{
		int temp=0;
		temp = array[index1];
		array[index1] = array[index2];
		array[index2]= temp;
		return array;
	}
	
	
	/**
	 * @param args
	 * Test function
	 */
	
	/*public static void main(String[] args)
	{
		int[] testArray = {3,1,6,-2,5,9,-8};
		int[] result = new int[8];
		result = bubbleSort(testArray);
		for(int k=0;k<result.length;k++)
		{
			System.out.println(result[k]);
		}
		
	}*/

}
