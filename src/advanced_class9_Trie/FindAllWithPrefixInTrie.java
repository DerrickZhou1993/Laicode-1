package advanced_class9_Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class FindAllWithPrefixInTrie {
	
	public List<String> findAllWithPrefix(TrieNode root, String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return null; 
		}
		TrieNode matchNode = search(root, prefix);
		if (matchNode == null) {  // no such prefix found in the Tire
			return null;
		}
		List<String> result = new ArrayList<String>();
		dfs(result, matchNode, new StringBuilder(prefix));
		return result;
	}
	
	private void dfs(List<String> result, TrieNode curNode, StringBuilder curPath) {
		// Base case : when arrive leaf node
		if (curNode.children.size() == 0) {
			return;
		}
		
		// This is not base case but what we need do in current layer
		// check if current node to start node path is a word or not
		if (curNode.isWord == true) {
			result.add(curPath.toString());
		}
		
		// classical dfs process
		for (Entry<Character, TrieNode> child : curNode.children.entrySet()) {
			curPath.append(child.getKey());
			dfs(result, child.getValue(), curPath);
			curPath.deleteCharAt(curPath.length() - 1);
		}
	}
	
	private TrieNode search(TrieNode root, String target) {
		// assume target is not null
		TrieNode cur = root;
		for (int i = 0; i < target.length(); i++) {
			Character c = target.charAt(i); // current scanned character
			TrieNode next = cur.children.get(c);
			if (next == null) {
				return null; // could not match with given input
			}
			cur = next;
		}
		return cur;
	}
}
