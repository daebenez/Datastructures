package com.datastructure.graphs.Dijkstra;
/**
 * Program to create a weighted graph using adjacency list representation.
 * Each vertex in the graph is a Integer.
 * @author daebenez
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class WeightedGraph {
	
	public HashMap<Integer,LinkedList<VertexWeightWrapper>> adjacencyList = new HashMap<Integer,LinkedList<VertexWeightWrapper>>();
	
	public boolean setEdge(Integer vertexOne,Integer vertexTwo,int weight)
	{
		setUndirectedEdges(vertexOne, vertexTwo, weight);
		setUndirectedEdges(vertexTwo, vertexOne, weight);
		return true;
	}
	
	public boolean setUndirectedEdges(Integer source,Integer destination,int weight)
	{
		if(adjacencyList.containsKey(source))
		{
			VertexWeightWrapper temp = new VertexWeightWrapper(destination, weight);
			adjacencyList.get(source).add(temp);
			return true;
		}
		else
		{
			VertexWeightWrapper temp = new VertexWeightWrapper(destination, weight);
			LinkedList<VertexWeightWrapper> neighbours = new LinkedList<VertexWeightWrapper>();
			neighbours.add(temp);
			adjacencyList.put(source, neighbours);
			return true;
		}
	}
	
	// Given a Hashmap prints out all keys.
		public void printMap() {
		    Iterator it = adjacencyList.entrySet().iterator();
		    while (it.hasNext()) {
		    	System.out.println();
		    	HashMap.Entry pair = (HashMap.Entry)it.next();
		    	System.out.print("Source :"+pair.getKey());
		    	System.out.print("->");
		    	LinkedList<VertexWeightWrapper> tempList = (LinkedList<VertexWeightWrapper>)pair.getValue();
		    	for(VertexWeightWrapper v : tempList)
		    	{
		    		System.out.print(","+v.getVertex());
		    	}
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		}
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
		
		obj.printMap();
	} */

}
