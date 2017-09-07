package TAclass3_String;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author guoyifeng
 Given a string S and a string T, find the minimum window in S which will contain all 
 the characters in T in complexity O(n).

	For example,
	S = "ADOBECODEBANC"
	T = "ABC"
	Minimum window is "BANC".
	
	Note:
	If there is no such window in S that covers all characters in T, return the empty string "".
	
	If there are multiple such windows, you are guaranteed that there will always be only one unique 
	minimum window in S.
 */

/*
 * S  ADOBECODBANC
   f
   s
   T  ABC
	
	<A,0>
	<B,0>
	<C,0>
	len = 4
	
	basic idea: 
		1. use a hash_map to record each character occurrence in string t
		2. initialize count to record number of characters need to match
		3. initialize fast and slow pointer
		   use fast pointer to traverse the string s
			2.1 if current char is in the map
					map.get(c) - 1 
					if map.get(c) >= 0, means current character has not been fully matched
						count++
					
					after all the characters being matched, at this moment, count == t.length()
					now we have a valid window but may not shortest one
					here we begin to update the current window without invalidating it (while (count == t.length()))
					check from the leftmost character of current window
						if (map.contains(leftmost))  {
							map.get(leftmost)++ 
							if (map.get(leftmost) > 0) meaning current left character has not been matched 
						}
						left++ // no matter current left is in map or not, we move left to try to shorten the window
						
	
	Time = O(n);
	Space = O(len of t);
					
	
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s == null || s.length() < t.length() || s.length() == 0) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<>(); // record occurrence of each char in string t
		// record occurrence
		for (int i = 0; i < t.length(); i++) {
			Integer n = map.get(t.charAt(i));
			if (n == null) {
				map.put(t.charAt(i), 1);
			} else {
				map.put(t.charAt(i), n + 1);
			}
		}
		int right = 0; // current pointer
		int left = 0; // left limit current window
		int minLen = s.length() + 1; // minimum length of valid window
		int minLeft = 0; // index of left limit of minimum window
		int count = 0; // number of matched character
		for (; right < s.length(); right++) {
			if (map.containsKey(s.charAt(right))) { // if current character matched
				map.put(s.charAt(right), map.get(s.charAt(right)) - 1); // decrease # of character need to match 
				if (map.get(s.charAt(right)) >= 0) { // means current character has not been fully matched
					count++;
				}
				
				// try to shorten the valid window if we have one
				while (count == t.length()) { // now we have a valid window
					// record and update current window size
					if (right - left + 1 < minLen) {
						minLen = right - left + 1; // update minLen
						minLeft = left; // update minLeft
					}
					// try to shorten the size of current valid window
					char l = s.charAt(left); // check from leftmost char of window
					if (map.containsKey(l)) {
						map.put(l, map.get(l) + 1);
						if (map.get(l) > 0) { // means current window begin to lose full match
							count--;  // some character needs to match again, current window become invalid
						}
					}
					left++; // no matter if current character in the map or not
						   // we move left forward to try to shorten the window, if current
					       // valid window become invalid, when fast move forward, we will
					       // try to find new valid window, if not found, last updated minLen
					       // will be the shortest valid window length after fast out of limit and
					       // loop will be terminated
				}
			}
		}
		return minLen < s.length() + 1 ? s.substring(minLeft, minLeft + minLen) : "";
	}
}
