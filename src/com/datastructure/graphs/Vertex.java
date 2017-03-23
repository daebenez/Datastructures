package com.datastructure.graphs;

/**
 * @author daebenez
 * Vertex class that is part of a graphs
 * Has attributes data, isVisited, parent, distance.
 */
 
 class Vertex {
	int data;
	boolean isVisited;
	Vertex parent;
	int distance;
	
	public Vertex(int data) {
		this.data = data;
		this.isVisited = false;
		this.parent = null;
		this.distance = 0;
	}

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	public Vertex getParent() {
		return parent;
	}
	public void setParent(Vertex parent) {
		this.parent = parent;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}

	
	
}