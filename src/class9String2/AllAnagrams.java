package class9String2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author @Yifeng
 * 	Find all occurrence of anagrams of a given string s in a given string l. 
 * 	Return the list of starting indices.

	Assumptions
	
	s is not null or empty.
	l is not null.
	Examples

	l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from 
	index 0/3 are all anagrams of "ab" ("ab", "ba").
 */
public class AllAnagrams {
	/*
	 * basic idea: put s char frequency into hashmap, use a fixed size sliding window to slide on l
	 * 			   we record short string character frequency in hashmap initially, when sliding window moves
	 * 			   we maintain the leftmost and rightmost char remove/add to sliding window
	 */
	public List<Integer> allAnagrams(String s, String l) {
		List<Integer> result = new ArrayList<Integer>();
		if (s.length() > l.length()) {
			return result;
		}
		if (l.length() == 0) {
			return result;
		}
		Map<Character, Integer> map = new HashMap<>();
		char[] window = s.toCharArray();
		//put all characters in s into hashmap and get their frequency
		for (char c : window) {
			Integer freq = map.get(c);
			if (freq == null) {
				map.put(c, 1);
			} else {
				map.put(c, freq + 1);
			}
		}
		int match = 0;//to record how many distinct characters current sliding window have matched with map
					  //our assumption: if match == map.size() then we find an anagram 
		for (int i = 0; i < l.length(); i++) {
			char temp = l.charAt(i);
			Integer count = map.get(temp);
			if (count != null) {//if current character is a key of map 
				map.put(temp, count - 1);//its value--
				if (count - 1 == 0) {//if new added character's value after decreasing is 0, it means the sliding window now has one distinct
									 //character matched with the s, (if all matched e.g match == map.size(), we find an anagram)
					match++;
				}
			}
			//handle the leftmost character we remove at the previous sliding window
			if (i >= s.length()) {
				temp = l.charAt(i - s.length());//the sliding window size must kept as s.length()
				count = map.get(temp);
				if (count != null) {//if this character is a key of map
					map.put(temp, count + 1);//its hashmap's value +1
					if (count + 1 == 1) {//if this operation makes this char's value from 0 to 1, it means we lose one matched character
						match--;
					}
				}
			}
			if (match == map.size()) {//whenever match == map.size(), it means every key's value in map is 0 now, so we find a anagram
				result.add(i - s.length() + 1);//add this sliding window's start index to result list
			}
		}
		return result;
	}
}
