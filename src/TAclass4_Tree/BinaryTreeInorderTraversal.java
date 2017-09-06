package TAclass4_Tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
/**
 * 
 * @author yifengguo
 	Given a binary tree, return the inorder traversal of its nodes' values.

	For example:
	Given binary tree [1,null,2,3],
	   1
	    \
	     2
	    /
	   3
	return [1,3,2].
 */

/*
 * iteration:
			step1: new a Stack, initialize cur pointing to root
			step2: as long as cur.left exists, keep pushing left child
			step3: if no left child exists , stack.pop() and let cur point to right child
			step4: keep iterating until cur == null || stack is empty
 */
/*
 * 		4
	   / \
	  2   7                
	 / \ / \
    1  3 6  9
    
 stack ||   empty
       cur  null
       res  1 2 3 4 6 7 9
    
 * time = O(n)
 * space = O(n)
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				res.add(cur.key);
				cur = cur.right;
			}
		}
		return res;
	}
}
