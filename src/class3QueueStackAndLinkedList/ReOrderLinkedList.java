package class3QueueStackAndLinkedList;

/**
 * 
 * @author guoyifeng
 * Reorder the given singly-linked list 
 * 			N1 -> N2 -> N3 -> N4 -> ... -> Nn -> null 
 * 	  to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> ... -> null  

	Examples
	
	L = null, is reordered to null
	L = 1 -> null, is reordered to 1 -> null
	L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
	L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
 */

/*
 * Basic idea:
 * 		step1: find the middle node of the original LinkedList and split the LinkedList to two halfs by middle node;
 * 		step2: reverse second half LinkedList
 * 		step3: merge first half with reversed second half;
 * 		
 */
public class ReOrderLinkedList {
	public ListNode reorder(ListNode head) {
		if(head == null) {
			return head;
		}
		//step1
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode splitNode = slow;
		ListNode firstHead = head;
		ListNode secondHead = slow.next;
		slow.next = null;
		
		//step2
		ListNode reverseHead = reverse(secondHead);
		
		//step3
		ListNode finalHead = merge(firstHead,reverseHead);
		
		return finalHead;
	}
	
	private ListNode reverse(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	private ListNode merge(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (one != null && two != null) { // must not write like one = one.next; two = two.next at last
											 // together, because one's rest nodes will be lost when cur changes!!!
			cur.next = one;
			one = one.next;
			cur = cur.next;
			cur.next = two;
			two = two.next;
			cur = cur.next;
		}
		//at this point, one of the LinkedList has already met null, just check which LinkedList has nodes wait to be merged
		if (one == null) {  //do not have to move cur and head pointer manually like above, because only exist one LinkedList,
							//so cur.next = ?? has already linked all the nodes behind;
			cur.next = two;
		} else {
			cur.next = one;
		}
		return dummy.next;
	}
}
