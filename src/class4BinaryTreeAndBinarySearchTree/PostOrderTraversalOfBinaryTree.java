package class4BinaryTreeAndBinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostOrderTraversalOfBinaryTree {
	/*
	 * method1: post-order is the reverse order of the  pre-order traversing right subtree 
	 * 			before traversing left subtree, so just change the addition order in pre-order traversal
	 * 
	 * post-order: left right root
	 * pre-order: root left right    ->  root right left  reverse order of post-order traversal
	 * 
	 */
//	public List<Integer> postOrder(TreeNode root) {
//		List<Integer> result = new ArrayList<>();
//		Deque<TreeNode> stack = new LinkedList<>();
//		if (root == null) {
//			return result;
//		}
//		stack.offerFirst(root);
//		while (!stack.isEmpty()) {
//			TreeNode cur = stack.pollFirst();
//			if (cur.left != null) {
//				stack.offerFirst(cur.left);
//			}
//			if (cur.right != null) {
//				stack.offerFirst(cur.right);
//			}
//			result.add(cur.key);
//		}
//		Collections.reverse(result);
//		return result;
//	}
	
	public List<Integer> postOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		
		return result;
	}
	
	
	
}
