package com.epi.Arrays;
import java.util.*;
/**
 * Program to sample streaming online data.
 * Time: O(N) Space: O(N)
 * @author dabenez
 * Pick a random number within the chosen sample to replace whenever new data comes in.
 */
public class SampleOnlineData {
	public static void sample(Iterator<Integer> sequence, int k)
	{
		List<Integer> runningList = new ArrayList<>(k);
		int length = k;
		for(int i=0;i<runningList.size() && sequence.hasNext();i++)
		{
			runningList.add(sequence.next());
		}
		Random rand = new Random();
		while(sequence.hasNext())
		{
			int x = sequence.next();
			length++;
			int randNumber = rand.nextInt(length);
			if(randNumber<k)
			{
				runningList.set(randNumber, x);
			}
		}
	}
}
