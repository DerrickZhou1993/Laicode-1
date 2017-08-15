package finalExam;
/**
 * 
 * @author @Yifeng
 * how to cut/split the number into a minimum number of items such that
 * each item is equal to an integer's square value
 * 	Example:
 * 	4 can be split to 1+1+1=1(4items) or 2 ^ 2(1item which is the solution)
 * 		return 1
 *  10 can be split to 3^2+1^2(solution) or 4 items 2^2+2^2+1^2+1^2
 *  	return 2
 */

/*
 *  Basic idea: Left greater piece + Right smaller piece
 *  	right smaller piece means enumerate each integrate
 *  	possibility smaller than left greater piece
 *  	In this problem, left piece is number grows form 0 to num
 *  	right piece is enumerate of 1^2, 2^2, 3^2 ...
 *  	when we enumerate a right piece, it should +1 
 */

/*
 * Time = O(n ^ 1.5)
 * Space = O(n)
 */
public class CutNumberOfSquares {
	public int minItem(int num) {
		if (num <= 0) {
			return 0;
		}
		// M[i] represents minimum number of item of given number
		// such that each item is equal to an integer's square value
		int[] M = new int[num + 1];
		// base case
		M[0] = 0;
		M[1] = 1;
		
		for (int i = 1; i <= num; i++) { // left greater piece
			M[i] = i; // initialize M[i]
			for (int j = 1; j * j <= i; j++) {  // right smaller piece
				if (j * j == num) {               // is made of 0^2, 1^2, 2^2...
					M[i] = 1;                     // enumerates
					break;
				}
				M[i] = Math.min(M[i], M[i - j * j] + 1);
			}
		}
		return M[num];
	}
}
