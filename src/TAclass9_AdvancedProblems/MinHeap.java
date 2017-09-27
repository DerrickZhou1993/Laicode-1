package TAclass9_AdvancedProblems;
/**
 * 
 * @author yifengguo
 * This class is a simple implementation of MinHeap
 * with basic APIs offered
 */
public class MinHeap {
	private int[] array;
	private int size;
	
	// constructor
	public MinHeap(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("Input array cannot be null or empty");
		}
		this.array = array;
		size = array.length;
		heapify(array);
	}
	
	public void heapify(int[] array) {
		for (int i = array.length / 2 - 1; i >= 0 ;i--) {
			percolateDown(i);
		}
	}
	public void offer(int element) {
		
	}
	
	/*
	 * from last node to root which has left child or right child
	 * compare parent value with its child's value, if parent's value
	 * is smaller than its childs', swap them
	 */
	public void percolateDown(int i) {
		// last parent's index is (size / 2 - 1)
		while(i <= size / 2 - 1) {
			int leftChildIdx = 2 * i + 1;
			int rightChildIdx = 2 * i + 2;
			/*
			 * for heap is complete tree 
			 * so for last parent node
			 * it must have left child node, but
			 * not guarantee have right child node
			 */
			int swapCandidate = leftChildIdx;
			// determine if right child node exists and its value is smaller than left child node
			if (rightChildIdx <= size - 1 && array[leftChildIdx] > array[rightChildIdx]) {
				swapCandidate = rightChildIdx;
			}
			// swap if necessary
			if (array[i] < array[swapCandidate]) {
				swap(array, i, swapCandidate);
			} else {
				break; // do not need further percolate down
			}
			i = swapCandidate; 
		}
		
	}
	
	public void percolateUp(int i) {
		
	}
	
	private void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
}
