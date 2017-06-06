package class5HeapAndGraph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

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
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		HashSet<Integer> deDup = new HashSet<>();
		int i = 0, j = 0;
		pq.offer(matrix[i][j]);
		int count = 0;
		while(!pq.isEmpty()) {
			pq.poll();//expansion
			if(i + 1 <= matrix.length ) {
				pq.add(matrix[i+1][j]);
			}
			if(j + 1 <= matrix[0].length - 1) {
				pq.add(matrix[i][j+1]);
			}
		}
		Iterator<Integer> it = deDup.iterator();
		int res = 0;
		while(count < k) {
			res = it.next();
			count++;
		}
		return res;
	}
}
