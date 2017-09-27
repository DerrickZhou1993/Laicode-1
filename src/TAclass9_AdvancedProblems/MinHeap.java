package TAclass9_AdvancedProblems;

import java.util.NoSuchElementException;

/**
 * 
 * @author yifengguo
 * This class is a simple implementation of MinHeap
 * with basic APIs offered
 */
public class MinHeap {
	private int[] array;
	private int size;
	
	/**
	 * constructor 1<br>
	 *  initialize min heap given a certain array
	 * @param array
	 */
	public MinHeap(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("Input array cannot be null or empty");
		}
		this.array = array;
		size = array.length;
		heapify(array);
	}
	
	/**
	 * constructor 2<br>
	 * given certain capacity and initialize a new heap
	 * @param cap
	 */
	public MinHeap(int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException("The capacity cannot be 0 or negative");
		}
		array = new int[cap];
		size = 0; // value of array has not been initialized yet
	}
	
	
	/**
	 * heapify given array by percolate down
	 * each parent node from last level to root level
	 */
	public void heapify(int[] array) {
		for (int i = array.length / 2 - 1; i >= 0 ;i--) {
			percolateDown(i);
		}
	}
	

	/**
	 *
	 * offer a new element into the heap<br>
	 * if current heap is full, we need to resize the array<br>
	 * time = O(n)  (resizing cost O(n))<br>
	 *
	 * @param element
	 */
	public void offer(int element) {
		if (size == array.length) {
			int[] newArray = new int[(int) (array.length * 1.5)];
			copy(newArray, array);
			array = newArray; // update array as newArray after resizing
		}
		array[size] = element;
		size++;
		percolateUp(size - 1); // percolate up new added element which in on last index of array
	}
	/**
	 * copy each element of original array to resized new array
	 * @param newArray
	 * @param array
	 */
	private void copy(int[] newArray, int[] array) {
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
	}
	
	/**
	 * return top element of heap without removing it
	 * @return
	 */
	public int peek() {
		if (size == 0) {
			return -1;
		}
		return array[0];
	}
	/**
	 * return if current heap is empty or not
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * return if current heap is full or not
	 * @return
	 */
	public boolean isFull() {
		return size == array.length;
	}
	
	/**
	 * 
	 * poll top element of heap<br> 
	 * time = O(logn) for percolate down need O(logn)<br>
	 * the trick is replace top element by last element in the array<br>
	 * and percolate it down, this could minimize the effect on original array<br>
	 *
	 * @return
	 */
	public int poll() {
		if (size == 0) {
			throw new NoSuchElementException("The heap is empty and cannot poll element");
		}
		int res = array[0];
		array[0] = array[size - 1]; // change array[0] as array[size - 1] to minimize effect on array
		size--; // delete last element
		percolateDown(0); // percolate top element down
		return res;
	}
	
	
	/**
	 * 
	 * percolateDown(int index)    time = O(logn)<br>
	 * 
	 * from last node to root which has left child or right child<br>
	 * compare parent value with its child's value, if parent's value<br>
	 * is smaller than its childs', swap them<br>
	 *
	 * @param i
	 */
	public void percolateDown(int i) {
		// last parent's index is (size / 2 - 1)
		while(i <= size / 2 - 1) { // while array[i] has chance to have children
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
	
	/**
	 * 
	 *  percolateUp(int index)    time = O(logn) <br>
	  	when:<br>
		 	the element needs to be moved up to maintain the heap's property, for example<br>
		 	when offering a new element into the heap<br>
		how: <br>
			compare the element with its parent, move it up when necessary. Do this until the<br>
			element does not need to be moved<br>
	 *
	 * @param i
	 */
	public void percolateUp(int i) {
		while (i > 0) {
			int parentIdx = (i - 1) / 2;
			if (array[i] < array[parentIdx]) {
				swap(array, i, parentIdx);
			} else {
				break;
			}
			i = parentIdx;
		}
	}
	
	private void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	
	/**
	 * 
	 * @param index index of element which need to be update by new input element
	 * @param element update array[index] with element
	 * @return original element of heap
	 */
	public int update (int index, int element) {
		int res = array[index]; // orignal element is the result to return
		/*
		 * maintain heap property by percolateDown or percolateUp
		 * it depends on new element and original element value relationship
		 */
		array[index] = element;
		if (element > res) {
			percolateDown(index);
		} else {
			percolateUp(index);
		}
		return res;
	}
}
