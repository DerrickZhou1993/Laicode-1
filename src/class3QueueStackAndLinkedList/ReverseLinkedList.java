package class3QueueStackAndLinkedList;

/**
 * 
 * @author yifeng
 * Reverse a singly-linked list.

	Examples
	
	L = null, return null
	L = 1 -> null, return 1 -> null
	L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
 */

class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}

public class ReverseLinkedList {
	public ListNode reverse(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode second = head.next;
		head.next = null;
		
		//recursion
		ListNode head_cur = reverse(second);
		second.next = head;
		return head_cur;	
	}
}