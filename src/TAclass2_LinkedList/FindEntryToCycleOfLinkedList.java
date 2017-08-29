package TAclass2_LinkedList;
/**
 * 
 * @author yifengguo
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

	Note: Do not modify the linked list.
	
	Follow up:
	Can you solve it without using extra space?
 */
/*
 * time = O(n ^ 2)
 * space = O(1)
 */
public class FindEntryToCycleOfLinkedList {
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;

		// to find the node which slow and fast meet
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				// move slow back to head
				slow = head;
				// move slow and fast one step each time until they meet again
				while (slow != fast) {
					fast = fast.next;
					slow = slow.next;
				}
				// when slow and fast meet again, this node is entry to cycle
				return slow;
			}
		}
		return null;
	}
}
