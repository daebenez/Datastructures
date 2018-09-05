package com.epi.Heap;
import java.util.*;
public class Median {
	// Min heap has to be primary for this to work
	public static double findMedian(Iterator<Integer> input)
	{
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		double median = 0;
		while(input.hasNext())
		{
			minHeap.offer(input.next());
			maxHeap.offer(minHeap.poll());
			if(maxHeap.size()>minHeap.size())
			{
				minHeap.offer(maxHeap.poll());
			}
			
			if(minHeap.size()-maxHeap.size()==0)
			{
				median = (minHeap.peek() + maxHeap.peek()) * (0.5);
			}
			else
			{
				median = minHeap.size();
			}
		}
		
		return median;
	}

}
