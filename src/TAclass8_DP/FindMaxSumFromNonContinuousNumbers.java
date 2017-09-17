package TAclass8_DP;
/**
 * 
 * @author @Yifeng
 * given an array, find the max sum without choosing any continuous two numbers
 * [1, 2, 3, 4, 5]  ---> 9
 * 
 */

/*
 * Time = O(n)
 * Space = O(n)
 * M[i] represents from 0th to ith the max sum we can have
 * 
 * base case:
 * 		M[0] = array[0], M[1] = max(array[0], array[1])
 * 
 * induction rule:
 *		M[i] = 
 *	max(
 * 		M[i - 1] (not choose array[i]),
 * 		M[i - 2] + array[i] (choose array[i])
 *      )
 * 
 * assumption: the array only contains positive integers
 * 
 * 
 * follow up1: how to only use O(1) space?
 */
public class FindMaxSumFromNonContinuousNumbers {
//	public int getMax(int[] array) {
//		int[] dp = new int[array.length];
//		dp[0] = array[0];
//		dp[1] = Math.max(array[0], array[1]);
//		for (int i = 2; i < array.length; i++) {
//			dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i]);
//		}
//		return dp[array.length - 1];
//	}
	
	public int getMax(int[] array) {
		int prev = array[0];
		int cur = Math.max(array[0], array[1]);
		for (int i = 2; i < array.length; i++) {
			int tmp = Math.max(prev + array[i], cur);
			prev = cur;
			cur = tmp;
		}
		return cur;
	}
	
	/*
	 * follow up 2: what if the array is circular array so that 1 and 5 cannot be chosen at the same time
	 * 	the problem could convert to choose 1 or not choose 1
	 * 	if choose 1:
	 * 		do getMax() on 1 2 3 4
	 *  if not choose 1
	 *  	do getMax() on 2 3 4 5
	 */
	
	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 3, 4, 5};
		int res = new FindMaxSumFromNonContinuousNumbers().getMax(array);
		System.out.print(res);
	}
}
