package class5HeapAndGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * @author guoyifeng
 * Given a matrix of size N x M. For each row the elements are sorted in ascending order, 
 * and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.

	Assumptions
	
	the matrix is not null, N > 0 and M > 0
	K > 0 and K <= N * M
	Examples
	
	{ {1,  3,   5,  7},
	
	  {2,  4,   8,   9},
	
	  {3,  5, 11, 15},
	
	  {6,  8, 13, 18} }
	
	the 5th smallest number is 4
	the 8th smallest number is 6

 */
public class KthSmallestNumberInSortedMatrix {
	
	class Cell {//wrapper class for cell
		private int value;
		private int row;
		private int col;
		
		public Cell(int row,int col,int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}
	}
	public int kthSmallest(int[][] matrix, int k) {
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		boolean[][] visit = new boolean[rowNum][colNum];
		PriorityQueue<Cell> pq = new PriorityQueue<>(k,new Comparator<Cell>() { //anonymous class to make cell can be compared
			@Override
			public int compare(Cell c1, Cell c2) {
				if(c1.value == c2.value) return 0;
				return c1.value < c2.value ? -1 : 1;//min heap order
			}
		});
		Cell startNode = new Cell(0,0,matrix[0][0]);
		pq.offer(startNode);
		visit[0][0] = true;
		for(int i = 0; i < k - 1; i++) {
			Cell cur = pq.poll();
			if(cur.row + 1 < rowNum && !visit[cur.row + 1][cur.col]) {
				pq.offer(new Cell(cur.row + 1,cur.col,matrix[cur.row +1 ][cur.col]));
				visit[cur.row + 1][cur.col] = true;
			}
			if(cur.col + 1 < colNum && !visit[cur.row][cur.col + 1]) {
				pq.offer(new Cell(cur.row,cur.col + 1,matrix[cur.row][cur.col + 1]));
				visit[cur.row][cur.col + 1] = true;
			}
			
		}
		return pq.peek().value;
	}
	
	/*
	 * solution2: hashset to de-duplicate which is not complete.
	 */
//	public int kthSmallest(int[][] matrix, int k) {
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		HashSet<Integer> deDup = new HashSet<>();
//		int i = 0, j = 0;
//		pq.offer(matrix[i][j]);
//		int count = 0;
//		while(!pq.isEmpty()) {
//			pq.poll();//expansion
//			if(i + 1 <= matrix.length ) {
//				pq.add(matrix[i+1][j]);
//			}
//			if(j + 1 <= matrix[0].length - 1) {
//				pq.add(matrix[i][j+1]);
//			}
//		}
//		Iterator<Integer> it = deDup.iterator();
//		int res = 0;
//		while(count < k) {
//			res = it.next();
//			count++;
//		}
//		return res;
//	}
}
