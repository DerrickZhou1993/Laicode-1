package TAclass7_Iterator;

import java.util.NoSuchElementException;

/**
 * 
 * @author @Yifeng
 * implement iterator for an array 
 */
public class ArrayIterator {
	 // member field
	 private int index;
	 private int[] array;
	 
	 // constructor
	 public ArrayIterator(int[] array) {
		 this.array = array;
		 index = 0;
	 }
	 
	 public boolean hasNext() {
		 return index < array.length;
	 }
	 
	 public int next() {
		 if (!hasNext()) {  // should handle this kind of potential exception
			 throw new NoSuchElementException("The array is empty or index is out of bound");
		 }
		 return array[index++];
	 }
	 
	 public static void main(String[] args) {
		 int[] array1 = new int[] {1, 2, 3, 4, 5};
		 int[] array2 = new int[] {};
		 
		 ArrayIterator it1 = new ArrayIterator(array1);
		 while (it1.hasNext()) {
			 System.out.print(it1.next() + " ");
		 }
		 
		 System.out.println();
		 
		 // handle exception when array is empty or index is out of bound
		 ArrayIterator it2 = new ArrayIterator(array2);
		 System.out.print(it2.next());
	 }
}
