package advanced_class2;
/**
 * 
 * @author @Yifeng
 * There is a wooden stick with length L >= 1, we need to cut it into pieces, 
 * where the cutting positions are defined in an int array A. 
 * The positions are guaranteed to be in ascending order in the range of [1, L - 1]. 
 * The cost of each cut is the length of the stick segment being cut. Determine the 
 * minimum total cost to cut the stick into the defined pieces.

	Examples
	
	L = 10, A = {2, 4, 7}, the minimum total cost is 10 + 4 + 6 = 20 
	(cut at 4 first then cut at 2 and cut at 7)
 */

/*
 *   0      1       2           3			4
 *   0	1	2	3	4	5	6	7	8	9	10
 *   |______|_______|___________|____________|
 *   
 *   index: 0 1 2 3 4 
 *   A{5} = {0,2,4,7,10}
 *    
 */

/* Challenge:
 * why linear scan and look back does not work?
 * if M[0] = 0
 * M[1] = ??
 * M[2] = 0
 * M[3] = ??
 * M[4] = M[2] + M[2] + cost of 4
 * M[5] = ??
 * M[6] = ??
 * M[7] = ?? M[3] + M[4] ?? but M[3] is unknown
 * 
 * 	challenge for is problem is we cannot cut at any position on the wood
 *  so we cannot record partial solution on the left-larger-segment
 */

/*
 *  Solution: explode from the middle:
 *  				[index = 0,1,2,3...N - 1]. for each M[i][j], we usually need to try
 *  				out of all possible k that (i < k < j), M[i][j] = max(M[i][k] +/-* M[k][j])
 *                  (for all possible k) 
 *     M[i][j] represents the minimum cost of cutting the wood between index i and j in the 
 *     input array A.
 *     M[1][3] = A[3] - A[1] = 7 - 2 = 5
 *     
 *     Base case: the shortest wood piece that cannot be cut any further
 *     Size = 1: M[0][1] = M[1][2] = M[2][3] = M[3][4] = 0
 *     
 *     
 *     Size = 2: M[left = i][right = i + 2]
 *     		(1) M[0][2] = (A[2] - A[0]) + M[0][1] + M[1][2]
 *                   cost of cutting 4     ×ó´ó¶Î         ÓÒÐ¡¶Î          = 4
 *          (2) M[1][3] = (A[3] - A[1]) + M[1][2] + M[2][3]
 *                   cost of cutting 5     ×ó´ó¶Î         ÓÒÐ¡¶Î          = 5
 *          (2) M[2][4] = (A[4] - A[2]) + M[2][3] + M[3][4]
 *                   cost of cutting 6     ×ó´ó¶Î         ÓÒÐ¡¶Î          = 6
 *                   
 *               
 *                   
 *      Size = 3: M[left = i][right = i + 3]
 *      	(1) M[0][3]
 *      		(a) case 1: cut at index 1
 *      				(A[3] - A[0])   + M[0][1]  +  M[1][3]
 *      				cost of cutting 7    0           5        = 12
 *              (b) case 2: cut at index 2
 *              		(A[3] - A[0])    + M[0][2]  +  M[2][3]    =  11  
 *     					cost of cutting 7     4           0
 *     M[0][3] = Math.min(case 1, case2) = 11
 *     
 *     		(2) M[1][4]
 *      		(a) case 1: cut at index 2
 *      				(A[4] - A[1])   + M[1][2]  +  M[2][4]
 *      				cost of cutting 8    0           6        = 14
 *              (b) case 2: cut at index 2
 *              		(A[4] - A[1])    + M[1][3]  +  M[3][4]    =  13  
 *     					cost of cutting 8     5           0    
 *     M[1][4] = Math.min(case 1, case2) = 13    
 *     
 *     Size = 4:
 *     M[0][4] = return result
 */

/*
 * Time Complexity: O(n ^ 2 * n) = n ^ 3
 * 					we have n^2 cases(a 2-d matrix to fill in)
 * 					and for each case we need to run a loop with n iterations to
 * 					find the min case
 * Space Complexity: O(n ^ 2) for we have a 2-d matrix to fill in
 */

/*
 *   0      1       2           3			4
 *   0	1	2	3	4	5	6	7	8	9	10
 *   |______|_______|___________|____________|
 *   
 *   index: 0  1  2  3  4 
 *   A{5} = {0,2,4,7,10}
 *   
 * fill in the matrix
 * 		index 0	  1    2    3    4
 * 		  0   x   0    4    11   20
 * 		  1   x   x    0    5    13
 * 		  2   x   x    x    0    6
 * 		  3   x   x    x    x    0
 * 		  4   x   x    x    x    x
 */
public class CuttingWood1 {
	public int minCost(int[] cuts, int length) {
		int[] array = new int[cuts.length + 2]; //to construct complete matrix
		array[0] = 0;
		for (int i = 0; i < cuts.length; i++) {
			array[i + 1] = cuts[i];
		}
		array[array.length - 1] = length;
		int[][] M = new int[array.length][array.length]; //M[i][j] represents min cost
													     //of cutting between i and j
		for (int i = 1; i < array.length; i++) { // to initialize base case : 0
			for (int j = i - 1; j >= 0; j--) {
				if (i - j == 1) { //base case
					M[j][i] = 0;
				} else {
					M[j][i] = Integer.MAX_VALUE; //unknown area
					for (int k = j + 1; k <= i - 1; k++) { //mapping 1d to 2d. i is like right limit and j is like left
						                                   //limit. k is cutting point chosen between i and j(exclusive)
						M[j][i] = Math.min(M[j][k], (M[j][k] + M[k][i]));
					}
					M[j][i] += array[i] - array[j]; //do not forget add outer cost for whole segment
				}
			}
		}
		return M[0][array.length - 1];
	}
}
