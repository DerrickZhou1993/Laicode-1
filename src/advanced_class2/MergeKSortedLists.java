package advanced_class2;
/**
 * 
 * @author @Yifeng
 * Merge K sorted lists into one big sorted list in ascending order.

	Assumptions
	
	ListOfLists is not null, and none of the lists is null.
 */

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * basic idea: similar to Merge K Sorted Arrays
 * 			   what need to focus is the operation
 * 			   on ListNode
 */



public class MergeKSortedLists {
	class ListNode {
		public int value;
		public ListNode next;

		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}
	class myComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode n1, ListNode n2) {
			if (n1.value == n2.value) {
				return 0;
			}
			return n1.value < n2.value ? -1 : 1;
		}
	}
	public ListNode merge(List<ListNode> listOfLists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new myComparator());
		ListNode dummy = new ListNode(0); //for we do not know which ListNode is head of result LinkList
		for (ListNode node : listOfLists) {
			if (node != null) { //if null, do not add to PQ
				minHeap.offer(node);
			}
		}
		ListNode cur = dummy;
		while (!minHeap.isEmpty()) {
			cur.next = minHeap.poll();
			if (cur.next.next != null) {
				minHeap.offer(cur.next.next);
			}
			cur = cur.next;
		}
		return dummy.next;
	} 
}


