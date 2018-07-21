package com.epi.Arrays;
import java.util.*;
/**
 * Permute an array in the given order.
 * Time: O(N), Space : O(1)
 * Permutations are cyclic, do them one by one until a cycle is completed
 * To do them in place subtract the permutation index by size to make it mark it as negative
 * @author daebenez
 *
 */
public class PermuteArray {
	public static void permute(List<Integer> input, List<Integer> permute)
	{
		for(int i=0;i<input.size();i++)
		{
			int next = i;
			while(permute.get(next)>=0)
			{
				Collections.swap(input,i,permute.get(next));
				int temp = permute.get(next);
				permute.set(next, permute.get(next)-permute.size());
				next = temp;
			}
		}
		
		for(int i=0;i<permute.size();i++)
		{
			permute.set(i, permute.get(i)+permute.size());
		}
		
		System.out.println(Arrays.toString(input.toArray()));
	}
	public static void main(String[] args)
	{
		List<Integer> input = Arrays.asList(11, 12, 13,14);
		List<Integer> p = Arrays.asList(3,1,2,0);
		permute(input,p);
	}
	
}
