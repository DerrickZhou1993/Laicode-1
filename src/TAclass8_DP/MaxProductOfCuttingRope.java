package TAclass8_DP;
/**
 * 
 * @author guoyifeng
 	Given a rope with positive integer-length n, how to cut the rope into m 
 	integer-length parts with length p[0], p[1], ...,p[m-1], in order to get 
 	the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you and must 
 	be greater than 0 (at least one cut must be made). Return the max product you can have.

	Assumptions
	
	n >= 2
	Examples
	
	n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).
 */
/*
 * time = O(n ^ 2)
 * space = O(n)
 */
public class MaxProductOfCuttingRope {
	public int maxProduct(int n) {
		if (n <= 1) {
			return 0;
		}
		// dp[i] represents max product given i meters rope (at least one cut made)
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		for (int i = 2; i < dp.length; i++) {  // rope length grow from 1
			for (int j = 1; j < i; j++) { 
				// j is left bigger section, i - j is right smaller section
				dp[i] = Math.max(Math.max(dp[j], j)*(i - j), dp[i]);
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 12;
		int max = new MaxProductOfCuttingRope().maxProduct(n);
		System.out.println(max);
	}
}
