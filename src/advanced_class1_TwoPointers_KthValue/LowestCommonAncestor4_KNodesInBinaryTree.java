package advanced_class1_TwoPointers_KthValue;

import java.util.List;

/**
 * 
 * @author guoyifeng
 * Given K nodes in a binary tree, find their lowest common ancestor.

	Assumptions
	
	K >= 2
	
	There is no parent pointer for the nodes in the binary tree
	
	The given K nodes are guaranteed to be in the binary tree
	
	Examples
	
	        5
	
	      /   \
	
	     9     12
	
	   /  \      \
	
	  2    3      14
	
	The lowest common ancestor of 2, 3, 14 is 5
	
	The lowest common ancestor of 2, 3, 9 is 9


 */
public class LowestCommonAncestor4_KNodesInBinaryTree {
	class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int key) {
			this.key = key;
		}
	}
	//the same step as LCA1
	public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		if(root == null || nodes.contains(root)) {
			return root;
		}
	
		TreeNode left = lowestCommonAncestor(root.left, nodes);//step 1
		TreeNode right = lowestCommonAncestor(root.right, nodes);

		if(left != null && right != null) { //step 2 + step 3
			return root;//return c if left and right are both not null
		}
		return left == null ? right : left; //return one of the node which is not null
	}
}
