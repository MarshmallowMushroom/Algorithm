/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode p; 
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        p = head;
        //get the length of the linkedlist
        int length = 0;
        ListNode t = head;
        while(t != null) {
            t = t.next;
            length++;
        }
        return buildList(head, length);
    }
    
    public TreeNode buildList(ListNode head, int length) {
        if (length == 0)
            return null;
        if (length == 1) {
            TreeNode tmp = new TreeNode(p.val);
            p = p.next;
            return tmp;
        }
        TreeNode left = buildList(head, length/2);
        TreeNode root = new TreeNode(p.val);
        p = p.next;
        TreeNode right = buildList(head, length - length/2 - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}
