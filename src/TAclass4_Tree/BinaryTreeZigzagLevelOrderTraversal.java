package TAclass4_Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author yifengguo
 Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 (ie, from left to right, then right to left for the next level and alternate between).

	For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3             1
	   / \
	  9  20           2
	    /  \
	   15   7         3
	return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]
 */
/*
 * 		| 3
 *      | 9  20
 * 15  7|
 *      |
 *      
 *      level 3
 *      res 3
 *      
 *      time = O(n)
 *      space = O(n)
 * 
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> queue = new LinkedList<>();
		boolean odd = false;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				if (!odd) {
					TreeNode cur = queue.pollFirst();
                    level.add(cur.key);
					if (cur.left != null) {
						queue.offerLast(cur.left);
					}
					if (cur.right != null) {
						queue.offerLast(cur.right);
					}
                } else {
                    TreeNode cur = queue.pollLast();
                    level.add(cur.key);
                    if (cur.right != null) {
                        queue.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        queue.offerFirst(cur.left);
                    }
                }
			}
			odd = !odd;
			res.add(level);
		}
		return res;
	}
}