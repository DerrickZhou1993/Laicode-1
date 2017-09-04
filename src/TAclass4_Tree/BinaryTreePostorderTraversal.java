package TAclass4_Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a binary tree, return the postorder traversal of its nodes' values.

	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [3,2,1].


 */
public class BinaryTreePostorderTraversal {
	/*
	 * sol 1: use one stack
	 */
	
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
	 * 
	 *            4
			     / \
			    2   7                
			   / \ / \
		      1  3 6  9
		
			stack || 4 7 9
			cur 9
			prev 7
	        res 1 3 2 6 9 7 4
	        
	        time = O(n)
	        space = O(n)

	 */
	public List<Integer> postOrder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
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
					res.add(stack.pollFirst().key);
				}
			} else if(prev == current.left) { //going up from left subtree
				if(current.right != null) {//means we have to go right afterwards
					stack.offerFirst(current.right);
				} else { // current node has no right child, keep going up
					res.add(stack.pollFirst().key);
				}
			} else {//going up from right subtree
				res.add(stack.pollFirst().key);
			}
			prev = current;//after each going down or going up, update last traversed node as prev
		}
		return res;
	}

	/*
	 * sol2: use two stacks
				step1: initialize two stacks(stack1 and stack2), push root into stack1
				step2: pop TreeNode from stack1 and push it into stack2 then push its left and right child into stack1(reverse pushing order of preorder)
				step3: iterate the process until stack1 is empty
			this basic idea is if we push child of root into stack in the reverse order we do it in preorder and then we reverse the whole 
			res(stack2.pop()), we could get postorder traversal of binary tree
			
			TreeNodes pop from stack2 will build the postorder traversal of binary tree
	 
	      4
	     / \
	    2   7                
	   / \ / \
      1  3 6  9

	stack1 ||
	stack2 ||4 7 9 6 2 3 1
	
	postorder: 1 3 2 6 9 7 4

	 	time = O(2n)
	 	space = O(2n)
	 */
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack1 = new LinkedList<>();
		Deque<TreeNode> stack2 = new LinkedList<>();
		stack1.push(root);
		while (!stack1.isEmpty()) {
			TreeNode cur = stack1.pop();
			stack2.push(cur);
			if (cur.left != null) {
				stack1.push(cur.left);
			}
			if (cur.right != null) {
				stack1.push(cur.right);
			}
		}
		while (!stack2.isEmpty()) {
			res.add(stack2.pop().key);
		}
		return res;
	}
}

