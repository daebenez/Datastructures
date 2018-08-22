package com.epi.Trees;
import java.util.*;
public class IterativeTraversalIO {
	
	public static List<TreeNode> traverse(TreeNode root)
	{
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode curr = root;
		List<TreeNode> result = new ArrayList<>();
		while(!stack.isEmpty() || curr!=null)
		{
			if(curr!=null)
			{
				stack.push(curr);
				curr=curr.left;
			}
			else
			{
				curr = stack.pop();
				result.add(curr);
				curr = curr.right;
			}
		}
		return result;
	}

}
