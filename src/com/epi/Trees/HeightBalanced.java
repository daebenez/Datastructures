package com.epi.Trees;

public class HeightBalanced {
	
	public static boolean isBalanced(TreeNode root)
	{
		int result = helper(root);
		return result!=Integer.MIN_VALUE;
	}
	
	public static int helper(TreeNode root)
	{
		if(root==null)
		{
			 return 0;
		}
		
		int left = helper(root.left);
		int right = helper(root.right);
		
		if(left==Integer.MIN_VALUE || right==Integer.MIN_VALUE)
		{
			return Integer.MIN_VALUE;
		}
		if(Math.abs(left-right)>1)
		{
			return Integer.MIN_VALUE;
		}
		return 1+Math.max(left,right);
	}

}
