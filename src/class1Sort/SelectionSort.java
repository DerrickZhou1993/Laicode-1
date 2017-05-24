package class1Sort;

/**
 * 
 * @author yifeng
 * Given an array of integers, sort the elements in the array in ascending order. 
 * The selection sort algorithm should be used to solve this problem.

	Examples
	
	{1} is sorted to {1}
	{1, 2, 3} is sorted to {1, 2, 3}
	{3, 2, 1} is sorted to {1, 2, 3}
	{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
	Corner Cases
	
	What if the given array is null? In this case, we do not need to do anything.
	What if the given array is of length zero? In this case, we do not need to do anything.
 */
public class SelectionSort {
	  public int[] solve(int[] array) {
	    if(array == null || array.length == 0) {
	      return array;
	    }
	    int temp, global;
	    for(int i = 0; i < array.length; i++) {
	      global = i;
	      for(int j = array.length - 1; j > i; j--) {
	        if(array[j] < array[global]) {
	          global = j;
	        }
	      }
	      temp = array[i];
	      array[i] = array[global];
	      array[global] = temp;
	    }
	    return array;
	  }
	}
