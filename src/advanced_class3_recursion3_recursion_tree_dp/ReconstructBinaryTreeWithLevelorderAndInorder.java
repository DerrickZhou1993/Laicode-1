package advanced_class3_recursion3_recursion_tree_dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
/*
 * Q3.3 given level-order and in-order sequence of all nodes, reconstruct the tree
								20
							    / \
							   8   22
							  / \   
							 4  12
							    / \
							   10  14
							   
		index:      0	1	2	3	4	5	6
		in-order:   4	8	10	12	14 |20 |22
		level-order:20	8	22	4	12	10	14
	
	Solution idea: for the tree may not be a BST, so we could not intuitively cut level order into two halves
				   so we need to use a HashSet to record what appear on the left side of 20(which is the first element 
				   in level order so it is radical root of tree)
				   
				   step 1: pick the 1st element from level-order, find the index of 20 in in-order sequence -> index = 5
				   		   Thus, in-order sequence can be correctly divided into two parts
				   		   Meanwhile, we can put all elements belonging to the left part into a HashSet = {4,8,10,12,14}
				   		   
				   step 2: Divide the level-order into two parts
				   Iterate over each element in the level-order, and check each one against the HashSet. If it is in the HashSet,
				   we put it into the left part
				   as the new level-order for the recursion function
				   
				   Time Complexity = O(n * height) = O(n ^ 2) for worst case
				   Space Complexity = O(n ^ 2) for we have to allocate two temporary lists in each level
 */
public class ReconstructBinaryTreeWithLevelorderAndInorder {
	public TreeNode reconstruct(int[] in, int[] level) {
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			indexMap.put(in[i], i);
		}
		List<Integer> levelList = new ArrayList<>();
		for (int i = 0; i < level.length; i++) {
			levelList.add(level[i]);
		}
		TreeNode root = helper(in, 0, in.length - 1, levelList, indexMap);
		return root;
	}

	private TreeNode helper(int[] in, int inLeft, int inRight, List<Integer> level, Map<Integer, Integer> indexMap) {
		if (inLeft > inRight) {
			return null;
		}
		TreeNode root = new TreeNode(level.get(0));
		int rootIndex = indexMap.get(root.key);
		Set<Integer> leftSubTree = new HashSet<>();
		for (int i = inLeft; i < rootIndex; i++) {
			leftSubTree.add(in[i]);
		}
		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();

		for (int i = 1; i < level.size(); i++) {
			if (leftSubTree.contains(level.get(i))) {
				leftList.add(level.get(i));
			} else {
				rightList.add(level.get(i));
			}
		}

		root.left = helper(in, inLeft, rootIndex - 1, leftList, indexMap);
		root.right = helper(in, rootIndex + 1, inRight, rightList, indexMap);
		return root;
	}
}

