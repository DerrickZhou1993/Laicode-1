package TAclass9_AdvancedProblems;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 
 * @author guoyifeng
 * 
 	Median is the middle value in an ordered integer list. If the size of the list is even, 
 	there is no middle value. So the median is the mean of the two middle value.

	Examples: 
	[2,3,4] , the median is 3
	
	[2,3], the median is (2 + 3) / 2 = 2.5
	
	Design a data structure that supports the following two operations:
	
	void addNum(int num) - Add a integer number from the data stream to the data structure.
	double findMedian() - Return the median of all elements so far.
	For example:
	
	addNum(1)
	addNum(2)
	findMedian() -> 1.5
	addNum(3) 
	findMedian() -> 2
 */
/*
 * basic idea is to maintain two priority queues
 * one is minHeap and another is maxHeap
 * goal is to guarantee median of data stream 
 * if data stream length is odd, return minHeap.peek()
 * else return  ( min.peek() + max.peek() ) / 2
 */
public class MedianTracker {
	private PriorityQueue<Integer> min;
	private PriorityQueue<Integer> max;
    /** initialize your data structure here. */
    public MedianTracker() {
        min = new PriorityQueue<>(); // min heap
        max = new PriorityQueue<>(Collections.reverseOrder()); // max heap
    }
    
    /*
     * min: first n / 2 data
     * max: last n / 2 data
     * maintain minHeap.size() - maxHeap.size() <= 1
     * and maxheap.size() < minheap.size()
     * so if data stream length is odd, return minHeap.peek()
     * else return (double) ( min.peek() + max.peek() ) / 2
     */
    public void addNum(int num) {
        if (min.isEmpty()) {
        	min.offer(num);
        } else if (num < min.peek()) {
        	max.offer(num);
        } else {
        	min.offer(num);
        }
        if (max.size() > min.size()) {
        	min.offer(max.poll());
        } else if (min.size() - max.size() > 1) {
        	max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() == min.size()) {
        	return (double )(max.peek() + min.peek()) / 2;
        } else {
        	return min.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
