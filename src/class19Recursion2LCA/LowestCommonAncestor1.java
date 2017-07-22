package class19Recursion2LCA;

/**
 * 
 * @author @Yifeng
 * Given two nodes in a binary tree, find their lowest common ancestor.

	Assumptions
	
	There is no parent pointer for the nodes in the binary tree
	
	The given two nodes are guaranteed to be in the binary tree
	
	Examples
	
	        5
	
	      /   \
	
	     9     12
	
	   /  \      \
	
	  2    3      14
	
	The lowest common ancestor of 2 and 14 is 5
	
	The lowest common ancestor of 2 and 9 is 9
 */
public class LowestCommonAncestor1 {
	class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int key) {
			this.key = key;
		}
	}
	/*
	 * to do the binary tree recursion problem when needing something from bottom to up
	 * follow three steps:
	 * 			1. What to get from child nodes?
	 * 			2. What process to do in the current layer?
	 * 			3. What to report to the parent
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		//Base case
		if(root == null || root == one || root == two) { //if root == null or found one or found two
			return root;
		}

		//step1 get something from child
		//left and right means what returned from left child and right child
		TreeNode left = lowestCommonAncestor(root.left,one,two);
		TreeNode right = lowestCommonAncestor(root.right,one,two);

		//step2 process in the current recursion layer
		//case 1:
		if(left == null && right == null) { //if left and right are both not null, meaning they are not in the subtree
			return null;                    //left or right is no child to another
		} else if (left == null || right == null) { // case 2: left and right is in the subtree, one of which is parent to another 
			return left == null ? right : left;     //child will never be returned, return parent directly
		}
		//case 3 
		return root; // current root is the LCA of a and b
	}
}
