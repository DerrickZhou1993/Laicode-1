package advanced_class2;

/*
 * Challenge1: De-duplicate copies
 * Challenge2: Function Signature (input node and return node definition)
 * Challenge3: Recursion Function to copy a node and all the neighbors of it(base case to de-duplicate)
 * 
 * basic idea: DFS
 *    N1          N1`
 *   /  \        /  \  
 *  N2 --N3     N2`-- N3` 
 *  
 *  
 *  Time Complexity: O(V + 2E) = O(V + E)
 *  	For each node of graph, DFS will traverse each neighbor of node's neighbor list
 *  	the eage between each node. So Time Complexity is O(E + V)
 *  	
 *  Space Complexity: = V (HashMap was initialized out of the helper function)
 *  					And the HashMap will hold V nodes at most
 */

public class CopyGraphWithPossibleCycles {

}
