package class7DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author guoyifeng
	Given a set of characters represented by a String, return a list containing all subsets of the characters.
	
	Assumptions
	
	There are no duplicate characters in the original set.
	​Examples
	
	Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
	Set = "", all the subsets are [""]
	Set = null, all the subsets are []

 */

/*
 * Time O(2 ^ n) n = elements number = layers
 * Space O(n) n elements
 */
public class AllSubsetsI {
	public List<String> subSets(String set) {
		List<String> result = new ArrayList<>();
		if(set == null) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		helper(set,0,sb,result);
		return result;
	}
	
	private void helper(String set,int level,StringBuilder sb,List<String> result) {
		if(level == set.length()) {//must == set.length() to make all the character in the set can be accessed
			result.add(sb.toString());
			return;
		}
		helper(set,level + 1, sb.append(set.charAt(level)),result);//choose a character
		sb.deleteCharAt(sb.length() - 1); //back to last condition
		helper(set,level + 1,sb,result); // not choose  
	}
}
