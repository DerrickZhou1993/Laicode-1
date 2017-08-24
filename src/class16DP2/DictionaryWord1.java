package class16DP2;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author guoyifeng
 * Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

	Assumptions
	
	The given word is not null and is not empty
	The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty
	Examples
	
	Dictionary: {"bob", "cat", "rob"}
	
	Word: "robob" return false
	
	Word: "robcatbob" return true since it can be composed by "rob", "cat", "bob"
 */

/*
 * need to remember when invoke String.substring(a,b) this 
 * api would cause O(n) time so time complexity is O(n ^ 3)
 * 
 * and first limit a is included and 
 * second limit b is excluded!!!
 * 
 * so we here use input.substring(0, i + 1) to represent [0,i] 
 */
public class DictionaryWord1 {
	public boolean canBreak(String input, String[] dict) {
		Set<String> dictSet = toSet(dict);
		boolean[] M = new boolean[input.length()];

		for (int i = 0; i < input.length(); i++) {
			if (dictSet.contains(input.substring(0, i + 1))) {//make sure the whole sequence will be checked 
				M[i] = true;
				continue;//continue to next iteration of outer loop
			}
			for (int j = 0; j < i; j++) { // to check at current i, if there exists a j before 
									      // i that guarantee substring(0,j+1) 
										  // is a word and substring(j+1,i+1) is a word
				if (M[j] && dictSet.contains(input.substring(j + 1, i + 1))) {
					M[i] = true; // if so, (0,i) can break to certain number of words
					break;// already found certain j,terminal the inner for loop, move to next i
				}
			}
		}
		return M[input.length() - 1];
	}

	private Set<String> toSet(String[] dict) {
		Set<String> dictSet = new HashSet<>();
		for (int i = 0; i < dict.length; i++) {
			dictSet.add(dict[i]);
		}
		return dictSet;
	}
}

