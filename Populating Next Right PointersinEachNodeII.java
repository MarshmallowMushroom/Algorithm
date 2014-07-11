/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        TreeLinkNode curr = root;
        TreeLinkNode dummy = new TreeLinkNode(-1);
        dummy.next = root;
        while(dummy.next != null) {
            curr = dummy.next;
            dummy = new TreeLinkNode(-1);
            TreeLinkNode tmp = dummy;
            while(curr != null) {
                if (curr.left != null) {
                    tmp.next = curr.left;
                    tmp = tmp.next;
                }
                if (curr.right != null) {
                    tmp.next = curr.right;
                    tmp = curr.right;
                }
                curr = curr.next;
            }
        }
    }
}
