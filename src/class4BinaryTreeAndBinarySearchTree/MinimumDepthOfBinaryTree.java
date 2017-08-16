package class4BinaryTreeAndBinarySearchTree;
/**
 * 
 * @author @Yifeng
 * Given a binary tree, find its minimum depth. The minimum depth is the number of nodes
   along the shortest path from the root node down to the nearest leaf node.

Example:
Given the below binary tree

             5

          /       \

        3         8

           \

               4

minimum depth is 2,path is 5¡ú8.
 */
public class MinimumDepthOfBinaryTree {
	  public int minDepth(TreeNode root) {
	    if (root == null) {
	      return 0;
	    }
	    int left = minDepth(root.left);
	    int right = minDepth(root.right);
	    
	    if (left != 0 && right != 0) {
	      return Math.min(left, right) + 1;
	    } else if (left == 0 || right == 0) {
	      return left == 0 ? right + 1 : left + 1;
	    }
	    return 1; // if left and right both == 0
	  }
	}
