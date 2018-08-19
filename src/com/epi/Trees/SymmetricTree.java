package com.epi.Trees;

public class SymmetricTree {
	
	public static boolean isSymmetric(TreeNode root)
	{
		return helper(root.left, root.right);
	}
	
	private static boolean helper(TreeNode root1, TreeNode root2)
	{
		if(root1==null && root2==null)
		{
			return true;
		}
		if(root1==null || root2==null || root1.val != root2.val)
		{
			return false;
		}
		
		boolean left = helper(root1.left, root2.right);
		boolean right = helper(root1.right, root2.left);
		
		return (left && right);
	}

}
