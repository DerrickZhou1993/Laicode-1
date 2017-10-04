package TAclass7_Iterator;

import java.util.NoSuchElementException;

/**
 * 
 * @author @Yifeng
 * implement EvenIterator: when next() is called, go for two steps instead of one
 *      {1, 2, 3, 4, 5} - > {2, 4}
 *   it     it    it
 *   
 *   hint: when initializing iterator, it is pointing to the position before first element of container 
 */
public class TwoStepIterator {
	// member field
	private int[] array;
	private int index;
	
	// constructor
	public TwoStepIterator(int[] array) {
		this.array = array;
		index = -1;
	}
	
	public boolean hasNext() {
		return index + 2 < array.length;
	}
	
	public int next() {
		if (!hasNext()) {
			throw new NoSuchElementException("The array is empty or the index is out of bound");
		}
		int res =  array[index + 2];
		index += 2;
		return res;
		
	}
	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 3, 4, 5};
		TwoStepIterator it = new TwoStepIterator(array);
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

}
