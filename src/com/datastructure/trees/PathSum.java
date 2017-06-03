package com.datastructure.trees;
/**
 * Program to calculate number of paths that sum to a given total in a binary tree.
 * The paths go from top to bottom and do not have to start at the root or end at a leaf.
 * @author daebenez
 * Time Complexity : O(N log N) Starts of as DFS and uses a for loop to visit nodes again.
 * Space Complexity : O(N) use of an extra string
 */
public class PathSum {
	
	public void recursiveSum(BinaryNode root,String path,int currSum,int target)
	{
		if(root==null)
		{
			return;
		}
		
		currSum += root.getVal();
		path = path + root.getVal();
		// If current sum from root is equal to the target print out the path.
		if(currSum==target)
		{
			System.out.println(path);
		}
		// If current sum if greater delete each node from top to see if any sum equals target.
		else if(currSum > target)
		{
		  String newPath = path;
		  int newCurrSum = currSum;
		  
		  for(int i=0;i<path.length();i++)
		  {
			  newCurrSum = newCurrSum - Integer.parseInt(""+newPath.charAt(i));
			  if(newCurrSum == target)
			  {
				  System.out.println(newPath.substring(i+1));
			  }
		  }
		  
		}
		
		recursiveSum(root.getLeft(), path, currSum, target);
		recursiveSum(root.getRight(), path, currSum, target);
	}
	
	/*
	public static void main(String[] args)
	{
		BinaryNode one = new BinaryNode(1);
		BinaryNode oone = new BinaryNode(1);
		BinaryNode ooone = new BinaryNode(1);
		BinaryNode oooone = new BinaryNode(1);
		BinaryNode two = new BinaryNode(2);
		BinaryNode twoo = new BinaryNode(2);
		BinaryNode twooo = new BinaryNode(2);
		
		BinaryNode three = new BinaryNode(3);
		BinaryNode threee = new BinaryNode(3);
		BinaryNode threeee = new BinaryNode(3);
		BinaryNode four = new BinaryNode(4);
		BinaryNode five = new BinaryNode(5);
		BinaryNode six = new BinaryNode(6);
		BinaryNode minusOne = new BinaryNode(1);
		
		one.setLeft(two);
		one.setRight(oone);
		two.setLeft(ooone);
		two.setRight(oooone);
		
		oone.setLeft(twoo);
		oone.setRight(twooo);
		
		PathSum obj = new PathSum();
		obj.recursiveSum(one, "", 0, 3);
	} */
}
