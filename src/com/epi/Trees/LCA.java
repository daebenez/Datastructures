package com.epi.Trees;

public class LCA {
	
	public static TreeNode findLCA(TreeNode root,TreeNode t1,TreeNode t2)
	{
		if(root==null || root==t1 || root==t2) return root;
		
		TreeNode left = findLCA(root.left,t1,t2);
		TreeNode right = findLCA(root.right,t1,t2);
		
		return (left!=null && right!=null)? root:(left==null)? right: left;
	}

}
