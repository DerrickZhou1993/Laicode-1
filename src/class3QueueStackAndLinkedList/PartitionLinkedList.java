package class3QueueStackAndLinkedList;

/**
 *
 * @author @Yifeng
 * Given a linked list and a target value T, partition it such that all nodes less than T
 * are listed before the nodes larger than or equal to target value T.
 * The original relative order of the nodes in each of the two partitions should be preserved.

Examples

L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3,
is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
 */


/*
 *  example:   L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3
 *  	step1: initialize two LinkedLists heads;
 *
 *  	step2:
 *  		Iterate each element in the list and compare the current node's value to the target's value
 *  			case1:
 *  				if current node's value < target's value, add the current node to the tail of first LinkedList;
 *  			case2:
 *  				else, add the current node to the tail of second LinkedList;
 *  		The result should like below:
 *  			LinkedList1: to store nodes less than target     			  2 -> 1
 *  			LinkedList2: to store nodes greater than or equal to target   4 -> 3 -> 5
 *
 *  	step3: Concatenate the tail of first half to the head of second half
 *  			2 -> 1 -> 4 -> 3 -> 5;
 *  	step4: Do not forget to add null to the tail of second half;
 *  			2 -> 1 -> 4 -> 3 -> 5 -> null;
 */

/**
 *
 * @author @Yifeng
 *  My first accepted version
 */
public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        // head.next != null is to check if list only has one element in which case using two aux lists will cause bug
        if (head == null || head.next == null) {
            return head;
        }
        // step1:
        ListNode smallHead = new ListNode(0);
        ListNode smallCur = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode largeCur = largeHead;

        // step2:
        while (head != null) { //must head != null or the last element may be ruled out if use head.next != null
            if (head.value < target) {
                smallCur.next = head;
                smallCur = smallCur.next;
            } else {
                largeCur.next = head;
                largeCur = largeCur.next;
            }
            head = head.next;
        }

        smallCur.next = largeHead.next; // step 3: concatenation

        largeCur.next = null;     // step 4 set null at tail

        //I don't know if small LinkedList does have elements or not, do not move smallHead or largeHead!!!!
        //remember dummy node has no real meaning, what matters is dummy.next
        //even if small LinkedList is null in some cases, smallHead is a dummynode, its next node should
        //be largeHead.next in all cases because smallCur.next = largeHead.next and smallCur does not move when
        //small LinkedList is null;
        return smallHead.next;
    }



    /*
     * My first accepted version which is not good enough, the final return sentence is
     * too much complicated to check if target is smaller than any node's value in the
     * original LinkedList
     * Plus, not using a cur node to maintain current position makes while loop more complex;
     */
//    public ListNode partition(ListNode head, int target) {
//        if (head == null) {
//            return head;
//        }
//        // step1:
//        ListNode smallHead = new ListNode(0);
//        ListNode smallCur = smallHead;
//        ListNode largeHead = new ListNode(0);
//        ListNode largeCur = largeHead;
//
//        // step2:
//        while (head != null) { //must head != null or the last element may be ruled out if use head.next != null
//            if (head.value < target) {
//                smallCur.next = head;
//                smallCur = smallCur.next;
//                head = head.next;
//            } else {
//                largeCur.next = head;
//                largeCur = largeCur.next;
//                head = head.next;
//            }
//        }
//        smallHead = smallHead.next; // put fakeHead to current half's real head
//        largeHead = largeHead.next;
//
//        smallCur.next = largeHead; // step 3: concatenation
//
//        largeCur.next = null;     // step 4 set null at tail
//
//        return (smallHead == null ? largeHead : smallHead); // if input is like {2} target is 1, so smallHead is null always
//    }
}
