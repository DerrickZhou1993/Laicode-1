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

		//Iterative method:
		/*
		 * the essence of post order of BST by iteration is the direction
		 * are we going down or going up from left subtree or going up from right subtree?
		 * maintain a previous Node which is the last traversed node in last iteration, to 
		 * record the previous visiting node in the traversing path, so that we know what the 
		 * direction we are taking now and what is the direction we are taking next
		 * 
		 * steps: stack.offer(root)
		 * 		  if prev is null(cur is root)  -> going down(left tree has priority)
		 * 		  if prev is current's parent -> going down(left tree has priority)
		 * 		  if prev is current's left  -> left subtree finished, going current.right if existed,if not existed,pop current and going up
		 * 	      if prev is current's right -> right subtree finished, pop current, going up
		 */
	public List<Integer> postOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		TreeNode prev = null;
		while(!stack.isEmpty()) {
			TreeNode current = stack.peekFirst();//just initialize cur node. DON'T POP STACK HERE!!!!!
			if(prev == null || current == prev.left || current  == prev.right) {//going down cases
				if(current.left != null) {//if going down, left subtree has priority
					stack.offerFirst(current.left);
				} else if(current.right != null) {
					stack.offerFirst(current.right);
				} else {//if we cannot go down on either way, we reach the leaf node
					stack.pollFirst();
					result.add(current.key);
				}
			} else if(prev == current.left) { //going up from left subtree
				if(current.right != null) {//means we have to go right afterwards
					stack.offerFirst(current.right);
				} else { // current node has no right child, keep going up
					stack.pollFirst();
					result.add(current.key);
				}
			} else {//going up from right subtree
				stack.pollFirst();
				result.add(current.key);
			}
			prev = current;//after each going down or going up, update last traversed node as prev
		}
		return result;
	}
}
