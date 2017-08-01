package com.ctci.DynamicProgramming;
import com.ctci.DynamicProgramming.Box;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
/**
 * Program to solve the box stacking problem using memoization.
 * @author daebenez
 * Time complexity : O(N*N)
 */
public class BoxStacking {
	
	
	public void stackBoxes(ArrayList<Box> input)
	{
		Collections.sort(input);
		int[] cache = new int[100];
		System.out.println(stackUtil(input, 0,null,cache));
	}
	
	public int stackUtil(ArrayList<Box> input,int index,Box bottom,int[] cache)
	{
		if(cache[index]!=0)
		{
			return cache[index];
		}
		if(index>=input.size())
		{
			return 0;
		}
		Box newBox = input.get(index);
		int leftHeight = 0;
		if(bottom==null || (bottom.length > newBox.length && bottom.breadth > newBox.breadth && bottom.height > newBox.height))
		{
		  leftHeight = input.get(index).length + stackUtil(input, index+1,newBox,cache);
		}
		
		int rightHeight = stackUtil(input, index+1,bottom,cache);
		
		int mxV = Math.max(leftHeight, rightHeight);
		cache[index] = mxV;
		return mxV;
	}
	
	/*
	public static void main(String[] args)
	{
		ArrayList<Box> input = new ArrayList<Box>();
		Box b1 = new Box(1, 2, 3);
		Box b2 = new Box(11, 12, 13);
		Box b3 = new Box(21, 22, 23);
		
		input.add(b1);
		input.add(b2);
		input.add(b3);
		
		BoxStacking obj = new BoxStacking();
		obj.stackBoxes(input);
	} */

}
