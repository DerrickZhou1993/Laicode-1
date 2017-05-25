package class2BinarySearchAndRecursion;

/**
 * 
 * @author Yifeng
 *  Evaluate a to the power of b, assuming both a and b are integers and b is non-negative. 

	Examples
	
	power(2, 0) = 1
	power(2, 3) = 8
	power(0, 10) = 0
	power(-2, 5) = -32
	Corner Cases

 */
public class PowerAB {
	public long power(int a, int b) {
		// // Write your solution here
		// if(a == 0) {
		// return 0;
		// }
		// if(a == 1) {
		// return 1;
		// }
		// if(b == 0) {
		// return 1;
		// }
		// return a * power(a,b-1);

		if (a == 0) {
			return 1;
		}
		if (b == 0) {
			return 1;
		}
		long half_result = power(a, b / 2);
		if (b % 2 == 0) {
			return half_result * half_result;
		} else {
			return half_result * half_result * a;
		}
	}
}
