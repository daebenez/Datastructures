package com.epi.Heap;
import java.util.*;
// Time complexity O(n log k) because every insertion could lead to heapify which costs O(log k) where k is the hieght of tree
public class MergeSortedArrays {
	
	public static List<Integer> merge(List<List<Integer>> sortedArrays)
	{
		//create Priority Queue with array entries
		PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(((int)sortedArrays.size()),new Comparator<ArrayEntry>() 
					{
					public int compare(ArrayEntry o1, ArrayEntry o2)
					{
						return Integer.compare(o1.value, o2.value);
					}
				});
		//create List of iterators holding iterators for every list
		List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());
		
		//Add iterator for every list into the list
		for(List<Integer> arr : sortedArrays)
		{
			iters.add(arr.iterator());
		}
		
		// Add an item from each list into the heap
		for(int i=0;i<iters.size();i++)
		{
			if(iters.get(i).hasNext())
			{
				minHeap.add(new ArrayEntry(iters.get(i).next(),i));
			}
		}
		
		// Heap sort
		List<Integer> result = new ArrayList<Integer>();
		while(!minHeap.isEmpty())
		{
			ArrayEntry item = minHeap.poll();
			result.add(item.value);
			if(iters.get(item.arrayId).hasNext())
			{
				minHeap.add(new ArrayEntry(iters.get(item.arrayId).next(),item.arrayId));
			}
		}
		return result;
	}
	
}
