package TAclass3_String;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author guoyifeng
 	Given two strings and check if they are anagrams
 	if the characters which make up two strings are the same, they are anagrams
 */
/*
 * 	basci idea:
 * 		use hash_map to record ouccurrence of each character in one string
 * 		and traverse another string, if current char is in map, then decrease 
 * 		its value.
 * 		initialize count to represent characters need to match
 * 		when current char's value == 0, count-- meaning current char
 * 		has been matched
 * 		return count == 0 to represent each char in two strings is the same
 * 
 * 		This problem can be treated as prerequisite of MinimumWindowSubstring
 * 		HashMap and count to compare two strings' characters occurrence
 * 		This idea and template is very important!
 * Time = O(n)
 * Space = O(n)
 */
public class CheckIfTwoStringsAreAnagram {
	public static boolean isAnagram(String a, String b) {
		if (a == null || b == null || a.length() == 0 || b.length() == 0) {
			return false;
		}
		if (a.length() != b.length()) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<>();
		int count = a.length();
		for (int i = 0; i < a.length(); i++) {
			Integer n = map.get(a.charAt(i));
			if (n == null) {
				map.put(a.charAt(i), 1);
			} else {
				map.put(a.charAt(i), n + 1);
			}
		}
		for (int i = 0; i < b.length(); i++) {
			if (map.containsKey(b.charAt(i))) {
				map.put(b.charAt(i), map.get(b.charAt(i)) - 1);
				if (map.get(b.charAt(i)) == 0) {
					count--;
				}
			}
		}
		return count == 0;
	}
	
	public static void main(String[] args) {
		String a = "cbdfe";
		String b = "dfecb";
		String c = "dcbek";
		System.out.println(isAnagram(a, b));
		System.out.println(isAnagram(b, c));
	}
}

