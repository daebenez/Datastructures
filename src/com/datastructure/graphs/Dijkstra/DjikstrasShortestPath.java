package com.datastructure.graphs.Dijkstra;
/**
 * Program to find shortest path from a start node to end node using Dijkstra's algorithm
 * Use modified BFS graph traversal algorithm, use a priroity queue instead of a queue.
 * The priority queue which is based of a min heap always dequeues min edge.
 * Time complexity : O(E log V) for adjacency list representation and using min heap
 * If a fibonacci heap is used it will reduce time even further.
 * Space complexity : O(n) because of all the extra data structures.
 * @author daebenez
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DjikstrasShortestPath {
	int[] distances = new int[20];
	VertexWeightComparator comparator = new VertexWeightComparator();
	PriorityQueue<VertexWeightWrapper> queue = new PriorityQueue<VertexWeightWrapper>(comparator);
	HashSet<Integer> visited = new HashSet<Integer>();
	int[] parent = new int[20];
	
	public DjikstrasShortestPath()
	{
		// Set distances to all nodes to infinity
		for(int i=0;i<20;i++)
		{
			distances[i] = Integer.MAX_VALUE;
		}
	}
	
	public void findShortestPath(WeightedGraph graph, Integer start, Integer end)
	{
		//Set start node distance to zero.
		distances[start.intValue()] = 0;
		//Set parent for first node as itself.
		//parent.put(start, start);
		parent[start.intValue()] = start.intValue();
		//add start node and its distance to queue.
		queue.add(new VertexWeightWrapper(start,0));
		//Loop until end node is reached or queue is empty. 
		while((!queue.isEmpty()) && (!queue.peek().getVertex().equals(end)))
		{
			//If node has neghbours
			if(graph.adjacencyList.containsKey(queue.peek().getVertex()))
			{
				//retrieve neighbours
				LinkedList<VertexWeightWrapper> neighbours = graph.adjacencyList.get(queue.peek().getVertex());
				// Iterate through the neighbours and update their distance
				for(VertexWeightWrapper v : neighbours)
				{
					//If neighbour is not already visited.
					if(!visited.contains(v.getVertex()))
					{
						int vertexWeight = distances[queue.peek().getVertex().intValue()] + v.getWeight();
						//If prior distance of current neighbor is greater than current distance 
						if((distances[v.getVertex().intValue()] > vertexWeight))
						{
							//update distance
							distances[v.getVertex().intValue()] = vertexWeight;
							//update parent
							parent[v.getVertex().intValue()] = queue.peek().getVertex().intValue();
							VertexWeightWrapper vw = new VertexWeightWrapper(v.getVertex(), vertexWeight);
							queue.add(vw);
						}
					}
					
				}
				visited.add(queue.peek().getVertex());
				queue.remove();
			}
		}
	}
	
	public void printPath(Integer start,Integer temp)
	{
		if( temp == start.intValue())
		{
			System.out.print(start.intValue());
			return;
		}
		
		printPath(start,Integer.valueOf(parent[temp.intValue()]));
		System.out.print("->"+temp.intValue());
	}
	//Question from -> http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
	/*
	public static void main(String[] args)
	{
		WeightedGraph obj = new WeightedGraph();
		Integer zero = new Integer(0);
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Integer three = new Integer(3);
		Integer four = new Integer(4);
		Integer five = new Integer(5);
		Integer six = new Integer(6);
		Integer seven = new Integer(7);
		Integer eight = new Integer(8);
		
		obj.setEdge(zero, one, 4);
		obj.setEdge(zero, seven, 8);
		obj.setEdge(one, seven, 11);
		obj.setEdge(one, two, 8);
		obj.setEdge(seven, six, 1);
		obj.setEdge(two, eight, 2);
		obj.setEdge(seven, eight, 7);
		obj.setEdge(eight, six, 6);
		obj.setEdge(six, five, 2);
		obj.setEdge(two, five, 4);
		obj.setEdge(two, three, 7);
		obj.setEdge(three, five, 14);
		obj.setEdge(three, four, 9);
		obj.setEdge(five, four, 10);
		
		DjikstrasShortestPath ob = new DjikstrasShortestPath();
		ob.findShortestPath(obj, zero, four);
		ob.printPath(zero,four);
		
	} */
}
