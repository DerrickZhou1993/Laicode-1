package TAclass7_Iterator;
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
	
	// constrcutor
	public TwoStepIterator(int[] array) {
		this.array = array;
		index = 0;
	}
	
	public boolean hasNext() {
		
	}
	
	public int next() {
		
	}
	public static void main(String[] args) {

	}

}
