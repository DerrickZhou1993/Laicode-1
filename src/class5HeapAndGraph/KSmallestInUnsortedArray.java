package class5HeapAndGraph;

import java.util.Collections;
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
/*
 *  the comparison of time complexity on minHeap and maxHeap depends on 
 *  the relationship between k and n values
 */
public class KSmallestInUnsortedArray {
	
	/*
	 * solution1:MaxHeap
	 * 		Step 1 : heapify the first k elements  time = O(k)
	 * 		Step 2 : from the k+1-th element to the n-th element, for the current 
	 * 	             element X, if X < maxHeap.top()  -> maxHeap.pop() and then insert(X),
	 * 							else   do nothing
	 * 				 we have n-k elements and each pop() and insert(X) cost O(logn) time
	 * 		Total time = O(k + (n-k) * log(k))
	 * 
	 * 		BTW this method has an advantage that it can be implemented as online algorithm
	 *      and deal with streaming data input
	 */
	public int[] kSmallest(int[] array, int k) {
		if(array == null || k == 0) {
			return new int[0];
		}
		//initialize a max heap with k capacity and override the compare() of Comparator to make it as a max heap;
		//PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
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
				maxHeap.offer(array[i]);
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
	 * 		Step 1 : heapify the whole array     time: O(n)
	 * 		Step 2 : keep pop() for k times      time: O(k * logn)
	 * 	    Total time : O(n + k * logn)
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
