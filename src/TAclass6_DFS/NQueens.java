package TAclass6_DFS;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author guoyifeng
 * 	The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 	Given an integer n, return all distinct solutions to the n-queens puzzle.

	Each solution contains a distinct board configuration of the n-queens' placement, 
	where 'Q' and '.' both indicate a queen and an empty space respectively.
	
	For example,
	There exist two distinct solutions to the 4-queens puzzle:
	
	[
	 [".Q..",  // Solution 1
	  "...Q",
	  "Q...",
	  "..Q."],
	
	 ["..Q.",  // Solution 2
	  "Q...",
	  "...Q",
	  ".Q.."]
	]
 */
/*
 * basic idea: DFS
 * 	challenge 1: how to determine if current column can set a queen?
 *              0 1 2 3 4
 *            0 . . . . Q
 *            1 Q . . . .
 *            2 . . Q . .
 *            3 ? ? ? ? ?
 *            
 *           to set a queen, we need to check vertical, horizontal and diagonal
 *           now new queen will be set on cur.size()th row, which actually does not exist now  [0, cur.size() - 1] row has queen
 *           since we only set one queen in each row and dfs next row, so horizontal is not a problem
 *           so we need a for loop to iterate each row which has a queen set existed before
 *           for vertical if (ith row's queen column idx == column) return false
 *           for diagonal it is like coordinates, if they are on diagonal, like (x1, y1) and (x2, y2), so y2 - y1 == x2 - x1
 *           		for queen coordinate, if we are now iterating ith row which has queen, on the row, |queen's column - column(need to determine)| == rowNum - i
 *           		it means they are on diagonal 
 *           
 *    challenge 2: backtrack cur.remove(cur.size() - 1)
 *    		. . Q . .
 *          . . . . Q
 *          Q . . . .
 *          
 *          when recursion return (add a plan to res), it backtracks to last call stack
 *          at that iteration, in for loop, last valid index has passed, need to find 
 *          another valid column index in current layer, this is how we can get different
 *          plans in final res
 */

/*
 * time = O(n! * n) for isValid will cost O(n)
 * space = O(n) for n layers recursion tree 
 */
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		if (n <= 0) {
			return res;
		}
		List<String> cur = new ArrayList<>();
		helper(res, cur, n);
		return res;
	}
	
	private void helper(List<List<String>> res, List<String> cur, int n) {
		// base case
		if (cur.size() == n) {
			res.add(new ArrayList<String>(cur)); // must new a ArrayList
			return;
		}
		// dfs on each column
		for (int i = 0; i < n; i++) {
			// check validity of current column
			if (isValid(cur, i)) {
				cur.add(fillQ(i, n));
				helper(res, cur, n);
				cur.remove(cur.size() - 1); // backtrack
			}
		}
	}
	
	// to determine if current column can set a queen
	private boolean isValid(List<String> cur, int column) {
		int rowNum = cur.size(); // new queen will be set on this row, this row now does not exist
		for (int i = 0; i < rowNum; i++) { // i means current row index which has queen
			// first half is to determine vertical
			// second half it to determine diagonal using y2 - y1 == x2 - x1
			if (getQCol(cur.get(i)) == column || Math.abs(getQCol(cur.get(i)) - column) == rowNum - i) {
				return false;
			}
		}
		return true;
	}

	private int getQCol(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'Q') {
				return i;
			}
		}
		return -1;
	}

	private String fillQ(int column, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (i == column) {
				sb.append('Q');
			} else {
				sb.append('.');
			}
		}
		return new String(sb);
	}
	
	public static void main(String[] args) {
		int n = 8;
		List<List<String>> res = new NQueens().solveNQueens(n);
		int count = 0;
		for (List<String> list : res) {
			System.out.println("plan" +count+ ": ");
			for (String s : list) {
				System.out.println(s);
			}
			count++;
			System.out.println();
		}
		
	}
}

