package TAclass9_AdvancedProblems;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 
 * @author guoyifeng
 	Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
/*
 * min heap size is k
 * so for min heap: offer() and poll() cost O(logk) time
 * assume each linked list contains average n nodes
 * so there are totally n * k nodes in lists
 * so we have to run heap API for n * k times
 * time = O(n * k * logk)
 * space = O(n * k)
 */
class ListNode {
	ListNode next;
	public int val;
	public ListNode(int val) {
		this.val = val;
	}
}
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(11, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				if (n1.val == n2.val) {
					return 0;
				}
				return n1.val < n2.val ? -1 : 1;
			}
		});
		// add each head node into MinHeap
		// time = O(nlogn)
		for (ListNode head : lists) {
            if (head != null) {
			    minHeap.offer(head);
            }
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (!minHeap.isEmpty()) {
			ListNode tmp = minHeap.poll();
			cur.next = tmp;
			cur = cur.next;
			if (tmp.next == null) {
				continue;
			}
			minHeap.offer(tmp.next);
		}
		return dummy.next;
	}
}

