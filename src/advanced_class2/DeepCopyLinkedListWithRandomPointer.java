package advanced_class2;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author @Yifeng
 * Each of the nodes in the linked list has another pointer pointing to a random node in the list or null.
 *  Make a deep copy of the original list.
 */

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
	class RandomListNode {
		public int value;
		public RandomListNode next;
		public RandomListNode random;

		public RandomListNode(int value) {
			this.value = value;
		}
	}

	public RandomListNode copy(RandomListNode head) {
		if (head == null) {
			return head;
		}
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode newHead = new RandomListNode(head.value);
		map.put(head, newHead);
		RandomListNode cur = newHead;//current pointer for new LinkedList
		while (head != null) { // copy node iteratively
			if (head.random != null) {
				if (!map.containsKey(head.random)) { // check current node has
														// not been copied by
														// next pointer
					map.put(head.random, new RandomListNode(head.random.value));
				}
				cur.random = map.get(head.random);
			}

			if (head.next != null) {
				if (!map.containsKey(head.next)) { // check current node has 
												   // not been copied by
												   // random pointer
					map.put(head.next, new RandomListNode(head.next.value));
				}
				cur.next = map.get(head.next);
			}
			head = head.next;
			cur = cur.next;
		}
		return newHead;
	}
}
