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

/*	  to reverse 1 -> 2 -> 3 -> null  we need to reverse 2 -> 3 -> null .... after recursion  3 -> 2 -> 1 -> null
 * 	  
 *    1 -> 2 -> 3 -> null
 *    1 -->   2 -> 3 -> null
 *    1 -->   2 -->   <- 3
 *    1 --> 2 <- 3
 *    null <- 1 <- 2 <- 3
 *    
 *    and the base case should be head == null or head.next == null
 */
public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }
}