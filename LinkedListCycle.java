/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //find there is a cycle or not
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null) {
            fast = fast.next;
            if (fast == slow)
                return true;
            if (fast == null)
                break;
            fast = fast.next;
            slow = slow.next;
        }
        return false;
    }
}

//find the beginning of the cycle
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean cycle = false;
        //the algorithm works when we advance both slow and fast, then compare equivalance
        while(fast != null) {
            fast = fast.next;
            if (fast == null)
                break;
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (!cycle)
            return null;
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
