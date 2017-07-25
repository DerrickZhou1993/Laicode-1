package advanced_class2;

/*
 * Assumptions: 1.duplication
 * 				2.data type
 * 				3.k vs array.length
 * 				4.array.length
 * 				5.ascending / descending order?
 */

/*
 * General Solutions to K-something problems
 * 
 * 1. Iterative ways:
 *  A1 A2->A12            2n operations
 *         A3->A13        3n
 *             A4->A14    4n
 *             ...        kn
 *  Time Complexity: (2+3+4+...+k) * n = O(k^2 * n)  
 *  
 * 2.Binary Reduction
 *  (not suitable for parallel computing for last time it has to compute on one machine )
 *  drawback: the disk read-write times are too much more than solution3 (logk times for each element which sol3 once for each)
 * 	A1   A12
 * 	A2       ->   A14
 *  A3   A34
 * 	A4                -> A18
 *  A5   A56
 *  A6       ->   A58
 *  A7   A78
 *  A8 
 *  ...                          log(k) columns
 *  Time Complexity:
 *  		2n * (k/2) * log(k) = O(k * n * log(k))
 *  
 *  
 * 3.k pointers (always move smaller pointer)
 * 			This solution's advantage which solution2 does not have is that
 * 			it can be implemented as Online-Algorithm. It does not need the 
 * 			whole input since the input which has been traversed can guarantee
 * 		    as processed. (Real-Time-Stream) 
 * 	xxxxxxxxxxx
 *  i->
 *  yyyyyyyyyyyyyy
 *  j->
 *  zzzzzzzz
 *  m->
 *  ...
 *  
 *  use a minHeap<Element> to record 
 *  each operation on minHeap in this case(insert and remove) is O(log(k))
 *  
 *  there are k * n Elements   ---> Time Complexity: O(k * n * log(k))
 *  
 *  
 *  class Element{
 *  	int value;
 *  	int indexOfArray; //record in which array current Element is 
 *  	int indexOfPosition; //record at which current Element is
 *  }
 *  
 *  
 */
public class MergeKSortedArray {

}
