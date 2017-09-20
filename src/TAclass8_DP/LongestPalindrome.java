package TAclass8_DP;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author guoyifeng
  
	Given a string which consists of lowercase or uppercase letters, find the length of the longest 
	palindromes that can be built with those letters.
	
	This is case sensitive, for example "Aa" is not considered a palindrome here.
	
	Note:
	Assume the length of given string will not exceed 1,010.
	
	Example:
	
	Input:
	"abccccdd"
	
	Output:
	7
	
	Explanation:
	One longest palindrome that can be built is "dccaccd", whose length is 7. 
 */
/*
 * basic idea: just need to calculate largest number of pairs which contains two identical character
 *             and allow at most only one single character exists
 *             and we could use hashSet and pair to solve this problem
 *             whenever we meet the duplicate character in the set, we remove it and pair++
 *             at last if hashSet is empty, meaning we have even pairs of identical chars to build palindrome
 *             if not, it means we have only one char and several pairs of chars to build palindrome
 *             both case is ok
 *         
 *         time = O(n)
 *         space = O(n)
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int pair = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                set.remove(s.charAt(i));
                pair++;
            }
        }
        if (set.isEmpty()) {
            return 2 * pair;
        } else {
            return 2 * pair + 1;
        }
    }
}
