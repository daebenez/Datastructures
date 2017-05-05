package com.datastructure.graphs.Djikstra;

import java.util.Comparator;

public class VertexWeightComparator implements Comparator<VertexWeightWrapper>{
	@Override
	public int compare(VertexWeightWrapper v1,VertexWeightWrapper v2)
	{
		return v1.getWeight() - v2.getWeight();
	}

}
