package TAclass2_LinkedList;

class ListNode {
	public ListNode next;
	public int key;
	public ListNode(int key) {
		this.key = key;
	}
}
/*
 * for both solutions
 * time O(n) 
 * space O(1)
 */
public class ReverseLinkedList {
	/*
	 * sol1: recursion
	 * 1->2->3->4
	 * 1     <- 2->3->4
	 * head
	 */
	public ListNode reverseByRecursion(ListNode head) {
		// base case
		if (head == null || head.next == null) {
			return head;
		}
		// recursive rule at current layer
		ListNode newHead = reverseByRecursion(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	/*
	 *          1 <-  2  ->  3  ->  4
	 * 	       prev     
	 *              cur
	 *                     next
	 */
	public ListNode reverseByIteration(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur; // move references prev and cur
			cur = next; // cur.next is changed, we can only use next pointer here
		}
		return prev;
	}
}
