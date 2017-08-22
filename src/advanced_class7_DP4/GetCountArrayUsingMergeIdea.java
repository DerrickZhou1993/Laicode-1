package advanced_class7_DP4;
/**
 * 
 * @author @Yifeng
 * Given an array A with all positive integers from [1...N]. How to get an array B such that B[i] represents 
 * how many elements A[j] (j > i) in array A that are smaller than A[i].

	Assumptions:
	
	The given array A is not null.
	Examples:
	
	A = { 4, 1, 3, 2 }, we should get B = { 3, 0, 1, 0 }.
	Requirement:
	
	time complexity = O(nlogn).
 */

/*
 *                    index  0 1 2 3
 *                         ={4,1,3,2}
 *                         ={1,2,3,4}
 *           
 *           4(0)  1(0)  |   3(0)   2(0)
 *                          
 *        4(0) 1(0)               3,2
 *        
 *   4(0)        1(0)             
 *   ==========================================================================
 *   move the smaller one idea:
 *   first layer:
 *   left = 4(0)                                    left = 3(0)
 *                i->                                       i->
 *   right = 1(0)                                   right = 2(0)
 *                j->                                       j->
 *                
 *     Merge Idea in this problem           
 *     whenever we move the number from "right", value in the parenthesis will not change
 *     (because the question need us to find how many elements are smaller than current on the "right" side,
 *     and if we move number from right, there is no other elements to the right of current)
 *     
 *     whenever we move the number from "left" side, we need to count i + j to calculate how many elements 
 *     are on the right side of current and are smaller than it
 *     
 *     demo: 1 is from left side of merge process, and 1 is smaller than 4, so we move 1 first, and there is 
 *           no element on the right side of 1 which is smaller than it, so 1(0), j++. And when we move 4 
 *           from right side of merge process, 1 is on the right of 4 and 1 is smaller than 4, so 4(1), i++
 *     
 *     second layer:
 *     move 1(smaller), j++                          move 2(smaller) j++
 *     solu = 1(0)                                    
 *         j is out of limit, 
 *         must move i
 *     solu_left = 1(0)4(0+1=1)                      solu = solu_right = 2(0)3(0+1=1)
 *     
 *                 
 *     left =  1(0), 4(1)
 *                   i
 *     right = 2(0), 3(1)
 *                        j   
 *             
 *   	demo: after first layer merge, we now have new left side and right side subarray, and 
 *   	      now we begin merge this pair of left and right subarray
 *   		  1 < 2, so we move 1 from left side, because i == 0 and j == 0 currently, so 1(0),i++
 *   		  now 2 < 4, so we move 2 from right side, so directly 2(0) for no smaller element on
 *  		  the right side of 2, j++
 *  		  now 3 < 4, so we move 3 from right side, so directly 3(1) for only 2 is on the right
 *  		  side of 3 which we found this in first merge layer, j++;  j = 2 now
 *  		  finally, we move 4 from left side, and 1 == 1 and j == 2 now, so 4 (1 + 2) = 4(3)
 *  		  
 *       the result: 4(3) 1(0) 3(1) 2(0)   --> {3,0,1,0}
 *            
 *           
 */
public class GetCountArrayUsingMergeIdea {

}
