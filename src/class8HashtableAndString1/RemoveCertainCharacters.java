package class8HashtableAndString1;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author guoyifeng
 * Remove given characters in input string, the relative order of other characters should be remained. 
 * Return the new string after deletion.

	Assumptions
	
	The given input string is not null.
	The characters to be removed is given by another string, it is guranteed to be not null.
	Examples
	
	input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
 */
public class RemoveCertainCharacters {
	public String remove(String input, String t) {
		// Write your solution here.
		if (t.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();
		Set<Character> charSet = toSet(t);
		int slow = 0;
		for (int fast = 0; fast < arr.length; fast++) {
			if (!charSet.contains(arr[fast])) {
				arr[slow++] = arr[fast];
			}
		}
		return new String(arr, 0, slow);
	}

	private Set<Character> toSet(String t) {
		Set<Character> charSet = new HashSet<>();
		for (int i = 0; i < t.length(); i++) {
			charSet.add(t.charAt(i));
		}
		return charSet;
	}
}
