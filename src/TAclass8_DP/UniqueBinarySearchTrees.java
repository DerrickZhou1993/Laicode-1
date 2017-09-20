package TAclass8_DP;
/**
 * 
 * @author guoyifeng
 	Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

	For example,
	Given n = 3, there are a total of 5 unique BST's.
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
 */

/*
 * basic idea: DP
 * 		M[i] represents number of unique BST which can be built by i roots
 * 		base case
 * 			when root number = 0, null is bst  => M[0] = 1
 * 			when root number = 1, 1 is bst  => M[1] = 1
 *          when root number = 2, 1->2, 2->1, => M[2] = 2
 *          
 *          root number = 3
 *             1                      2                    3
 *            /  \                 /   \                 /   \
 *           M[0] * M[2]          M[1] * M[1]          M[2] * M[0]
 *           
 *          And for each root, its left sub-bst and right sub-bst are independent cases
 *          so induction rule is
 *          			for (i = 3, i <=n, i++)
 *          			M[i] = sum(M[j - 1] * M[i - j])  for (j = 1; j<=i ;j++) 
 *          
 *          time = O(n ^ 2)
 *          space = O(n)
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if (n <= 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		// base case
		dp[0] = 1; // null is BST as well
		dp[1] = 1;
		dp[2] = 2;
		// induction rule
		for (int i = 3; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += (dp[j - 1] * dp[i - j]);
			}
		}
		return dp[n];
	}
}
