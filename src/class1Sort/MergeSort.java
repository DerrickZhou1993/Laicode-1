package class1Sort;

import java.util.Arrays;

/**
 * 
 * @author Yifeng
 *  Given an array of integers, sort the elements in the array in ascending order. 
 *  The merge sort algorithm should be used to solve this problem.

Examples

	{1} is sorted to {1}
	{1, 2, 3} is sorted to {1, 2, 3}
	{3, 2, 1} is sorted to {1, 2, 3}
	{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
	Corner Cases
	
	What if the given array is null? In this case, we do not need to do anything.
	What if the given array is of length zero? In this case, we do not need to do anything.
 */
public class MergeSort {
	  public int[] mergeSort(int[] array) {
	    // Write your solution here.
	    
	    if(array == null || array.length == 0) {
	      return array;
	    }
	    
	    int mid = array.length / 2;
	    
	    if(array.length > 1) {
	      int[] left = Arrays.copyOfRange(array,0,mid);
	      int[] right = Arrays.copyOfRange(array,mid,array.length);
	      
	      //divide
	      mergeSort(left);
	      mergeSort(right);
	      
	      //conquer
	      merge(array,left,right);
	    }
	    return array;
	  }
	  
	  public void merge(int[] array, int[] left, int[] right) {
	    int i = 0; //the start point of array
	    int l = 0,r = 0;//the start point of left and right;
	    
	    while(l < left.length && r < right.length) {
	      // put smaller element in two sub-array one by one into array[] after comparison
	      if(left[l] < right[r]) {
	        array[i] = left[l];
	        i++;
	        l++;
	      } else{
	        array[i] = right[r];
	        i++;
	        r++;
	      }
	    }
	      //if one of the subarray is totally put into array[], then put all the remaining 
	      //elements in another subarray into array[]
	    while(l < left.length) {
	      array[i] = left[l];
	      i++;
	      l++;
	    }
	    while(r < right.length) {
	      array[i] = right[r];
	      i++;
	      r++;
	    }
	  }
	}
