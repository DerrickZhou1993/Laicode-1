package TAclass8_DP;

import java.util.Arrays;

/**
 * 
 * @author @Yifeng
 *Given an unsorted array of integers, find the length of longest increasing subsequence.

	For example,
	Given [10, 9, 2, 5, 3, 7, 101, 18],
	The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
	Note that there may be more than one LIS combination, it is only necessary for you to return the length.
	
	Your algorithm should run in O(n2) complexity.
	
	Follow up: Could you improve it to O(n log n) time complexity?
 */
/*
 *  dp[i] represents length of longest increasing sequence from 0th to ith (including ith eleement)
 *  
 *  induction rule
 *  		dp[i] = Math.max(dp[j] + 1, dp[i]) if nums[j] < nums[i] where 0 <= j <= i
 *  else    dp[i] = 1;
 *  
 *  time = O(n ^ 2)
 *  space = O(n)
 */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int globalMax = 1;
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);  // default value of dp should be set as 1
		// base case
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);    // eg: 7 8 9 2 3 15
					                                       //dp[5] = 4 and cannot covered by 2 3 15 which is only 3
				}
			}
			globalMax = Math.max(dp[i], globalMax); // update globalMax with each dp[i] to find the longest length of LIS
		}
		return globalMax;
	}
	
	
	/*
	 * sol1: for for loop to check if there
	 * exists nums[j] before nums[i] that is smaller than nums[i]
	 * but use boolean flag is a liite bit complex and easy to have bug
	 */
//	public int lengthOfLIS(int[] nums) {
//		if (nums == null || nums.length == 0) {
//			return 0;
//		}
//		int result = 1;
//		int[] dp = new int[nums.length]; // represents LIS from 0th to ith (including ith element)
//		dp[0] = 1;
//		for (int i = 1; i < nums.length; i++) {
//			boolean existed = false; // check if there exists number which before nums[i] is smaller than it;
//			for (int j = 0; j < i; j++) {
//				if (nums[j] < nums[i]) {
//					existed = true;
//					dp[i] = Math.max(dp[j] + 1, dp[i]);
//				}
//				if (!existed) {
//					dp[i] = 1;
//				}
//			}
//			result = Math.max(result, dp[i]);
//		}
//		return result;
//	}
}
