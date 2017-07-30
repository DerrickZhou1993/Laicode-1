package advanced_class3_recursion3_recursion_tree_dp;


/**
 * 
 * @author @Yifeng
 * Given a binary tree in which each node contains an integer number. 
 * Find the maximum possible subpath sum(both the starting and ending node of the subpath 
 * should be on the same path from root to one of the leaf nodes, and the subpath is allowed to contain only one node).

	Assumptions
	
	The root of given binary tree is not null
	Examples
	
	   -5
	
	  /    \
	
	2      11
	
	     /    \
	
	    6     14
	
	           /
	
	        -3
	
	The maximum path sum is 11 + 14 = 25
	
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

/*
			10
		   /  \	
		  -2 bp   7
		 /  \
		8   -4 = cur
		Prefix_of_path = {10, -2, 4}	
		max = 10 + 7 = 17
		1. maintain a prefixSum to record current sum
		2. maintain globalMax, only when we get to leaf node can we 
		   update the globalMax
 */
public class MaximumPathSumBinaryTree3RootToLeafPath {
	class TreeNode {
		private int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}
	/*
	 * solution 1: three steps
	 */
	private int globalMax = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int prefixSum = 0;
		helper(root);
		return globalMax;
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}

		// step1
		int left = Math.max(helper(root.left), 0);
		int right = Math.max(helper(root.right), 0);
		//step2
		int singleMax = Math.max(left, right) + root.key;
		globalMax = Math.max(globalMax, singleMax);
		//step3
		return singleMax;
	}
	
	/*
	 * solution 2: straight up and down
	 * 			maintain a prefixSum
	 * if question needs root to leaf, just change the return condition to 
	 * return when we reach the leaf node
	 */
	public int maxPathSumSol2(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int prefixSum = 0;
		helper(root, prefixSum);
		return globalMax;
	}
	private void helper(TreeNode root, int prefixSum) {
		if(root == null) {
			return; 
		}
		//only when we arrive the leaf node can we 
		//have right to update and return globalMax
		globalMax = Math.max(globalMax, Math.max(0, prefixSum) + root.key);
		//traverse all the straight up and down paths
		helper(root.left, Math.max(0, prefixSum) + root.key);
		helper(root.right,Math.max(0, prefixSum) + root.key);
	}
}
