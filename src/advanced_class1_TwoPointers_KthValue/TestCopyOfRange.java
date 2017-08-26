package advanced_class1_TwoPointers_KthValue;

import java.util.Arrays;

public class TestCopyOfRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5};
		int[] b = Arrays.copyOfRange(a, 0, 3);//the right limit is excluded!!!
		for(int i : b) {
			System.out.print(i + " ");
		}
	}

}
