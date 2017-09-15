package TAclass6_DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author yifengguo
 	Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


	OJ's undirected graph serialization:
	Nodes are labeled uniquely.
	
	We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
	As an example, consider the serialized graph {0,1,2#1,2#2,2}.
	
	The graph has a total of three nodes, and therefore contains three parts as separated by #.
	
	First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
	Second node is labeled as 1. Connect node 1 to node 2.
	Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
	Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 */
/*
 * nodes maybe generated more than once during dfs, so we need to de-duplicate 
 */

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
/*
 * Demo:    node->     O  -----  O      original graph
 *                     | \     / | 
 *                     |  \   /  |
 *          mapping    |    O    |
 *                     |    |    |
 *                     O -- | -- O
 *                      \   |   /
 *                       \  |  /    
 *                          O           cloned graph
 *                         
 *                         
 *                         
 *      Time = O(V + E)  where V is vertices of graph and E is edges of graph
 *      Space = O(V)                   
 *                         
 *                         
 *                         
 *                         
 *                         
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        // initialize mapping between original graph and copied graph
        map.put(node, new UndirectedGraphNode(node.label)); 
        clone(node, map); // clone the graph using dfs
        return map.get(node); // return mapping node of given node in the copied graph
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (node == null) {
            return node;
        }
        UndirectedGraphNode copyNode = map.get(node); // get 'head' node of copied graph and use
                                                      // it as head node to clone the graph using dfs
        for (UndirectedGraphNode neighbor : node.neighbors) { // check original graph nodes have been copied or not
            if (!map.containsKey(neighbor)) {  // current node has not been copied
                map.put(neighbor, new UndirectedGraphNode(neighbor.label)); // copy it by mapping 
                clone(neighbor, map); // run dfs
            }
            copyNode.neighbors.add(map.get(neighbor)); // add new mapped neighbor to copyNode's neighbors
        }
        return copyNode;
        
    }
}
