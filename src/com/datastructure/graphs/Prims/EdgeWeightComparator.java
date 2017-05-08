package com.datastructure.graphs.Prims;
import java.util.Comparator;
/**
 * Helper class to create Comparator to compare edgeweightWrapper instances by weight.
 * @author daebenez
 */

public class EdgeWeightComparator implements Comparator<EdgeWeightWrapper> {
		@Override
		public int compare(EdgeWeightWrapper e1,EdgeWeightWrapper e2)
		{
			return e1.getWeight() - e2.getWeight();
		}
}
