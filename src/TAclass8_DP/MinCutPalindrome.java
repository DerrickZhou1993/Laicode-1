package TAclass8_DP;
/**
 * 
 * @author guoyifeng
 	Given a string s, partition s such that every substring of the partition is a palindrome.

	Return the minimum cuts needed for a palindrome partitioning of s.
	
	For example, given s = "aab",
	Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.


 */
/*
 * basic idea : DP using left bigger section and right smaller section
 * 			left bigger section:   cases which we have stored in the memory and can get
 * 					               the result O(1) time
 *          right smaller section: cases we need to enumerate, and when we find that right
 *                                 smaller case can form a valid part, we should update the 
 *                                 memory
 *          Demo for example string "ababb"
 *          M[i] represents minimum number of cuts from 0th character to i-th character (exclusive)  [0, i - 1] of string 
 *          
 *          
 *          case 4: abab  |              b
 *                  M[4]     right smaller section       for b is valid palindrome, so M[5] = Math.min(M[4] + 1, M[5])
 *          case 3: aba  |              bb
 *                  M[3]     right smaller section       for bb is valid palindrome, so M[4] = Math.min(M[3] + 1, M[4])
 *          case 2: ab  |              abb
 *                  M[2]     right smaller section       for abb is not valid palindrome, M[3] = default value
 *          case 1: a  |              babb
 *                  M[1]     right smaller section       for babb is not valid palindrome, M[2] = default value
 *          case 0:     |             ababb
 *                  M[0]     right smaller section       
 *                  
 *           base case:
 *           M[1] = 0 for single character is valid palindrome
 *           
 *           and what we need is M[5]
 *           
 *           this solution needs O(n ^ 3) time and O(n ^ 2) space
 */
public class MinCutPalindrome {
    public int minCut(String s) {
		if (s == null || s.length() <= 1) {
			return 0;
		}
		// M[i] represents minimum number of cuts from 0th character to i-th character (exclusive)  [0, i - 1] of string 
		int[] dp = new int[s.length() + 1];
		dp[0] = 0;
        boolean[][] pal = getPalindrome(s);  // cache palindrome substring in memory
		for (int i = 1; i < dp.length; i++) {
			dp[i] = i;
			for (int j = 0; j < i; j++) {
				if (pal[0][i - 1]) {  // prune if [0, i] substring is already a palindrome
					dp[i] = 0;
					continue;
				}
				if (pal[j][i - 1]) {    // [j, i-1] is right smaller section
					dp[i] = Math.min(dp[j] + 1, dp[i]);  // we can directly get dp[j] from memory
				}
			}
		}
		return dp[s.length()];
	}
	
	private boolean[][] getPalindrome(String s) {
        // res[i][j] represents if substring from jth to ith (inclusive)
        // is a palindrome or not
        boolean[][] res = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
        	for (int j = 0; j <= i; j++) {
				if (s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || res[j + 1][i - 1])) {
					res[j][i] = true;
				}
			}
        }
        return res;
    }
	
	
	/*
	 * sol 2 M[i] represents number of cuts from 0th to ith element (exclusive) to make each part is palindrome
	 * 
	 */
//	public int minCut(String s) {
//		if (s == null || s.length() <= 1) {
//			return 0;
//		}
//		// M[i] represents minimum number of cuts from 0th character to i-th character (exclusive)  [0, i - 1] of string 
//		int[] dp = new int[s.length() + 1];
//		dp[0] = 0;
//        boolean[][] pal = getPalindrome(s);  // cache palindrome substring in memory
//		for (int i = 1; i < dp.length; i++) {
//			dp[i] = i;
//			for (int j = 0; j < i; j++) {
//				if (pal[j][i - 1]) {    // [j, i-1] is right smaller section
//					dp[i] = Math.min(dp[j] + 1, dp[i]);  // we can directly get dp[j] from memory
//				}
//			}
//		}
//		return dp[s.length()] - 1;
//	}
//	
//	private boolean[][] getPalindrome(String s) {
//        // res[i][j] represents if substring from jth to ith (inclusive)
//        // is a palindrome or not
//        boolean[][] res = new boolean[s.length()][s.length()];
//        for (int i = 0; i < s.length(); i++) {
//        	for (int j = 0; j <= i; j++) {
//				if (s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || res[j + 1][i - 1])) {
//					res[j][i] = true;
//				}
//			}
//        }
//        return res;
//    }
}

