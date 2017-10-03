package TAclass9_AdvancedProblems;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author guoyifeng
 	Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

	Only one letter can be changed at a time.
	Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
	For example,
	
	Given:
	beginWord = "hit"
	endWord = "cog"
	wordList = ["hot","dot","dog","lot","log","cog"]
	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5.
	
	Note:
	Return 0 if there is no such transformation sequence.
	All words have the same length.
	All words contain only lowercase alphabetic characters.
	You may assume no duplicates in the word list.
	You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// assume beginWord, endWord and wordList is not null or empty
		Deque<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		int res = 0;
        Map<String, Boolean> map = new HashMap<>();
        for(String s : wordList) {
            map.put(s, false);
        }
		while (!queue.isEmpty()) {
			int size = queue.size();
            res++;
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (cur.equals(endWord)) {
					return res;
				}
				for (String s : wordList) {
					if (differOneLetter(cur, s) && !queue.contains(s) && map.get(s) == false) {
						queue.offer(s);
						map.put(s, true);
					}
				}	
			}
		}
		return 0;
	}

	private boolean differOneLetter(String cur, String s) {
		int count = 0;
		for (int i = 0; i < cur.length(); i++) {
			if (cur.charAt(i) != s.charAt(i)) {
				count++;
			}
		}
		return count == 1;
	}
}

