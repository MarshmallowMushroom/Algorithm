/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        
        ListNode result = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode r = result;
        int carry = 0;
        while(!(p1 == null && p2 == null)) {
            int op1 = 0;
            int op2 = 0;
            if (p1 != null) {
                op1 = p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                op2 = p2.val;
                p2 = p2.next;
            }
            ListNode sum = new ListNode((op1 + op2 + carry)%10);
            carry = (op1 + op2 + carry)/10;
            r.next = sum;
            r = r.next;
        }
        if (carry == 1) {
            r.next = new ListNode(1);
        }
            
        return result.next;
    }
}
