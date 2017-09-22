package TAclass8_DP;
/**
 * 
 * @author guoyifeng
 	given a string, find its longest palindrome substring
 */

/*
 * solution 1 : DP
 * 	M[i][j] represents if s.substring(j, i + 1) is palindrome or not
 *  so ith-element is inclusive [j, i]
 * 	
 * 	base case:
 * 		M[0][0] == true  when s has only one character
 * 		M[0][1] = true if s.charAt(0) == s.charAt(1)
 * 
 *  induction rule:
 *  	for (int i = 2; i < s.length(); i++) {
 *  		for (int )
 *  	}
 */
public class LongestPalindromeSubstring {
	public int longest(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int longest = 0;
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || dp[j + 1][i - 1])) {
					dp[j][i] = true;
					longest = Math.max(longest, i - j + 1);
				}
			}
		}
		return longest;
		
	}
	
	public static void main(String[] args) {
		String s = "abb";
		int res = new LongestPalindromeSubstring().longest(s);
		System.out.println(res);
	}
}
