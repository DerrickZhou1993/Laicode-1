package TAclass3_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author yifengguo
 	Given an array of strings, group anagrams together.

	For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
	Return:
	
	[
	  ["ate", "eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	Note: All inputs will be in lower-case.


 */
/*
 * basic idea:
 * 		use hash_map to map string and list
 * 		sort each string in the strs and use sorted string as key and value is list to hold all anagrams of this string
 * 		pay attention to APIs of strings and hash_map
 * 
 * time = O(n)
 * Space = O(n)
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] ca = s.toCharArray(); // sort each string.toCharArray() for key is sorted char array
			Arrays.sort(ca);
			if (!map.containsKey(String.valueOf(ca))) {
				List<String> list = new ArrayList<>();
				list.add(s); // do not forget add s not String.valueOf(ca) (String.valueOf(ca) actually is ca)
				map.put(String.valueOf(ca), list);
			} else {
				map.get(String.valueOf(ca)).add(s);
			}
		}
		List<List<String>> res = new ArrayList<>();
		res.addAll(map.values()); // use addAll() to add all the elements in Collections to another Collection
		return res;
	}
}
