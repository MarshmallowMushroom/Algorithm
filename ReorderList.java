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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode head2 = getSecondHalfList(head);
        head2 = reverseList(head2);
        head = mergeList(head, head2);
    }
    
    public ListNode getSecondHalfList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null) {
            fast = fast.next;
            if (fast == null)
                break;
            fast = fast.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        return tmp;
    }
    
    public ListNode reverseList(ListNode head) {
        //recursively reverse the linkedlist
        if (head == null || head.next == null)
            return head;
        ListNode tmp = head.next;
        head.next = null;
        ListNode newHead = reverseList(tmp);
        tmp.next = head;
        return newHead;
    }
    
    private ListNode mergeList(ListNode head1, ListNode head2) {
        //head2 is the shorter ist
        ListNode h = new ListNode(-1);
        ListNode helper = h;
        while(head2 != null) {
            h.next = head1;
            head1 = head1.next;
            h = h.next;
            h.next = head2;
            head2 = head2.next;
            h = h.next;
        }
        h.next = head1;
        return helper.next;
    }
}
