package com.datastructure.graphs.Prims;
/**
 * Helper class to create a wraaper instance that wraps a vertex and its weight.
 * @author : daebenez
 */
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
	
}
