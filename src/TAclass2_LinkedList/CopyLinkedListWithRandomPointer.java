package TAclass2_LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author yifengguo
  
	A linked list is given such that each node contains an additional 
	random pointer which could point to any node in the list or null.
	
	Return a deep copy of the list.
 */
/*
 * basic idea:
 * 	use a hash_map to build mapping between original list and copy list
 *  guarantee each node will be copied and only be copied once
 *  (traversed by next pointer or random pointer)
 *  
 *  time = O(n)
 *  space = O(n) for hash_map
 */
public class CopyLinkedListWithRandomPointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

	public RandomListNode copy(RandomListNode head) {
		if (head == null) {
			return head;
		}
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode newHead = new RandomListNode(head.label);
		map.put(head, newHead);
		RandomListNode cur = newHead;// current pointer for new LinkedList
		while (head != null) { // copy node iteratively
			if (head.random != null) {
				if (!map.containsKey(head.random)) { // check current node has
														// not been copied by
														// next pointer
					map.put(head.random, new RandomListNode(head.random.label));
				}
				cur.random = map.get(head.random);
			}

			if (head.next != null) {
				if (!map.containsKey(head.next)) { // check current node has
													// not been copied by
													// random pointer
					map.put(head.next, new RandomListNode(head.next.label));
				}
				cur.next = map.get(head.next);
			}
			head = head.next;
			cur = cur.next;
		}
		return newHead;
	}
}

