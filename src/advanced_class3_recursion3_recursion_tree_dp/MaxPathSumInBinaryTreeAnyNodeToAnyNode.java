package advanced_class3_recursion3_recursion_tree_dp;
/*
 * basic idea: Three Step in Binary Tree
 * 		step 1: what to get from lchild / rchild?
 * 					Max single path in left subtree(1)
 * 					Max single path in right subtree(2)
 *		step 2: what to do in current layer?
 *					update globalMax  = left + right + root.key if feasible
 *		step 3: what to report to the parent?
 *					usually the return type of the recursion function (what step1 get is what step3 report)
 *						here is max single path Math.max(left + right) + root.key
 */

/*
 * solution 1: bottom-to-up 
 * 			basic idea: Three Step Process
 * 	Time complexity = O(n). we have n nodes and each one needs traversing
 *  Space = O(height) = O(n) for worst case
 */
public class MaxPathSumInBinaryTreeAnyNodeToAnyNode {
	class TreeNode {
		private int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	private int globalMax = Integer.MIN_VALUE;
	public int maxPath(TreeNode root) {
		if(root == null) {
			return 0;
		}
		helper(root);
		return globalMax;
	}
	private int helper(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		//step1: get something from lchild / rchild
		//filter negative contribution
		int left = Math.max(0, helper(root.left));
		int right = Math.max(0, helper(root.right));
		
		//check if root has child or not
		if(root.left != null && root.right != null) { 
			globalMax = Math.max(globalMax, left + right + root.val); //step 2
			return Math.max(left, right) + root.val; //step 3
		}
		globalMax = root.left == null ? Math.max(right + root.val, globalMax) : Math.max(left + root.val, globalMax); //step 2
		return root.left == null ? right + root.val : left + root.val; //step 3
	}
}
