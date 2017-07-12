package class19Recursion2LCA;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author @Yifeng
 * Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.

Assumptions

N > 0
Return

A list of ways of putting the N Queens
Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)

Example

N = 4, there are two ways of putting 4 queens:

[1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3, the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.

[2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0, the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.
 */
public class NQueens {
	public List<List<Integer>> nqueens(int n) {
		List<List<Integer>> result = new ArrayList<>();
		if(n == 0) {
			return result;
		}
		List<Integer> cur = new ArrayList<>();
		helper(result, cur, n);
		return result;
	}

	private void helper(List<List<Integer>> result, List<Integer> cur, int n) {
		//Base case
		if(cur.size() == n) { // all rows has one queen at the moment
			result.add(new ArrayList<Integer>(cur));//add current plan to result
			return;
		}
		for(int i = 0;i < n; i++) { // from first column to last column find the potential postion by dfs
			if(isValid(cur,i)) {  //find by dfs
				cur.add(i);
				helper(result,cur,n); // now cur.size() has increased by 1 meaning going to next row
				cur.remove(cur.size() - 1);
			}
		}
	}
	private boolean isValid(List<Integer> cur, int column) { //check current position 
		int rowNum = cur.size();
		for(int i = 0; i < rowNum; i++) {
			if(cur.get(i) == column || Math.abs(cur.get(i) - column) == rowNum - i) {
				return false;
			}
		}
		return true;
	}
}


