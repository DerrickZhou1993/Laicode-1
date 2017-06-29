package class14ProbabilityAndSamplingAndRandomization;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 
 * @author guoyifeng
 * Given an unlimited flow of numbers, keep track of the median of all elements seen so far.

	You will have to implement the following two methods for the class
	
	read(int value) - read one value from the flow
	median() - return the median at any time, return null if there is no value read so far
	Examples
	
	read(1), median is 1
	read(2), median is 1.5
	read(3), median is 2
	read(10), median is 2.5
	......

 */
public class MedianTracker {
	PriorityQueue<Integer> small;// maintain small.size() can only be larger than
									// large by 1
	PriorityQueue<Integer> large;

	public MedianTracker() {
		// add new fields and complete the constructor if necessary.
		small = new PriorityQueue<>(Collections.reverseOrder());// maxheap
		large = new PriorityQueue<>();// minheap
	}

	public void read(int value) {
		// write your implementation here.
		if (small.isEmpty() || value < small.peek()) {
			small.offer(value);
		} else {
			large.offer(value);
		}
		if (small.size() - large.size() >= 2) {
			large.offer(small.poll());
		} else if (large.size() - small.size() > 0) {
			small.offer(large.poll());
		}
	}

	public Double median() {
		// write your implementation here.
		int size = small.size() + large.size();
		if (size == 0) {
			return null;
		} else if (size % 2 != 0) {
			return (double) small.peek();
		} else if (size % 2 == 0) {
			return (double) (small.peek() + large.peek()) / 2.0;
		}
		return null;
	}
}
