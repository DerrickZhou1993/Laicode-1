package finalExam;
/**
 * 
 * @author @Yifeng
 * Given an array of Strings, find it all the strings can be chained to form a cycle.
 * Two strings s1 and s2 can be chained, if the last letter of s1 is identical to the 
 * first letter of s2.
 *  For example: "abc" and "cd" can be chained
 *               "abc" and "dz" can not be chained
 *               
 *        Example input : arr[] = {"aaa", "bbb", "baa", "aab"};
 *        output: true
 *   all the strings in the array must be used once and only once
 */

/*
 * basic idea: dfs
 * 		to solve many data from chaos order to a certain order
 * 		we can consider use swap() + dfs + swap() back idea 
 */
public class IfStringsCanFormACycle {
	public boolean canFormCycle(String[] input) {
		if (input == null || input.length == 0) {
			return false;
		}

		return dfs(input, 1);
	}

	private boolean dfs(String[] input, int level) {
		// base case
		if (level == input.length) {
			if (canChain(input[level - 1], input[0])) {
				return true;
			}
			return false;
		}
		for (int i = level; i < input.length; i++) {
			if (canChain(input[level - 1], input[i])) {
				swap(input, i, level);
				if (dfs(input, level + 1)) { // must use a if to terminate dfs call
											 // or the result must be false
											 // we could also use a global flag to record result
											 // if flag is set to true, return as base case
					return true;
				}
				swap(input, i, level);
			}
		}
		return false;
	}

	private boolean canChain(String a, String b) {
		if (a.charAt(a.length() - 1) == b.charAt(0)) {
			return true;
		}
		return false;
	}

	private void swap(String[] input, int a, int b) {
		String temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}
	
	public static void main(String[] args) {
		String[] s = {"aaa", "bbb", "baa", "aab"};
		IfStringsCanFormACycle test = new IfStringsCanFormACycle();
		System.out.println(test.canFormCycle(s));
	}
}
