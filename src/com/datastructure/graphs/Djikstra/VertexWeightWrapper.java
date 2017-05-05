package com.datastructure.graphs.Djikstra;

import java.util.PriorityQueue;

public class VertexWeightWrapper {
	
	private Integer vertex;
	private int weight;
	
	public VertexWeightWrapper(Integer vertex, int weight) {
		super();
		this.vertex = vertex;
		this.weight = weight;
	}
	
	public Integer getVertex() {
		return vertex;
	}
	public void setVertex(Integer vertex) {
		this.vertex = vertex;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public static void main(String[] args)
	{
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		VertexWeightWrapper v1 = new VertexWeightWrapper(one, 1);
		VertexWeightWrapper v2 = new VertexWeightWrapper(two, 5);
		VertexWeightComparator vc = new VertexWeightComparator();
		PriorityQueue<VertexWeightWrapper> q = new PriorityQueue<VertexWeightWrapper>(vc);
		q.add(v1);
		q.add(v2);
		System.out.println(q.remove().getWeight());
		
	}
}
