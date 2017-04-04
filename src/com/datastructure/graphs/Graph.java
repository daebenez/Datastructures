package com.datastructure.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
  * @author daebenez
  * Implementation of graph datastructure using adjacency list in Java.
  * Uses a Hashmap where the key is the Vertex and the value holds the adjacency list.
  * Time complexity :BFS & DFS -> O(V+E) where V is the number of vertices and E is the edges, 
  * because the algorithm processes each vertex followed by 
  * all adjacent vertices (outgoing edges) from the adjacency list once.
  */

class Graph {
	
	private HashMap<Vertex,ArrayList<Vertex>> graphList = new HashMap<Vertex,ArrayList<Vertex>>();
	
	//Undirected graphs so set edge between vertices both ways.
	public void setEdge(Vertex source,Vertex destination)
	{
		set(source,destination);
		set(destination,source);
	}
	
	//Create or add two adjacency list.
	public void set(Vertex source,Vertex destination)
	{
		if(graphList.containsKey(source))
		{	
			ArrayList<Vertex> adjacencyList = graphList.get(source);
			adjacencyList.add(destination);
			graphList.put(source,adjacencyList);
			
		}
		else {
			ArrayList<Vertex> emptyList = new ArrayList<Vertex>();
			emptyList.add(destination);
			graphList.put(source, emptyList);
		}
	}
	
	//Get adjacency list.
	public ArrayList<Vertex> getNeighbours(Vertex source)
	{
		return graphList.get(source);
	}
	
	/**
	 * Breadth First search algorithm.
	 * Use a queue to queue all adjacent nodes and print out the contents in order.
	 * @param root
	 */
	public void breadthFirstSearch(Vertex root)
	{
		Queue<Vertex> queue = new LinkedList<Vertex>();
		// Set the starting node to visited and enqueue. setParent to itself to avoid null pointer exception.
		root.setVisited(true);
		root.setParent(root);
		queue.add(root);
		
		//While queue is not empty dequeue each item and enqueue its neighbors.
		while(!queue.isEmpty())
		{
			Vertex temp = null;
			temp = queue.remove();
			ArrayList<Vertex> neighbours = null;
			neighbours = graphList.get(temp);
			// For each neighbor set visited, parent and distance from root.
			for(Vertex v:neighbours)
			{
				if(!v.isVisited)
				{
					Vertex newKey = v;
					newKey.setVisited(true);
					newKey.setParent(temp);
					// distance from root = distance of parent + 1.
					newKey.setDistance(temp.getDistance()+1);
					// replace the vertex in Hashmap (key) with updated parent, distance and visited by removing and adding back again.
					ArrayList<Vertex> valueList = graphList.get(v);
					graphList.remove(v);
					graphList.put(newKey, valueList);
					//enqueue
					queue.add(newKey);
				}
			}
		}
	}
	
	/**
	 * Depth first Search algorithm.
	 * @param mp
	 */
	public void DFS(Vertex root)
	{
		HashSet<Vertex> discovered = new HashSet<Vertex>();
		discovered.add(root);
		recursiveDFS(root,discovered);
	}
	
	public void recursiveDFS(Vertex root, HashSet<Vertex> discovered)
	{
		System.out.println(root.getData());
		ArrayList<Vertex> adjacentVertices = graphList.get(root);
		for(Vertex v : adjacentVertices)
		{
			if(!discovered.contains(v))
			{
				discovered.add(v);
				recursiveDFS(v,discovered);
			}
		}
	}
	
	// Given a Hashmap prints out all keys.
	public static void printMap(HashMap<Vertex,ArrayList<Vertex>> mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	    	HashMap.Entry pair = (HashMap.Entry)it.next();
	    	Vertex velo = (Vertex)pair.getKey();
	    	System.out.println("Vertex->"+velo.getData()+"Parent->"+velo.getParent().getData()+"Distance->"+velo.getDistance());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	/*
	public static void main(String[] args)
	{
		Graph g = new Graph();
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		Vertex three = new Vertex(3);
		Vertex four = new Vertex(4);
		Vertex five = new Vertex(5);
		Vertex six = new Vertex(6);
		g.setEdge(one, two);
		g.setEdge(one, three);
		g.setEdge(two, four);
		g.setEdge(three, four);
		g.setEdge(three, five);
		g.setEdge(three, six);
		g.setEdge(four, five);
		g.setEdge(five, six);
		g.DFS(one);
		g.breadthFirstSearch(one);
		printMap(g.graphList);
	} */
}