package class3QueueStackAndLinkedList;

/**
 * 
 * @author guoyifeng
 * Find the middle node of a given linked list.

	Examples
	
	L = null, return null
	L = 1 -> null, return 1
	L = 1 -> 2 -> null, return 1
	L = 1 -> 2 -> 3 -> null, return 2
	L = 1 -> 2 -> 3 -> 4 -> null, return 2
 *
 */

/*
 *  basic idea: use fast pointer and slow pointer
 *  			fast pointer moves double distance by slow pointer;
 *  			when fast_pointer.next == null, slow pointer is at middle of this linkedlist
 */
public class MiddleNodeOfLinkedList {
	
	public ListNode middleNode(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast.next != null && fast.next.next !=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	
	
	
	
	
	
	/*
	 * my first implementation which is not good enough
	 */
//	public ListNode middleNode(ListNode head) {
//		// write your solution here
//		if (head == null || head.next == null) {
//			return head;
//		}
//		int count = 0;
//		ListNode head2 = head;
//		while (head.next != null) {
//			head = head.next;
//			count++;
//		}
//		for (int i = 0; i < count / 2; i++) {
//			head2 = head2.next;
//		}
//		return head2;
//	}
}
