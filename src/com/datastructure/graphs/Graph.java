package com.datastructure.graphs;
import com.datastrcuture.graphs.Vertex;
import java.util.ArrayList;
import java.util.HashMap;

/**
  * @author daebenez
  * Implementation of graph datastructure using adjacency list in Java.
  * Uses a Hashmap where the key is the Vertex and the value holds the adjacency list.
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
			System.out.println("New list");
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
	
	public static void main(String[] args)
	{
		Graph g = new Graph();
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		Vertex three = new Vertex(3);
		g.setEdge(one, two);
		System.out.println("Boo");
		g.setEdge(one, three);
		System.out.println("Boo");
		g.setEdge(two, three);
		ArrayList<Vertex> u = g.getNeighbours(one);
		
		for(Vertex v : u)
		{
			System.out.println(v.getData());
		}
	}
}