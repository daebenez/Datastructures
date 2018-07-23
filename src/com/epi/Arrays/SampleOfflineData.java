package com.epi.Arrays;
import java.util.*;

/**
 * Program to  sample offline data. get a random subset of size k.
 * @author daebenez
 * Time :O(k) Space : O(1)
 *
 */

public class SampleOfflineData {
	
	public static void data(List<Integer> input,int k)
	{
		Random rand = new Random();
		for(int i=0;i<k;i++)
		{
			// chooses random number from i to size()-1
			Collections.swap(input,i,i+rand.nextInt(input.size()-i));
		}
	}

}
