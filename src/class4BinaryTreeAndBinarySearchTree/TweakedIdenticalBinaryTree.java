package class4BinaryTreeAndBinarySearchTree;

/**
 * 
 * @author @Yifeng
 *  Determine whether two given binary trees are identical assuming any number of ¡®tweak¡¯s are allowed. 
 *  A tweak is defined as a swap of the children of one node in the tree.

	Examples
	
	        5
	
	      /    \
	
	    3        8
	
	  /   \
	
	1      4
	
	and
	
	        5
	
	      /    \
	
	    8        3
	
	           /   \
	
	          1     4
	
	the two binary trees are tweaked identical.
	
	How is the binary tree represented?
	
	We use the level order traversal sequence with a special symbol "#" denoting the null node.
	
	For Example:
	
	The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
	
	    1
	
	  /   \
	
	 2     3
	
	      /
	
	    4
 */
/*
 * this question is quite similar to isSymmetrical question
 * what should notice is also check the node's key. two nodes' key may be equal for the moment when recursion 
 * arrives this pair of nodes, but the function cannot return this early because we do not know the condition 
 * below this pair of roots. 
 * 
 * So we need to find if there exists a pair whose keys are not equal instead of
 * whose keys are equal to end the recursion function!!!
 */
public class TweakedIdenticalBinaryTree {
	public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
		if(one == null && two == null) {
			return true;
		} else if(one == null || two == null) {
			return false;
		} else { //one and two are both not null
			if(one.key != two.key) { //notice: cannot use one.key == two.key return true because the child nodes should be checked as well!!!
				return false;
			}
		}
		// two conditions both are identical structure which match this question's assumption
		return isTweakedIdentical(one.left,two.right) && isTweakedIdentical(one.right,two.left)  //symmetrical condition
				||
				isTweakedIdentical(one.left,two.left) && isTweakedIdentical(one.right,two.right);// identical condition
	}
}
