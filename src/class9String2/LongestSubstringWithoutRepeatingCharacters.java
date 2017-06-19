package class9String2;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author guoyifeng
 *	Given a string, find the longest substring without 
 *	any repeating characters and return the length of it. 
 *	The input string is guaranteed to be not null.

	For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", 
	we should return 4 in this case.
 */

/*
 * the final length of sliding window is the result
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int longest(String input) {
		if (input.length() == 0) {
			return 0;
		}
		Set<Character> occur = new HashSet<>();
		int s = 0;// slow pointer
		int f = 0;// fast pointer
		int max = 0;// max substring length
		char[] arr = input.toCharArray();
		while (f < arr.length) {
			if (occur.contains(arr[f])) {
				occur.remove(arr[s]);
				s++;
			} else {
				//if there is no duplicate character in the set, it means we can move fast pointer
				//to the next index and have a sliding window (s,f) which contains the longest substring with 
				//unique character
				occur.add(arr[f]);
				f++;
				max = Math.max(max, f - s);
			}
		}
		return max;
	}
}
