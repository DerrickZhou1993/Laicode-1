package class7DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author guoyifeng
 * 	Given N pairs of parentheses “()”, return a list with all the valid permutations.

	Assumptions
	
	N >= 0
	Examples
	
	N = 1, all valid permutations are ["()"]
	N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
	N = 0, all valid permutations are [""]
 *
 */
public class AllValidPermutationsOfParenthesesI {
	public List<String> validParentheses(int n) {
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		helper(n,0,0,sb,result);
		return result;
	}
	
	private void helper(int n, int leftNum, int rightNum, StringBuilder sb,
			List<String> result) {
		if(leftNum == n && rightNum == n) {
			result.add(sb.toString());
			return;
		}
		if(leftNum < n) {
			helper(n,leftNum + 1, rightNum, sb.append("("),result);
			sb.deleteCharAt(sb.length() - 1);
		}
		if(rightNum < leftNum) {
			helper(n,leftNum,rightNum + 1, sb.append(")"), result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
