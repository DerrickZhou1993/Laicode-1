package advanced_class7_DP4;
/**
 * 
 * @author @Yifeng
 * Find the length of longest common subsequence of two given strings.

	Assumptions
	
	The two given strings are not null
	Examples
	
	S = "abcde", T = "cbabdfe", the longest common subsequence of s and t is {'a', 'b', 'd', 'e'}, the length is 4.
 */
public class LongestCommonSubsequence {
	public int longest(String a, String b) {
		if (a == null || b == null) {
			return 0;
		}
		// M[i][j] represents a b longest common subsequence length 
		// ith and jth may not be included because it can also
		// inherit from top and left position if current char is not equal
		int[][] M = new int[a.length() + 1][b.length() + 1];
		// base case
		M[0][0] = 0;
		if (a.length() == 0) return 0;
		if (b.length() == 0) return 0;
		// induction rule:
		// if a[i] == b[j]  -> M[i][j] = M[i - 1][j - 1] + 1
		// else              -> M[i][j] = Math.max(M[i][j - 1], M[i - 1][j])
		
		for (int i = 1; i <= a.length(); i++) { // remember i <= a.length() for we initialize array[a.length()+1]
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					M[i][j] = M[i - 1][j - 1] + 1;
				} else {
					M[i][j] = Math.max(M[i][j - 1], M[i - 1][j]);
				}
			}
		}
		return M[a.length()][b.length()];
	}
	
	public static void main(String[] args) {
		String a = "abcdefg";
		String b = "babcgfegh";
		System.out.println(new LongestCommonSubsequence().longest(a, b));
	}
}
