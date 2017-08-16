package finalExam;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author @Yifeng
 *  check if two nodes are cousins in a binary tree
 *  Given the binary tree and the two nodes say 'a' and 'b', determine whether
 *  the two nodes are cousins of each other or not
 *  
 *  Two nodes are cousins of each other if they are at smae level and have different
 *  parents
 *  
 *  Example:
 *  	   6
 *       /   \
 *      3     5
 *     / \   / \
 *    7  8   1  2
 *    
 *       7 and 1, result is true
 *       3 and 5, result is false
 *       7 and 5, result is false
 */

class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int key;
	public TreeNode(int key) {
		this.key = key;
	}
}

/*
 * basic idea: 
 * 	solution 1:
 * 		when face with check nodes on the same level, we could use bfs
 *  solution 2:
 *  	three step dfs could also work
 */
public class CheckIsCousinInBinaryTree {
	// solution 1: 3 step dfs
	// time : O(n)
	// space : O(height)
	private boolean isCousin = false;
	public int dfs(TreeNode root, TreeNode a, TreeNode b, int level) {
		if (root == null) {
			return -1;
		}
		// base case
		if (root == a || root == b) {
			return level;
		}
		// step 1:
		int left = dfs(root.left, a, b, level + 1);
		int right = dfs(root.right, a, b, level + 1);
		
		// step 2
		// level means root's level, if root's level < left - 1
		// means a or b is not direct children of root, and since
		// they are on the same layer so they are cousins
		if (left == right && left - 1 > level) {
			isCousin = true;
		}
		
		// step 3 return something to upper layer
		// here we return greater one to filter -1 or if right and 
		// left are on the different layers
		return left > right ? left : right;
	}
	
	/*
	 *  solution 2: bfs
	 *  	time = O(n) for each node in the tree need scanning
	 *  	space = O(n) queue's size in worst case
	 */
	public boolean bfs(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			TreeNode parentA = null;
			TreeNode parentB = null;
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				// check left child of current node
				if (cur.left != null) {
					if(cur.left == a) {
						parentA = cur;
					} else if (cur.left == b) {
						parentB = cur;
					}
					queue.offer(cur.left);
				}
				// check right child of current node
				if (cur.right != null) {
					if (cur.right == a) {
						parentA = cur;
					} else if (cur.right == b) {
						parentB = cur;
					}
					queue.offer(cur.right);
				}
			}
			if (parentA != null && parentB != null && parentA != parentB) {
				return true;
			}
			// prune
			if (parentA == null || parentB == null) {
				return false;
			}
		}
		return false;
	}
}
