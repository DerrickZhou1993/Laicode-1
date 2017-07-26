package advanced_class4_recursion4_DFS_NSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> allTriples(int[] array, int target) {
		if(array.length <=2) { //corner case
			return null;
		}
		Arrays.sort(array); //use two pointers so the array must be sorted before process
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0; i < array.length - 2; i++) {
		  //if array is like 1 1 1 1, we only use first occurrence of element
		  //and ignore the following duplicate to avoid duplicate result
		  if(i > 0 && array[i] == array[i - 1]) {
		    continue;
		  }
			int left = i + 1;//search from [i+1,n-1] using two sum idea, x xxxxxxxxxx
			int right = array.length - 1;
			while(left < right) {
			  int tmp = array[left] + array[right];
			  if(tmp + array[i] == target) {
			    result.add(Arrays.asList(array[left], array[right], array[i]));
			    left++;//move the left pointer to find all pairs
			    while(left < right && array[left] == array[left - 1]) {//de-duplicate in two-sum just like outer loop of three sum
			      left++;
			    }
			  } else if(tmp + array[i] < target) {
			    left++;
			  } else {
			    right--;
			  }
			}
		}
		return result;
	}
}


