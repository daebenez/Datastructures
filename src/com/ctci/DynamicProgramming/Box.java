package com.ctci.DynamicProgramming;
/**
 * Pojo for Box Stacking problem
 * @author daebenez
 *
 */
public class Box implements Comparable<Box>{
	
	int length;
	int breadth;
	int height;
	
	public Box(int length, int breadth, int height) {
		super();
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public int compareTo(Box box2) {
		int area = box2.length*box2.breadth*box2.height;
		int areaThis = this.length*this.breadth*this.height;
		return area-areaThis;
	}
	
}
