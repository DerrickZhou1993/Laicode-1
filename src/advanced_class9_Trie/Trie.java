package advanced_class9_Trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
	public int count; // below this TrieNode, how many TrieNode's isWord == true
	public boolean isWord;
	public Map<Character, TrieNode> children;
	public TrieNode() {
		isWord = false;
		children = new HashMap<>();
	}
}
public class Trie {
	public boolean search(TrieNode root, String target) {
		// assume target is not null
		TrieNode cur = root;
		for (int i = 0; i < target.length(); i++) {
			Character c = target.charAt(i); // current scanned character
			TrieNode next = cur.children.get(c);
			if (next == null) {
				return false; // could not match with given input
			}
			cur = next;
		}
		return cur.isWord;
	}
	
	public void insert(TrieNode root, String target) {
		if (search(root, target)) { // if we can search this in the tree
			return;
		}
		TrieNode cur = root;
		for (int i = 0; i < target.length(); i++) {
			Character c = target.charAt(i);
			TrieNode next = cur.children.get(c);
			if (next == null) {
				next = new TrieNode();
				cur.children.put(c, next);  // insert current character of target
			}
			cur = next; // iterate to next index
		}
		
	}
	
	/*
	 * idea 1: recursion  when children's word is only one (base case)
	 * 
	 * idea 2: stack   store whole word to delete and look back until only one word on the path scanned
	 * 
	 * idea 3: add a field in TrieNode count to represent how many isWord node existed below this node  O(1) space
	 * 
	 */
	public void delete(TrieNode root, String target) {
		if (!search(root, target)) { // if cannot find this target in the Trie, return;
			return;
		}
		
		TrieNode cur = root;
		for (int i = 0; i < target.length(); i++) {
			Character c = target.charAt(i);
			TrieNode next = cur.children.get(c);
			if (next.count == 1) {
				cur.children.remove(c);
				return;
			}
			cur = next;
			cur.count--; // do not forget 
		}
		cur.isWord = false; // if target word did not reach the node whose count == 1
					        // we need to set the current node's isWord = false to 
							// delete this word manually
	}
}
