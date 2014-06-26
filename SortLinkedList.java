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
    ListNode pointer;
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        //get the length of the list
        int len = 0;
        ListNode n = head;
        while(n != null) {
            len++;
            n = n.next;
        }
        pointer = head;
        return mergeSort(len);
    }
    
    public ListNode mergeSort(int len) {
        if (len == 1) {
            ListNode tmp = pointer;
            pointer = pointer.next;
            tmp.next = null;//disconnect the list for the current sublist
            return tmp;
        } 
        ListNode n1 = mergeSort(len/2);
        ListNode n2 = mergeSort(len - len/2);
        return merge(n1, n2);
    }
    
    //merge two list
    public ListNode merge(ListNode n1, ListNode n2) {
        ListNode helper = new ListNode(-1);
        ListNode n = helper;
        while(n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                n.next = n1;
                n1 = n1.next;
            }
            else {
                n.next = n2;
                n2 = n2.next;
            }
            n = n.next;
        }
        if (n1 != null)
            n.next = n1;
        else
            n.next = n2;
        return helper.next;
    }
}
