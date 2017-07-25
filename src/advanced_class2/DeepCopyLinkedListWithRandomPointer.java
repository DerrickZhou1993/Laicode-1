package advanced_class2;


/*
 * the challenge: how to copy establish a one-to-one mapping relationship 
 * between original node and copy node
 * the original node mustn't be copied more than once
 */

/*
 * basic idea: use a HashMap to maintain the state if 
 * the current node has been copied or not
 * eg: HashMap<Key = Node1, value = Node1`>
 * 
 * copy next pointer iteratively
 * copy random pointer iteratively
 * use HashMap to de-duplicate
 */
public class DeepCopyLinkedListWithRandomPointer {

}
