package TAclass8_DP;

import java.util.List;

/**
 * 
 * @author guoyifeng
 	Given a non-empty string s and a dictionary wordDict containing a 
 	list of non-empty words, determine if s can be segmented into a space-separated 
 	sequence of one or more dictionary words. You may assume the dictionary does not contain 
 	duplicate words.

	For example, given
	s = "leetcode",
	dict = ["leet", "code"].
	
	Return true because "leetcode" can be segmented as "leet code".
 */
/*
 * basic idea: dp left bigger section + right smaller section
 * 		M[i] represents if [0, i] substring can build a word
 *      time = O(n ^ 2)
 *      space = O(n)
 */
public class WordBreak {
	public boolean canBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0) {
			return false;
		}
		// dp[i] represents if 0th to ith character can build a word in the dict or not
		// ith character is inclusive
		boolean[] dp = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (wordDict.contains(s.substring(0, i + 1))) {  // s.substring() means [a, b)
				dp[i] = true;
				continue;
			}
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j + 1, i + 1))) {  // dp[j] is left bigger section
					                                                         // [j + 1, i] is left smaller section
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length() - 1];
	}
}
