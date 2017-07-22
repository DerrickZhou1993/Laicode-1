package advanced_class1_TwoPointers_KthValue;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author guoyifeng
 * Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.

	Assumptions
	
	There is parent pointer for the nodes in the binary tree
	
	The given two nodes are not guaranteed to be in the binary tree
	
	Examples
	
	        5
	
	      /   \
	
	     9     12
	
	   /  \      \
	
	  2    3      14
	
	The lowest common ancestor of 2 and 14 is 5
	
	The lowest common ancestor of 2 and 9 is 9
	
	The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
 */



// 	    1
//     / \
//    2    3
//   /    / \
//  4    6   7
public class LowestCommonAncestor2_ParentPointerOffered {
	class TreeNodeP {
		public int key;
		public TreeNodeP left;
		public TreeNodeP right;
		public TreeNodeP parent;

		public TreeNodeP(int key, TreeNodeP parent) {
			this.key = key;
			this.parent = parent;
		}
	}
	//basic idea: apply a hashset to store one node's parents to check LCA is found or not
	public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		Set<TreeNodeP> parents = new HashSet<>();
		while (one != null) {
			parents.add(one);
			one = one.parent;
		}
		while (two != null) {
			if (!parents.contains(two)) {
				// set.add(two);//do not need to add two's parents
				two = two.parent;
			} else {
				return two;//current parent is in the parents set, return it as LCA 
			}
		}
		return null;
	}
}
