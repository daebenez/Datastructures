package com.epi.Trees;
import java.util.*;

public class RootToLeaf {
	
	public static int rootToLeaf(TreeNode root)
	{
		return helper(root,0);
	}
	
	 private static int helper(TreeNode root, int runningSum)
		{
			if(root==null)
			{
				return 0;
			}
	        runningSum = (runningSum * 10) + root.val;
			if(root.left==null && root.right==null)
			{
	            return runningSum;
			}
			int left = helper(root.left,runningSum);
			int right = helper(root.right,runningSum);
	        return left+right;
		}
}
