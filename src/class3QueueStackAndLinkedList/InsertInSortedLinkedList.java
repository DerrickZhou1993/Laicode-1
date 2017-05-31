package class3QueueStackAndLinkedList;

/**
 * 
 * @author @Yifeng
 * Insert a value in a sorted linked list.

	Examples
	
	L = null, insert 1, return 1 -> null
	L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
	L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
	L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null
 
 */
public class InsertInSortedLinkedList {
	public ListNode insert(ListNode head, int value) {
		// head is null, the inserted one is new head; its next is null;
		if(head == null) {
			ListNode newHead = new ListNode(value);
			newHead.next = head;
			return newHead;
		}
		ListNode cur = head;
		//if inserted position is before the head;
		if(cur.value >= value) {
			ListNode newHead = new ListNode(value);
			newHead.next = head;
			return newHead;
		}
		
		//if insert position is between head and tail;
		while(cur.next != null) {
			if(cur.next.value >= value) {
				ListNode insert = new ListNode(value);
				insert.next = cur.next;
				cur.next = insert;
				return head;
			}
			cur = cur.next;
		}
		
		// if insert position is after the tail, make a new tail and its next is null;
		if(cur.next == null && cur.value <= value) {
			ListNode insert = new ListNode(value);
			cur.next = insert;
			insert.next = null;
			return head;
		}
		
		return head;
	}
}
