package TAclass7_Iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * 
 * @author guoyifeng
 	Given two 1d vectors, implement an iterator to return their elements alternately.

	For example, given two 1d vectors:
	
	v1 = [1, 2]
	v2 = [3, 4, 5, 6]
	By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
	
	Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
	
	Clarification for the follow up question - Update (2015-09-18):
	The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" 
	with "Cyclic". For example, given the following input:
	
	[1,2,3]
	[4,5,6,7]
	[8,9]
	It should return [1,4,8,2,5,9,3,6,7].
 */
public class ZigzagIterator {
	private List<Integer> v1;
	private List<Integer> v2;
	private int index1;
	private int index2;
	private int count;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.v1 = v1;
		this.v2 = v2;
		index1 = 0;
		index2 = 0;
		count = 0;
	}

	public int next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		if (index1 < v1.size() && index2 < v2.size()) {
			if (count % 2 == 0) {
				count++;
				return v1.get(index1++);
			} else {
				count++;
				return v2.get(index2++);
			}
		} else if (index1 >= v1.size()) {
			return v2.get(index2++);
		} else {
			return v1.get(index1++);
		}
	}

	public boolean hasNext() {
		return index1 < v1.size() || index2 < v2.size();
	}
	
	public static void main(String[] args) {
		int[] arr1 = new int[] {1,3,5,7,9};
		int[] arr2 = new int[] {2,4,6,8,10};
		List<Integer> v1 = new ArrayList<>();
		List<Integer> v2 = new ArrayList<>();
		for (int i : arr1) {
			v1.add(i);
		}
		for (int i : arr2) {
			v2.add(i);
		}
		ZigzagIterator it = new ZigzagIterator(v1, v2);
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
}
