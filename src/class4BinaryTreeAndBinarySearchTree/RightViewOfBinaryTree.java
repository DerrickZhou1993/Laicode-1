package class4BinaryTreeAndBinarySearchTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author @Yifeng
 * Given a Binary Tree, return the right view of it. Right view of a Binary Tree is list of nodes 
 * visible when tree is visited from Right side, the order of the nodes in the list should be from 
 * top to bottom level of the original tree.

Examples:
           1
        /    \
       2      3
      / \    /  \
     4   5   6  7
    /            \
    9             8

  /  \

 10  11

the right view =  [1, 3, 7, 8, 11]
 */

/*
 * basic idea : BFS1
 * 			use a deque to view the last element of each layer
 * 			pay attention when offer node to deque we need to use
 * 		    offerLast()
 */
public class RightViewOfBinaryTree {
	public List<Integer> rightView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offerFirst(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			result.add(deque.peekLast().key);
			for (int i = 0; i < size; i++) {
				TreeNode cur = deque.pollFirst();
				if (cur.left != null) {
					deque.offerLast(cur.left);
				}
				if (cur.right != null) {
					deque.offerLast(cur.right);
				}
			}
		}
		return result;
	}
}
