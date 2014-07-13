/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        ListNode helper = new ListNode(-1);
        helper.next = head;
        ListNode p = helper;
        ListNode start = helper;
        ListNode tail = helper;
        //finding the starting and ending point
        for (int i = 0; i <= n; i++) {
            if (i == m - 1)
                start = p;
            if (i == n) {
                tail = p;
                break;
            }
            p = p.next;
        }
        ListNode end = tail.next;
        ListNode h = start.next;
        //disconnect the list we are going to reverse from the original list
        start.next = null;
        tail.next = null;
        reverse(h);
        h.next = end;
        start.next = tail;
        return helper.next;
    }
    
    //in place reverse the linkedlist.
    private void reverse(ListNode head) {
        ListNode tail = null;
        while(head != null) {
            ListNode tmp = head.next;
            head.next = tail;
            tail = head;
            head = tmp;
        }
    }
}
