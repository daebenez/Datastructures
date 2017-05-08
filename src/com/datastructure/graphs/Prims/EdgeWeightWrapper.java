package com.datastructure.graphs.Prims;
/**
 * Helper class to wrap two vertexes and their weight.
 * @author daebenez
 */
public class EdgeWeightWrapper {
	
	private Integer vertexOne;
	private Integer vertexTwo;
	private int weight;
	
	public EdgeWeightWrapper(Integer vertexOne, Integer vertexTwo, int weight) {
		super();
		this.vertexOne = vertexOne;
		this.vertexTwo = vertexTwo;
		this.weight = weight;
	}
	
	public Integer getVertexOne() {
		return vertexOne;
	}
	public void setVertexOne(Integer vertexOne) {
		this.vertexOne = vertexOne;
	}
	public Integer getVertexTwo() {
		return vertexTwo;
	}
	public void setVertexTwo(Integer vertexTwo) {
		this.vertexTwo = vertexTwo;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
