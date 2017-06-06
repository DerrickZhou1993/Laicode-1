package class5HeapAndGraph;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author guoyifeng
 * Find the K smallest numbers in an unsorted integer array A. 
 * The returned numbers should be in ascending order.

	Assumptions
	
	A is not null
	K is >= 0 and smaller than or equal to size of A
	Return
	
	an array with size K containing the K smallest numbers in ascending order
	Examples
	
	A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}

 */

public class KSmallestInUnsortedArray {
	
	/*
	 * solution1:MaxHeap
	 */
	public int[] kSmallest(int[] array, int k) {
		if(array == null || k == 0) {
			return new int[0];
		}
		//initialize a max heap with k capacity and override the compare() of Comparator to make it as a max heap;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1,Integer o2) {
				if(o1.equals(o2)) {
					return 0;
				}
				return o1 > o2 ? -1 : 1;//if o1 > o2 return -1 makes this pq as a max heap(because it is originally a min heap)
			}
		});
		for(int i = 0; i < k; i++) {
			maxHeap.offer(array[i]);
		}
		
		for(int i = k; i < array.length; i++) {
			if(array[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(array[i]);
			}
		}
		int[] res = new int[k];
		//because it is a max heap, so poll element from last to first to maintain ascending order
		for(int i = k - 1; i >= 0; i--) {
			res[i] = maxHeap.poll();
		}
		return res;
	}
	/*
	 * solution2: MinHeap
	 */
//	public int[] kSmallest(int[] array, int k) {
//		if(array == null || k == 0) {
//			return new int[0];
//		}
//		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//		int[] res = new int[k];
//		for(int i : array) {
//			minHeap.add(i);
//		}
//		for(int i = 0; i < k; i++) {
//			res[i] = minHeap.poll();
//		}
//		return res;
//	}
}
