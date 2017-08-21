package advanced_class7_DP4;
/**
 * 
 * @author @Yifeng
 * Find the longest common substring of two given strings.

	Assumptions
	
	The two given strings are not null
	Examples
	
	S = "abcde", T = "cdf", the longest common substring of S and T is "cd"
 */
public class LongestCommonSubstring {
	public String longestCommon(String a, String b) {
		if (a == null || b == null) {
			return null;
		}
		// M[i][j] represents A[0...i - 1] and B[0...j - 1] the longest common substring's length (including
		// the (i)th letter of S1 and the (j)th letter of S2) because only current char is equal to each other
		// can we plus 1 to M[i-1][j-1], if not equal reset it to 0 (must be contiguous diagonal in 2d matridx)
		String[][] M = new String[a.length() + 1][b.length() + 1];
		String result = "";
		// base case 1
		M[0][0] = "";
		// initialize string[][] or default value is null!!
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				M[i][j] = "";
			}
		}
		/*
		 *  for string-like problem, if we use array to represent string char
		 *  at each bit, when initialize M[][], index = 0 means the current bit
		 *  is "", not means string.charAt(0). and i and j are [1, string.length()]
		 *  and when invoking charAt() we should use s.charAt(i - 1) etc.
		 */
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (i == 0) { // base case 2, meaning a == ""
					M[i][j] = "";
				}
				if (j == 0) { // base case 3 meaning b == ""
					M[i][j] = "";
				}
				if (a.charAt(i - 1) != b.charAt(j - 1)) {
					M[i][j] = "";
				} else {
					M[i][j] = M[i - 1][j - 1] + a.charAt(i - 1);
					if (M[i][j].length() >= result.length()) {
						result = M[i][j];
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String a = "abcdefg";
		String b = "bbcefgh";
		System.out.println(new LongestCommonSubstring().longestCommon(a, b));
		// System.out.println("" + "d");
	}
}
