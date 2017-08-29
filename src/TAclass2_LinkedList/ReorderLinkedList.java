package TAclass2_LinkedList;
/**
 * 
 * @author yifengguo
 * Given a singly linked list L: L0?L1?…?Ln-1?Ln,
	reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
	
	You must do this in-place without altering the nodes' values.
	
	For example,
	Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
/*
 * basic idea:
 * 		1. use two pointers to find middle node
 *      2. cut original linked list into two halves by middle node
 *      3. reverse second half list
 *      4. merge first half with reversed second half
 *      
 *      in this question, different from palindrome one, we need to 
 *      physically cut the original list into two halves.
 *      so when find middle node which is pointed by slow pointer
 *      record slow.next as secondHead
 *      and set slow.next = null to cut the list to two parts
 *      then merge two halves
 */

/*
 * time = O(n) 
 * space = O(1)
 */
public class ReorderLinkedList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
        ListNode secondHead = slow.next;
        slow.next = null; // cut original list into two parts
		ListNode h2 = reverse(secondHead); // reverse second half
		// merge
		merge(head, h2);
	}
	
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	
	// pay attention to merge process
	// how to merge two individual linked list
	private ListNode merge(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		dummy.next = one;
		ListNode cur = dummy;
		while (one != null && two != null) {
            cur.next = one;
            one = one.next;
            cur = cur.next;
            cur.next = two;
            two = two.next;
            cur = cur.next;
		}
		// if one of two halves is empty
		// directly link rest of the other one to cur
        if (one == null) {
            cur.next = two;
        } else {
            cur.next = one;
        }
		return dummy.next;
	}
}