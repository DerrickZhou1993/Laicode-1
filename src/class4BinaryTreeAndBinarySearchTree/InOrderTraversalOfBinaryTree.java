package class4BinaryTreeAndBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author @Yifeng
 * Implement an iterative, in-order traversal of a given binary tree, 
 * return the list of keys of each node in the tree as it is in-order traversed.

	Examples
	
	        5
	
	      /    \
	
	    3        8
	
	  /   \        \
	
	1      4        11
	
	In-order traversal is [1, 3, 4, 5, 8, 11]
	
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




class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int key) {
		this.key = key;
	}
}
 
public class InOrderTraversalOfBinaryTree {
	public List<Integer> inOrder(TreeNode root) {
	    // Write your solution here.
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result;
		}
		List<Integer> left = inOrder(root.left);
		List<Integer> right = inOrder(root.right);
		result.addAll(left);
		result.add(root.key);
		result.addAll(right);
	    return result;
	  }
}
