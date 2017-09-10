package class7DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author guoyifeng
	Given a string with no duplicate characters, return a list with all permutations of the characters.
	
	Examples
	
	Set = "abc", all permutations are ["abc", "acb", "bac", "bca", "cab", "cba"]
	Set = "", all permutations are [""]
	Set = null, all permutations are []
	
	if each element of input shall appear in the return result, prior to use swap and swap

 */
public class AllPermutationsI {
	public List<String> permutations(String set) {
		List<String> result = new ArrayList<>();
		if(set == null) {
			return result;
		}
		char[] arraySet = set.toCharArray();
		helper(arraySet,0,result);
		return result;
	}
	
	private void helper(char[] array, int level, List<String> result) {
		if(level == array.length) {//base case: must == array.length not array.length - 1 because must let every character in set be chosen
			result.add(new String(array));
			return;
		}
		for(int i = level; i < array.length; i++) {//i = level!!!
			swap(array,i,level);
			helper(array,level + 1,result);
			swap(array,i,level);//swap back to original state
		}
	}
	
	private void swap(char[] arr, int a, int b) {
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
