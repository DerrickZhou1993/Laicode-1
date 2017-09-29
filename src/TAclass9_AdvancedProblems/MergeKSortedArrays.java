package TAclass9_AdvancedProblems;

import java.util.PriorityQueue;

/**
 * 
 * @author guoyifeng
 *	Merge K sorted array into one big sorted array in ascending order.

	Assumptions
	
	The input arrayOfArrays is not null, none of the arrays is null either.
 */
/*
 * basic idea: use class Element to represent node in arrays with their x coordinate, y coordinate
 * and its value
 * use PriorityQueue to guarantee ascending order
 */
public class MergeKSortedArrays {
	class Element implements Comparable<Element>{
		private int x; // row idx
		private int y; // column idx
		private int value;
		public Element(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public int compareTo(Element e) {
			if (this.value == e.value) {
				return 0;
			}
			return this.value < e.value ? -1 : 1;
		}
	}
	public int[] merge(int[][] arrays) {
		PriorityQueue<Element> minHeap = new PriorityQueue<>(); // min heap
		int len = 0; // length of result array
		for (int i = 0; i < arrays.length; i++) {
			int[] arr = arrays[i];
			if (arr.length > 0) {
				minHeap.offer(new Element(i, 0, arr[0]));
			}
			len += arr.length;
		}
		int[] res = new int[len];
		int cur = 0; // current pointer
		while (!minHeap.isEmpty()) {
			Element e = minHeap.poll();
			res[cur++] = e.value;
			// if current element has no next element in its located array
			if (e.y + 1 >= arrays[e.x].length) {
				continue;
			}
			// move pointer forward and add next into minHeap
			minHeap.offer(new Element(e.x, e.y + 1, arrays[e.x][e.y + 1]));
		}
		return res;
	}
}

