package com.datastructure.graphs;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Program to perform topological sorting of a graph with adjacency list representation.
 * Time Complexity :O(V + E) -> because we scan all vertices and edges exactly once.
 * @author daebenez
 */

public class TopologicalSort {
	
	private HashMap<Character,LinkedList<Character>> neighbours = new HashMap<Character,LinkedList<Character>>();
	private HashSet<Character> visited = new HashSet<Character>();
	private Stack<Character> finalOrder = new Stack<Character>();
	
	// Seed function to make sure every vertex in the graph is visited.
	public void startSort(Character node)
	{
		for(Character vertex : neighbours.keySet())
		{
			if(!visited.contains(vertex))
			{
				sort(vertex);
				finalOrder.push(vertex);
			}
		}
	}
	
	// Recursive function to perform DFS - topological sort
	public void sort(Character node)
	{
		visited.add(node);
		if(!neighbours.containsKey(node))
		{
			visited.add(node);
			return;
		}
		LinkedList<Character> nearNodes= neighbours.get(node);
		int index = 0;
		while(index < nearNodes.size() && visited.contains(nearNodes.get(index)))
		{
			index++;
		}
		
		sort(nearNodes.get(index));
		finalOrder.push(nearNodes.get(index));
	}
	
	/*
	public static void main(String[] args)
	{
		TopologicalSort graph = new TopologicalSort();
		Character A = new Character('A');
		Character B = new Character('B');
		Character C = new Character('C');
		Character D = new Character('D');
		Character E = new Character('E');
		Character F = new Character('F');
		Character G = new Character('G');
		Character H = new Character('H');
		
		LinkedList<Character> first = new LinkedList<Character>();
		first.add(C);
		graph.neighbours.put(A, first);
		
		LinkedList<Character> second = new LinkedList<Character>();
		second.add(C);
		second.add(D);
		graph.neighbours.put(B, second);
		
		LinkedList<Character> third = new LinkedList<Character>();
		third.add(E);
		graph.neighbours.put(C, third);
		
		LinkedList<Character> fourth = new LinkedList<Character>();
		fourth.add(H);
		fourth.add(F);
		graph.neighbours.put(E, fourth);
		
		LinkedList<Character> fifth = new LinkedList<Character>();
		fifth.add(F);
		graph.neighbours.put(D, fifth);
		
		LinkedList<Character> seventh = new LinkedList<Character>();
		seventh.add(G);
		graph.neighbours.put(F,seventh);
		
		graph.startSort(E);
		
		System.out.println(Arrays.toString(graph.finalOrder.toArray()));
	} */
}
