package TAclass5_Matrix;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author @Yifeng
 	Zigzag print
1 2 3
4 5 6
7 8 9  

to 

1 2 3 6 5 4 7 8 9
 */
/*
 * basic idea:
 * 	simple question, similar logic to spiral order traversal but much easier to implement
 * 	zig-zag order traversal is more complex in binary tree
 * 	time = O(n)
 *  space = O(1)
 */
public class ZigZagPrintMatrix {
	public static List<Integer> zigzagPrint(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return res;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int up = 0;
		int down = m - 1;
		int left = 0;
		int right = n - 1;
		for (int i = up; i <= down; i++) {
			if (i % 2 == 0) { // odd row
				for (int j = left; j <= right; j++) {
					res.add(matrix[i][j]);
				}
			} else { // even row
				for (int j = right; j >= left; j--) {
					res.add(matrix[i][j]);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix2 = {{1,2,3,4,5,6,7},{8,9,10,11,12,13,14}};
		List<Integer> res = zigzagPrint(matrix2);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}
	}
}
