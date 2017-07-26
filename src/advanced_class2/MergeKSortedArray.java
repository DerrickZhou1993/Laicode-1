package advanced_class2;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Assumptions: 1.duplication
 * 				2.data type
 * 				3.k vs array.length
 * 				4.array.length
 * 				5.ascending / descending order?
 */

/*
 * General Solutions to K-something problems
 * 
 * 1. Iterative ways:
 *  A1 A2->A12            2n operations
 *         A3->A13        3n
 *             A4->A14    4n
 *             ...        kn
 *  Time Complexity: (2+3+4+...+k) * n = O(k^2 * n)  
 *  
 * 2.Binary Reduction
 *  (not suitable for parallel computing for last time it has to compute on one machine )
 *  drawback: the disk read-write times are too much more than solution3 (logk times for each element which sol3 once for each)
 * 	A1   A12
 * 	A2       ->   A14
 *  A3   A34
 * 	A4                -> A18
 *  A5   A56
 *  A6       ->   A58
 *  A7   A78
 *  A8 
 *  ...                          log(k) columns
 *  Time Complexity:
 *  		2n * (k/2) * log(k) = O(k * n * log(k))
 *  
 *  
 * 3.k pointers (always move smaller pointer)
 * 			This solution's advantage which solution2 does not have is that
 * 			it can be implemented as Online-Algorithm. It does not need the 
 * 			whole input since the input which has been traversed can guarantee
 * 		    as processed. (Real-Time-Stream) 
 * 	xxxxxxxxxxx
 *  i->
 *  yyyyyyyyyyyyyy
 *  j->
 *  zzzzzzzz
 *  m->
 *  ...
 *  
 *  use a minHeap<Element> to record 
 *  each operation on minHeap in this case(insert and remove) is O(log(k))
 *  
 *  there are k * n Elements   ---> Time Complexity: O(k * n * log(k))
 *  
 *  
 *  class Element{
 *  	int value;
 *  	int indexOfArray; //record in which array current Element is 
 *  	int indexOfPosition; //record at which current Element is
 *  }
 *  
 *  
 */
public class MergeKSortedArray {
	class Element {
		int indexOfRow;
		int indexOfColumn;
		int value;
		public Element(int indexOfRow, int indexOfColumn, int value) {
			this.indexOfRow = indexOfRow;
			this.indexOfColumn = indexOfColumn;
			this.value = value;
		}
	}
	
	//to enable Element to be compared
	//for we need ascending order in result, so we need a minHeap
	class myComparator implements Comparator<Element> {
		@Override
		public int compare(Element e1, Element e2) {
			if (e1.value == e2.value) {
				return 0;
			}
			return e1.value < e2.value ? -1 : 1;
		}
	}
	
	public int[] merge(int[][] arrayOfArrays) {
		PriorityQueue<Element> minHeap = new PriorityQueue<>(new myComparator());
		int len = 0;
		int[] result;
		for (int i = 0; i < arrayOfArrays.length; i++) {
			int[] array = arrayOfArrays[i];
			len += array.length; //the length of result array is the sum of 
			                     //length of each array in the arrayOfArrays
			if (array.length != 0) { //initially add first entry of each array
			                         //into minHeap as start pointer
				minHeap.offer(new Element(i, 0, array[0]));
			}
		}
		result = new int[len];
		int cur = 0;//pointer of result array
		Element temp;
		while (!minHeap.isEmpty()) {
			temp = minHeap.poll();
			result[cur++] = temp.value;
			//For minHeap record current Element of each array.
			//Now we need to update current Element¡¯s next Element into
			//minHeap from its locating array. But first we need
			//to check if last added Element is last Element in
			//its locating array
			if (temp.indexOfColumn + 1 < arrayOfArrays[temp.indexOfRow].length) {
				temp.indexOfColumn++;
				temp.value = arrayOfArrays[temp.indexOfRow][temp.indexOfColumn];
				minHeap.offer(temp); //reuse temp
			}
		}
		return result;
	}
}
