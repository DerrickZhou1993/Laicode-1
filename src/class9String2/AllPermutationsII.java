package class9String2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsII {
	public List<String> permutations(String input) {
		List<String> result = new ArrayList<>();
		if (input == null) {
			return result;
		}
		char[] array = input.toCharArray();
		helper(array, 0, result);
		return result;

	}

	private void helper(char[] arr, int level, List<String> result) {
		if (level == arr.length) {
			result.add(new String(arr));
		}
		Set<Character> set = new HashSet<>();//the reason Set is initialized here is the rule is just for the current level
											 //in current, identical letter will be swap to the leftmost only once!
		for (int i = level; i < arr.length; i++) {
			if (set.add(arr[i])) {//will return false if arr[i] is already in the set, so duplicate letter will be pruned
				swap(arr, i, level);
				helper(arr, level + 1, result);//DFS
				swap(arr, i, level);//retrieve to original permutation when backtracking
			}
		}
	}

	private void swap(char[] arr, int a, int b) {
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}