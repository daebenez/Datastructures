package com.datastructure.graphs.Prims;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Program to implement Prim's algorithm to find MST given a graph.
 * Start with a node, insert all its edges into a priority queue,
 * add the current node to visited. Remove min edge from queue and 
 * repeat on all nodes.
 * @author daebenz
 * 
 * Time Complexity : O(E log E) when using adjacency list and priority queue that sorts by edges. 
 * Each extract min from queue costs log E, we do this until we find all vertices which may take examining all edges.
 * Space Complexity :O(n) -> for all the extra lists being used.
 *
 */

public class MST {
	EdgeWeightComparator comparator = new EdgeWeightComparator();
	PriorityQueue<EdgeWeightWrapper> queue = new PriorityQueue<EdgeWeightWrapper>(comparator);
	//input graph
	static WeightedGraph graph = new WeightedGraph();
	HashSet<Integer> visited = new HashSet<Integer>();
	//stores final MST
	HashSet<EdgeWeightWrapper> MSTedges = new HashSet<EdgeWeightWrapper>();
	
	public void findMST(Integer start,int size)
	{
		if(graph.adjacencyList.containsKey(start))
		{
			LinkedList<VertexWeightWrapper> neighbours = graph.adjacencyList.get(start);
			//examine all neighbours of start vertex and insert all edges into queue.
			for(VertexWeightWrapper vw : neighbours)
			{
				EdgeWeightWrapper temp = new EdgeWeightWrapper(start, vw.getVertex(), vw.getWeight());
				queue.add(temp);
			}
			//add the start vertex to visited after examining all neighbours.
			visited.add(start);
			//while all vertices haven't been visited yet
			while(visited.size()<size)
			{
				//priority queue spits out the edge with the least weight.
				EdgeWeightWrapper minEdge = queue.remove();
				// Check if second vertex is an unvisited vertex.
				if(!visited.contains(minEdge.getVertexTwo()))
				{
					//If second vertex is unvisited we have a edge that is part of MST.
					MSTedges.add(minEdge);
					LinkedList<VertexWeightWrapper> neighboursTemp = graph.adjacencyList.get(minEdge.getVertexTwo());
					//examine all edges and insert into queue.
					for(VertexWeightWrapper v : neighboursTemp)
					{
						EdgeWeightWrapper tempT = new EdgeWeightWrapper(minEdge.getVertexTwo(), v.getVertex(), v.getWeight());
						queue.add(tempT);
					}
					//add current vertex to visited.
					visited.add(minEdge.getVertexTwo());
				}	
			}
		}
		printMST();
	}
	
	public void printMST()
	{
		Iterator<EdgeWeightWrapper> itr = MSTedges.iterator();
		System.out.println("Number of edges in MST -> "+MSTedges.size());
		while(itr.hasNext())
		{
			EdgeWeightWrapper temp = itr.next();
			System.out.println(temp.getVertexOne().intValue()+"-"+temp.getVertexTwo().intValue()+":"+temp.getWeight());
		}
	}
	
	//Sample problem and solution from -> http://optlab-server.sce.carleton.ca/POAnimations2007/MinSpanTree.html
	/*
	public static void main(String[] args)
	{
		
		Integer zero = new Integer(0);
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Integer three = new Integer(3);
		Integer four = new Integer(4);
		Integer five = new Integer(5);
		Integer six = new Integer(6);
		Integer seven = new Integer(7);
		Integer eight = new Integer(8);
		
		graph.setEdge(zero, one, 4);
		graph.setEdge(zero, seven, 8);
		graph.setEdge(one, seven, 11);
		graph.setEdge(one, two, 8);
		graph.setEdge(seven, six, 1);
		graph.setEdge(two, eight, 2);
		graph.setEdge(seven, eight, 7);
		graph.setEdge(eight, six, 6);
		graph.setEdge(six, five, 2);
		graph.setEdge(two, five, 4);
		graph.setEdge(two, three, 7);
		graph.setEdge(three, five, 14);
		graph.setEdge(three, four, 9);
		graph.setEdge(five, four, 10);
		
		graph.setEdge(one, two, 3);
		graph.setEdge(one, three, 2);
		graph.setEdge(one, four, 5);
		graph.setEdge(two, four, 2);
		graph.setEdge(two, six, 13);
		graph.setEdge(three, five, 5);
		graph.setEdge(three, four, 2);
		graph.setEdge(three, five, 5);
		graph.setEdge(four, five, 4);
		graph.setEdge(four, seven, 3);
		graph.setEdge(four, six, 6);
		graph.setEdge(five, seven, 6);
		graph.setEdge(six, seven, 2);
		graph.setEdge(six, eight, 3);
		graph.setEdge(eight, seven, 6);
		
		MST obj = new MST();
		obj.findMST(five,8);
		
	} */

}
