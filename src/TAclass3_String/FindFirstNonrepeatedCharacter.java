package TAclass3_String;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author yifengguo
 	Given a string, find the first non-repeating character in it. For example, 
 	if the input string is “GeeksforGeeks”, then output should be ‘f’ and if input string is 
 	“GeeksQuiz”, then output should be ‘G’.
 	
 	challenge: how to solve this problem with one pass on string?
 */
/*
 * map + doubly linked list
 *     how to do it with only one scan?
 *     		1. need deletion O(1)
 *     		2. need keep order
 *     	
 *     sol: we could use map + doubly linked list
 *     		Map<Character, Character>
 *     
 */

/*
 * demo:
 * 		        a    b    a    c    c    d    e    f    f
 *      
 *   dll head-> a -> b -> ...
 *       	when meet character which has been in the Map (use Map.containsKey())
 *       	delete a in the dll and delete its key in the map 
 *       	(however key is still in the map so we can use containsKey() to check 
 *           if the current character has been in the map before even though it may be deleted
 *           e.g a b a c a,  the third a will still be ignored by map and dll)		
 *       	         b -> d - > e
 *       	else, put the current character into the map and add it into the dll
 *       
 *       so finally we have b as first non-repeating character in the string (return dll.get(0))   
 *       
 *       time = O(n)
 *       space = O(n) for dll and hash_map
 */
public class FindFirstNonrepeatedCharacter {
	public static Character findFirstNonRepeating(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		Map<Character, Character> map = new HashMap<>();
		List<Character> dll = new ArrayList<>();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			// first occurrence
			if (!map.containsKey(arr[i])) {
				dll.add(arr[i]);
				map.put(arr[i], arr[i]);
			} else {  // if not first occurrence
				dll.remove((Character)arr[i]);  // must cast Object to Character or remove() will throw exception
				map.remove(arr[i]);
			}
		}
		return dll.get(0);
	}
	
	public static Character findFirstNonRepeating1(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		int MAX_CHAR = 256;
		boolean[] isOccur = new boolean[MAX_CHAR];
		List<Character> dll = new ArrayList<>();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			// first occurrence
			if (!isOccur[arr[i]]) {
				if (!dll.contains(arr[i])) {
					dll.add(arr[i]);
				} else {
					dll.remove((Character)arr[i]);
					isOccur[arr[i]] = true;
				}
			}
		}
		return dll.get(0);
	}
	
	public static void main(String[] args) {
		String s = "aaabbc";
		Character c1 = findFirstNonRepeating(s);
		Character c2 = findFirstNonRepeating1(s);
		System.out.println(c1);
		System.out.println(c2);
	}
}
