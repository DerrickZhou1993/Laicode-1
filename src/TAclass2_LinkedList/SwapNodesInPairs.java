package TAclass2_LinkedList;
/**
 * 
 * @author @Yifeng
  Given a linked list, swap every two adjacent nodes and return its head.

	For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.
	
	Your algorithm should use only constant space. You may not modify the values in the list, 
	only nodes itself can be changed.
 */

/*
 *  1 -> 2 -> 3 -> 4
 *  
 *  2 -> 1     ->    4 -> 3
 *  
 *  2->1->4->3
 */

/*
 * time = O(n)
 * space = O(1)
 */
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverse(head);
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // pay attention to recursive parameter
        ListNode nextPair = reverse(head.next.next);
        // current layer process
        ListNode next = head.next;
        next.next = head;
        head.next = nextPair;
        return next;       
    }
    
    //sol2: iteration
    /*
     * use 4 pointers
     * 	prev
     * 	cur
     * 	next
     * 	n_next (next.next)  to link reversed pair with following listnodes
     */
    /*
     *      dummy 0->     1       ->  2 ->   3  ->   4
     *      prev         head        next    n_next
     *      		     cur
     *      
     *      reverse		
     *              0->    2     ->  1  ->   3  ->   4
     *              prev   next      cur     n_next
     *              
     *     move references
     *     		    0->    2     ->  1  ->   3  ->   4
     *                              prev     cur     next	
     *      			
     */
    public ListNode swapPairsByIteration(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode cur = head;
    	ListNode prev = dummy;
    	
    	// use 1->2 to check while loop condition validity
    	while (cur != null && cur.next != null) {
    		ListNode next = cur.next; // if cur.next == null, next does not exist
    		ListNode n_next = next.next;
    		
    		// reverse pair
    		prev.next = next;
    		next.next = cur;
    		cur.next = n_next;
    		
    		// move references
    		prev = cur;
    		cur = n_next;
    	}
    	return dummy.next;
    }
}
