package advanced_class9_Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * 
 * @author @Yifeng
 * Example
 *  allMatch("ca?") = ["cap", "cat"]
 *  allMatch("??p") = ["app", "cap"]	
 */

/*
 * for dfs
 * 	1. what does it store on each level
 *  2. how many levels in total?
 *  
 *  for this problem
 *  	'?' means we have to run dfs on all the brunches
 *      'a' means we have to run dfs on 'a' brunch 
 */
public class WildCardInTrieDFS {
	public List<String> findAllMatchWildCard(TrieNode root, String target) {
		List<String> result = new ArrayList<>();
		if (target == null || target.length() == 0) {
			return result;
		}
		StringBuilder curPath = new StringBuilder();
		wildCardDFS(root, result, target, 0, curPath);
		return result;
	}
	
	private void wildCardDFS(TrieNode cur, List<String> result, String target, int level, StringBuilder curPath) {
		// Base case
		if (level == target.length()) {
			if (cur.isWord) { // if current node can build a word, add path to the result
				result.add(curPath.toString());
			}
			return;
		}
		
		// process branches
	    // two cases: if current character is '?' or not
		// if current character is '?' dfs on all brunches
		if (target.charAt(level) == '?') {
			for (Entry<Character, TrieNode> child : cur.children.entrySet()) {
				curPath.append(child.getKey());
				wildCardDFS(child.getValue(), result, target, level + 1, curPath);
				curPath.deleteCharAt(curPath.length() - 1);
			}
		} else {
			TrieNode nextLevel = cur.children.get(target.charAt(level));
			if (nextLevel != null) {
				curPath.append(target.charAt(level));
				wildCardDFS(nextLevel, result, target, level + 1, curPath);
				curPath.deleteCharAt(curPath.length() - 1);
			}
		}
		
	}
}
