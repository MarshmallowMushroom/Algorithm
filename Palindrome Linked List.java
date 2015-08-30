/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null) {
            fast = fast.next;
            if (fast.next != null)
                fast = fast.next;
            else
                break;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        next = reverse(next);
        while(next != null) {
            if (next.val != head.val)
                return false;
            next = next.next;
            head = head.next;
        }
        return head == null || head.next == null;
    }
    
    private ListNode reverse(ListNode node) {
        ListNode tail = null;
        ListNode head = node;
        while(head != null) {
            ListNode next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }
        return tail;
    }
}
