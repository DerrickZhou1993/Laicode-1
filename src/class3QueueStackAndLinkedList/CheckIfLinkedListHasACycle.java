package class3QueueStackAndLinkedList;

import java.util.ArrayList;

/**
 * 
 * @author guoyifeng
 *	Check if a given linked list has a cycle.
 *  Return true if it does, otherwise return false.
 */

/*
 *  basic idea: use a fast and a slow pointer
 *  the fast pointer moves double distance by the slow pointer;
 *  if slow pointer and fast pointer could meet, 
 *  it means cycle exists in this linkedlist
 *  
 *  remember check the corner case;
 */
public class CheckIfLinkedListHasACycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }






    /*
     *  my fist bad implemetation which used extra collection api
     */
//	public boolean hasCycle(ListNode head) {
//		// write your solution here
//		if (head == null || head.next == null) {
//			return false;
//		}
//
//		ArrayList<ListNode> arr = new ArrayList<>();
//		while (head.next != null) {
//			arr.add(head);
//			head = head.next;
//			if (arr.contains(head.next)) {
//				return true;
//			}
//		}
//		return false;
//	}
}
