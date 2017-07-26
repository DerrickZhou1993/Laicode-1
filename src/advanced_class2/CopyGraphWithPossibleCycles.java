package advanced_class2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 *  	the e                                      dge between each node. So Time Complexity is O(E + V)
 *  	
 *  Space Complexity: = V (HashMap was initialized out of the helper function)
 *  					And the HashMap will hold V nodes at most
 */

public class CopyGraphWithPossibleCycles {

	class GraphNode {
		public int key;
		public List<GraphNode> neighbors;

		public GraphNode(int key) {
			this.key = key;
			this.neighbors = new ArrayList<GraphNode>();
		}
	}

	public List<GraphNode> copy(List<GraphNode> graph) {
		if (graph == null) { //corner case
			return graph;
		}
		Map<GraphNode, GraphNode> map = new HashMap<>();
		for (GraphNode node : graph) { //node here is original graph's node
			if (!map.containsKey(node)) {
				map.put(node, new GraphNode(node.key)); //construct one-to-one mapping without duplicate
				dfs(node, map); //DFS traverse all the neighbors of current node
			}
		}
		return new ArrayList<GraphNode>(map.values());
	}

	private void dfs(GraphNode head, Map<GraphNode, GraphNode> map) {
		GraphNode copyNode = map.get(head); //copyNode is current node of new graph
		for (GraphNode neighbor : head.neighbors) { //run DFS on all the neighbors of input head node of original graph
			if (!map.containsKey(neighbor)) {
				map.put(neighbor, new GraphNode(neighbor.key));
				dfs(neighbor, map);
			}
			copyNode.neighbors.add(map.get(neighbor)); // add all the neighbors to copyNode's neighbors list
		}
	}

}
