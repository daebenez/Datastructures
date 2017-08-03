package com.ctci.SortSearch;
import java.util.Arrays;
/**
 * CTCI Q 10.1
 * Program to merge 2 sorted arrays.
 * @author daebenez
 * Time Complexity : O(m+n) where m is the number of elements in the sirst array and n for the second array
 * We move every element exactly once which is why the time complexity is near linear.
 * Space complexity : O(m+n)
 */
public class SortedMerge {
	
	public int[] merge(int[] a,int[] b,int lastIndexA,int lastIndexB)
	{
		int mergedLastIndex = lastIndexA + lastIndexB + 1;
		while(lastIndexB>=0)
		{
			if(lastIndexA>=0 && a[lastIndexA]>b[lastIndexB])
			{
				a[mergedLastIndex] = a[lastIndexA];
				lastIndexA--;
			}
			else
			{
					a[mergedLastIndex] = b[lastIndexB];
					lastIndexB--;
			}
			mergedLastIndex--;
		}
		
		return a;
	}
	
	public static void main(String[] args)
	{
		SortedMerge obj = new SortedMerge();
		int[] a = new int[100];
		int[] b = new int[100];
		a[0] = 2;
		a[1] = 4;
		a[2] = 6;
		b[0] = 1;
		b[1] = 3;
		b[2] = 5;
		
		int[] res = obj.merge(a, b, 2, 2);
		System.out.println(Arrays.toString(res));
	}
}
