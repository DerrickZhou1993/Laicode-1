package finalExam;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author @Yifeng
	  Given a String, we can insert at most one empty space between each pair of adjacent letters
	  Print all permutations of strings after insertions of empty spaces
	  
	  Example: 
	  	input[] = "ABC"
	  	
	  	Output:
	  		ABC
	  		A_BC
	  		AB_C
	  		A_B_C
 * 	
 */

/*
 * basic idea: DFS add or not problem
 */

/*
 *  Time = O(2 ^ n) always to need check add or not and we have n characters
 *  Space = O(n) we have n layers of dfs recursion tree
 */
public class InsertEmptySpaceIntoWord {
	public List<String> allPermutate(char[] input) {
		if (input == null || input.length == 0) {
			return null;
		}
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		return null;
	}
	
	public void dfs(List<String> result, int level, char[] input, StringBuilder sb) {
		// base case
		if (level == input.length) {
			sb.append(input[level]);
			result.add(sb.toString());
			sb.deleteCharAt(sb.length() - 1); // back track
			return;
		}
		
		// process on current layer
		// problem is add space or not add
		
		// if add, we must guarantee in adjacent letters
		if (input[level] != ' ' && input[level + 1] != ' ') {
			sb.append(' ');
			dfs(result, level + 1,input, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
		
		// if not add space, then append letter directly
		sb.append(input[level]);
		dfs(result, level + 1, input, sb);
		sb.deleteCharAt(sb.length() - 1);
	}
}
