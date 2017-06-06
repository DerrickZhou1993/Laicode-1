package class4BinaryTreeAndBinarySearchTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author @Yifeng
 * Implement an iterative, pre-order traversal of a given binary tree, 
 * return the list of keys of each node in the tree as it is pre-order traversed.

	Examples
	
	        5
	
	      /    \
	
	    3        8
	
	  /   \        \
	
	1      4        11
	
	Pre-order traversal is [5, 3, 1, 4, 8, 11]
	
	Corner Cases
	
	What if the given binary tree is null? Return an empty list in this case.
	How is the binary tree represented?
	
	We use the level order traversal sequence with a special symbol "#" denoting the null node.
	
	For Example:
	
	The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
	
	    1
	
	  /   \
	
	 2     3
	
	      /
	
	    4
 */
public class PreOrderTraversalOfBinaryTree {
	/*
	 * iterative method
	 */
	public List<Integer> preOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		if(root == null) {
			return result;
		}
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			if(cur.right != null) {
				stack.push(cur.right); //because stack is FILO, so we need to push right subtree befor pushing left subtree
			}
			if(cur.left != null) {
				stack.push(cur.left);
			}
			
			result.add(cur.key);
			
		}
		return result;
	}
	
	/*
	 * recursive method
	 */
//	public List<Integer> preOrder(TreeNode root) {
//		List<Integer> result = new ArrayList<>();
//		if(root == null) {
//			return result;
//		}
//		List<Integer> left = preOrder(root.left);
//		List<Integer> right = preOrder(root.right);
//		result.add(root.key);
//		result.addAll(left);
//		result.addAll(right);
//		return result;
//	}
}
