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
	
	Dictionary: {“bob”, “cat”, “rob”}
	
	Word: “robob” return false
	
	Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
 */
public class DictionaryWord1 {
	public boolean canBreak(String input, String[] dict) {
		Set<String> dictSet = toSet(dict);
		boolean[] M = new boolean[input.length() + 1];
		// base case
		M[0] = false;
		for (int i = 1; i < M.length; i++) {
			if (dictSet.contains(input.substring(0, i))) {//make sure the whole sequence will be checked 
				M[i] = true;
				continue;//continue to next iteration
			}
			for (int j = 1; j < i; j++) {//to check at current i, if there exists a j before i that guarantee substring(0,j) is a word and substring(j,i) is a word
				if (M[j] && dictSet.contains(input.substring(j, i))) {
					M[i] = true; // if so, (0,i) can break to certain number of words
					break;// already found certain j,terminal the inner for loop, move to next i
				}
			}
		}
		return M[input.length()];
	}

	private Set<String> toSet(String[] dict) {
		Set<String> dictSet = new HashSet<>();
		for (int i = 0; i < dict.length; i++) {
			dictSet.add(dict[i]);
		}
		return dictSet;
	}
}

