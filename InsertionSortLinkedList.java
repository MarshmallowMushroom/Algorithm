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
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode result = new ListNode(-1);
        while(head != null) {
            //find a place to insert the node
            ListNode insert = result;
            ListNode n = head;
            head = head.next;
            n.next = null; //disconnect the node that will be inserted
            while(insert != null) {
                // find the first element that is greater than n and insert
                if (insert.next == null || insert.next.val > n.val) {
                    ListNode temp = insert.next;
                    insert.next = n;
                    n.next = temp;
                    break;
                }
                insert = insert.next;
            }
        }
        return result.next;
    }
}
