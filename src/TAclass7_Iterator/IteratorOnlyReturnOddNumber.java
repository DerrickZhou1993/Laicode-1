package TAclass7_Iterator;

import java.util.NoSuchElementException;

public class IteratorOnlyReturnOddNumber {
	// member field
	private int index;
	private int[] array;
	
	// constructor
	public IteratorOnlyReturnOddNumber(int[] array) {
		index = 0;
		this.array = array;
	}
	
	public boolean hasNext() {
		while (index < array.length && array[index] % 2 == 0) {  // if current number is even, index++
			index++;
		}
		return index < array.length;
	}
	
	public int next() {
		if (!hasNext()) {
			throw new NoSuchElementException("The array is empty or out of bound or has no odd element left");
		}
		return array[index++];
	}
	
	public static void main(String[] args) {
		 int[] array1 = new int[] {1, 2, 3, 4, 5,11,8,6,13,81};
		 
		 IteratorOnlyReturnOddNumber it1 = new IteratorOnlyReturnOddNumber(array1);
		 while (it1.hasNext()) {
			 System.out.print(it1.next() + " ");
		 }
	 }
}
