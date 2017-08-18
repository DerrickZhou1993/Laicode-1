package class4BinaryTreeAndBinarySearchTree;
/**
 * 
 * @author @Yifeng
 * Find distance between two given keys of a Binary Tree, no parent pointers are given. 
 * Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.

	Assumptions:
	
	There are no duplicate keys in the binary tree.
	The given two keys are guaranteed to be in the binary tree.
	Examples:
	
	    1
	
	   /  \
	
	  2    3
	
	 / \  /  \  
	
	4   5 6   7
	
	       \
	
	         8
	
	distance(4, 5) = 2
	
	distance(4, 6) = 4
 */

// basic idea:
// distance of two nodes = distance(a,root) + distance(b,root) - 2 * distance(root, lca)
// time = O(n)
public class DistanceOfTwoNodesInBinaryTree {
	public int distance(TreeNode root, int a, int b) {
		TreeNode lca = getLCA(root, a, b);
		int dist1 = getDepth(root, a);
		int dist2 = getDepth(root, b);
		int dist3 = getDepth(root,lca.key);
		return (dist1 + dist2) - 2 * dist3;
	}

	// classical LCA algorithm
	private TreeNode getLCA(TreeNode root, int a, int b) {
		if (root == null || root.key == a || root.key == b) {
			return root;
		}
		// step 1: get something from child
		TreeNode left = getLCA(root.left, a, b);
		TreeNode right = getLCA(root.right, a, b);
		
		// step 2: current layer process + step 3 : report ro parent
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}
	
	// classical get depth with given node algorithm
	private int getDepth(TreeNode root, int target) {
		if (root == null) {
			return -1;
		}
		if (root.key == target) {
			return 0;
		}
		int left = getDepth(root.left, target);
		int right = getDepth(root.right, target);

		if (left == -1 && right == -1) {
			return -1;
		}
		return left == -1 ? right + 1 : left + 1;
	}
}
